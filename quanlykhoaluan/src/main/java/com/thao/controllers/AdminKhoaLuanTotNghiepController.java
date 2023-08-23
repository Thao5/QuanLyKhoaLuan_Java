/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.pojo.ThongTinDangKyKhoaLuan;
import com.thao.service.HoiDongBaoVeKhoaLuanService;
import com.thao.service.KhoaLuanTotNghiepService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @RequestMapping("/khoaluantotnghieps")
    public String list(@RequestParam Map<String, String> params, Model model){
        model.addAttribute("khoaLuans", this.klSer.getKhoaLuans(params));
        return "khoaluantotnghieps";
    }
    
    @GetMapping("/addorupdatekhoaluan/{id}")
    public String kl(Model model, @PathVariable("id") int id){
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
    public String addKl(Model model){
        model.addAttribute("khoaLuan", new KhoaLuanTotNghiep());
        return "addorupdatekhoaluan";
    }
    
    @PostMapping("/addorupdatekhoaluan")
    public String addorupdate(@ModelAttribute(value = "khoaLuan") @Valid KhoaLuanTotNghiep kl, BindingResult rs, Model model){
        if(!rs.hasErrors()){
            if(this.klSer.updateKhoaLuan(kl)){
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
    public String listThongTinDangKy(Model model, HttpSession session){
        session = ApiThongTinDangKyKhoaLuanController.sessionTmp;
        if(session.getAttribute("kls") != null) System.out.println("session khong null");
        else  System.out.println("session null");
        Map<String, ThongTinDangKyKhoaLuan> kls = (Map<String, ThongTinDangKyKhoaLuan>) session.getAttribute("kls");
        if(kls != null)
            model.addAttribute("thongTinDangKys", kls.values());
        else
            model.addAttribute("thongTinDangKys", null);
        return "thongtindangkykhoaluans";
    }
    
    @DeleteMapping("/deletekhoaluan/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKhoaLuan(@PathVariable("id") int id){
        this.klSer.deleteKhoaLuan(id);
    }
}
