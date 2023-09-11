/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import static com.thao.controllers.ApiThongTinDangKyKhoaLuanController.sessionTmp;
import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.pojo.NguoiDung;
import com.thao.pojo.ThongTinDangKyKhoaLuan;
import com.thao.service.GiangVienChamDiemService;
import com.thao.service.HoiDongBaoVeKhoaLuanService;
import com.thao.service.KhoaLuanTotNghiepService;
import com.thao.service.NguoiDungService;
import com.thao.service.TieuChiThuocKhoaLuanService;
import com.thao.utils.MailUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Chung Vu
 */
@Controller
@RequestMapping("/admin")
public class AdminKhoaLuanTotNghiepController {

    @Autowired
    private KhoaLuanTotNghiepService klSer;

    @Autowired
    private HoiDongBaoVeKhoaLuanService hdSer;

    @Autowired
    private TieuChiThuocKhoaLuanService tctklSer;

    @Autowired
    private NguoiDungService ndSer;

    @Autowired
    private GiangVienChamDiemService gvcdSer;
    
    @Autowired
    private Environment env;

    @Autowired
    private MailUtil mailUtil;

    @RequestMapping("/khoaluantotnghieps")
    public String list(@RequestParam Map<String, String> params, Model model) {
        Map<String,String> tmp = new HashMap<>();
        List<KhoaLuanTotNghiep> listKLPages = this.klSer.getKhoaLuans(tmp);
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages", Math.ceil(listKLPages.size()*1.0/pageSize));
        model.addAttribute("khoaLuans", this.klSer.getKhoaLuans(params));
        model.addAttribute("diemKL", this.gvcdSer.getDiemKhoaLuan(params));
        model.addAttribute("DTB", this.gvcdSer.getDTBKL(params));
        return "khoaluantotnghieps";
    }

    @GetMapping("/addorupdatekhoaluan/{id}")
    public String kl(Model model, @PathVariable("id") int id) {
        model.addAttribute("khoaLuan", this.klSer.getKhoaLuanById(id));
        model.addAttribute("hoiDongs", this.hdSer.getHoiDongBaoVeKhoaLuans(null));
        List<String> listNganh = new ArrayList<>();
        listNganh.add("CNTT");
        listNganh.add("KHMT");
        listNganh.add("HTQLTT");
        listNganh.add("Anh ngữ");
        listNganh.add("Nhật ngữ");
        listNganh.add("Môi trường");
        listNganh.add("Tâm lý học");
        model.addAttribute("listNganh", listNganh);
        return "addorupdatekhoaluan";
    }

    @GetMapping("/addorupdatekhoaluan")
    public String addKl(Model model) {
        model.addAttribute("khoaLuan", new KhoaLuanTotNghiep());
        return "addorupdatekhoaluan";
    }

    @PostMapping("/addorupdatekhoaluan")
    public String addOrUpdate(@ModelAttribute(value = "khoaLuan") @Valid KhoaLuanTotNghiep kl, BindingResult rs, Model model) {
        if (!rs.hasErrors()) {
            if (this.klSer.updateKhoaLuan(kl)) {
                return "redirect:/";
            }
        }
        List<String> listNganh = new ArrayList<>();
        listNganh.add("CNTT");
        listNganh.add("KHMT");
        listNganh.add("HTQLTT");
        listNganh.add("Anh ngữ");
        listNganh.add("Nhật ngữ");
        listNganh.add("Môi trường");
        listNganh.add("Tâm lý học");
        model.addAttribute("listNganh", listNganh);
        model.addAttribute("hoiDongs", this.hdSer.getHoiDongBaoVeKhoaLuans(null));
        return "addorupdatekhoaluan";
    }

    @RequestMapping("/thongtindangkykhoaluans")
    public String listThongTinDangKy(Model model, HttpSession session) {
        session = sessionTmp;
        System.out.println("thong tin khoa luan");
        if (session != null) {
            if (session.getAttribute("kls") != null) {
                Map<String, ThongTinDangKyKhoaLuan> kls = (Map<String, ThongTinDangKyKhoaLuan>) session.getAttribute("kls");
                if (kls != null) {
                    model.addAttribute("thongTinDangKys", kls.values());
                    model.addAttribute("kltn", new KhoaLuanTotNghiep());
                    return "thongtindangkykhoaluans";
                }
            }
        }
        model.addAttribute("thongTinDangKys", null);
        return "thongtindangkykhoaluans";
    }

//    @GetMapping("/thongtindangkykhoaluans/{studentCode}")
//    public String addThongTinDangKyKhoaLuan(Model model, @PathVariable("studentCode") String studentCode){
//        
//        model.addAttribute("kltn", new KhoaLuanTotNghiep());
//        return "thongtindangkykhoaluans";
//    }
    @PostMapping("/thongtindangkykhoaluans/{studentCode}")
    public String addThongTin(@PathVariable("studentCode") String studentCode, @ModelAttribute(value = "kltn") KhoaLuanTotNghiep kltn) {
        Map<String, ThongTinDangKyKhoaLuan> kls = (Map<String, ThongTinDangKyKhoaLuan>) sessionTmp.getAttribute("kls");
        ThongTinDangKyKhoaLuan kl = kls.get(studentCode);
        if (this.klSer.addKhoaLuanTheoThongTinDangKy(kl, kltn)) {
            kls.remove(studentCode);
            sessionTmp.setAttribute("kls", kls);
            mailUtil.sendMail(this.ndSer.getNguoiDungByUsername(studentCode).getEmail(), "Thong bao khoa luan da duoc chap nhan", "Khoa luan cua ban da duoc chap nhan");
            return "thongtindangkykhoaluans";
        }
        return "thongtindangkykhoaluans";
    }

    @DeleteMapping("/deletekhoaluan/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKhoaLuan(@PathVariable("id") int id) {
        this.klSer.deleteKhoaLuan(id);
    }

    @DeleteMapping("/deletekhoaluanchoduyet/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKhoaLuanChoDuyet(@PathVariable("id") String id) {
        Map<String, ThongTinDangKyKhoaLuan> kls = (Map<String, ThongTinDangKyKhoaLuan>) sessionTmp.getAttribute("kls");
        kls.remove(id);
        sessionTmp.setAttribute("kls", kls);
        mailUtil.sendMail(this.ndSer.getNguoiDungByUsername(id).getEmail(), "Thong bao khoa luan da bi huy", "Khoa luan cua ban da bi huy");
    }

    @GetMapping("/gankhoaluanchosinhvien/{id}")
    public String ganKhoaLuan(@PathVariable("id") int id, Model model) {
        model.addAttribute("klID", id);
        model.addAttribute("sinhViens", this.ndSer.getSinhVienChuaCoKL());
        return "gankhoaluanchosinhvien";
    }

    @PostMapping("/gankhoaluanchosinhvien/{id}")
    public String ganKhoaLuan(Model model,@RequestParam Map<String, String> params, @PathVariable("id") int id) {
        NguoiDung nd = this.ndSer.getNguoiDungById(Integer.parseInt(params.get("ndID")));
        if (nd.getKhoaLuanId() != null) {
            model.addAttribute("klID", id);
            model.addAttribute("sinhViens", this.ndSer.getSinhVienChuaCoKL());
            return "gankhoaluanchosinhvien";
        }
        nd.setKhoaLuanId(this.klSer.getKhoaLuanById(id));
        if (this.ndSer.updateNguoiDung(nd)) {
            return "redirect:/";
        }
        model.addAttribute("klID", id);
        model.addAttribute("sinhViens", this.ndSer.getSinhVienChuaCoKL());
        return "gankhoaluanchosinhvien";
    }
}
