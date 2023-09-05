/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.GiangVienChamDiem;
import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.pojo.NguoiDung;
import com.thao.pojo.ThongTinGiangVienChamDiem;
import com.thao.pojo.TieuChi;
import com.thao.pojo.TieuChiThuocKhoaLuan;
import com.thao.service.GiangVienChamDiemService;
import com.thao.service.GiangVienThuocHoiDongService;
import com.thao.service.KhoaLuanTotNghiepService;
import com.thao.service.NguoiDungService;
import com.thao.service.TieuChiService;
import com.thao.service.TieuChiThuocKhoaLuanService;
import com.thao.validator.ThongTinGiangVienChamDiemWebAppValidator;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chung Vu
 */
@Controller
@RequestMapping("/giangvien")
public class GiangVienThongTinChamDiemController {

    @Autowired
    private TieuChiThuocKhoaLuanService tctkl;
    @Autowired
    private GiangVienChamDiemService gvcdSer;
    @Autowired
    private KhoaLuanTotNghiepService klSer;
    @Autowired
    private NguoiDungService ndSer;
    @Autowired
    private GiangVienThuocHoiDongService gvthdSer;
    @Autowired
    private TieuChiService tcSer;
    @Autowired
    private ThongTinGiangVienChamDiemWebAppValidator thongTinGiangVienChamDiemWebAppValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(thongTinGiangVienChamDiemWebAppValidator);
    }

    @RequestMapping("/danhsachchamdiem")
    public String listChamDiem(Model model) {
        List<KhoaLuanTotNghiep> listKLChamDiem = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Map<String, String> tmp = new HashMap<>();
        tmp.put("ndID", this.ndSer.getNguoiDungByUsername(auth.getName()).getId().toString());
        Map<String, String> tmp2 = new HashMap<>();
        for (GiangVienThuocHoiDong gv : this.gvthdSer.getGiangVienThuocHoiDong(tmp)) {
            tmp2.put("hoiDongId", gv.getHoiDongId().getId().toString());
            for (KhoaLuanTotNghiep kl : this.klSer.getKhoaLuans(tmp2)) {
                listKLChamDiem.add(kl);
            }
        }
        model.addAttribute("listChamDiem", listKLChamDiem);
        return "danhsachkhoaluanchamdiem";
    }

    @GetMapping("/chamdiem/{klId}")
    public String diem(Model model, @PathVariable("klId") int klId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ThongTinGiangVienChamDiem tt = new ThongTinGiangVienChamDiem();
        tt.setKlId(klId);
        tt.setNdId(this.ndSer.getNguoiDungByUsername(auth.getName()).getId());
        model.addAttribute("thongTinGiangVienChamDiem", tt);
        List<TieuChi> tcs = new ArrayList<>();
        for (TieuChiThuocKhoaLuan tc : this.tctkl.getTieuChiTheoKhoaLuan(klId)) {
            tcs.add(tc.getTieuChiId());
        }
        model.addAttribute("listTCCuaKL", tcs);
        return "chamdiem";
    }

    @PostMapping("/chamdiem")
    public String chamDiem(Model model, @ModelAttribute(value = "thongTinGiangVienChamDiem") @Valid ThongTinGiangVienChamDiem tt, BindingResult rs) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!rs.hasErrors()) {
            NguoiDung nd = this.ndSer.getNguoiDungByUsername(auth.getName());
            float sum = 0;
            for (TieuChi tc : tt.getListTC()) {
                sum += this.tcSer.getTieuChiById(tc.getId()).getDiem();
            }
            GiangVienChamDiem gv = new GiangVienChamDiem();
            gv.setDiem(sum);
            gv.setKhoaLuanId(this.klSer.getKhoaLuanById(tt.getKlId()));
            gv.setNgayCham(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
            gv.setGiangVienThuocHoiDongId(this.gvthdSer.getGiangVienThuocHoiDongByNguoiDungAndHoiDong(nd.getId(), this.klSer.getKhoaLuanById(tt.getKlId()).getHoiDongId().getId()));
            if (this.gvcdSer.addGiangVienChamDiem(gv)) {
                return "redirect:/";
            }
        }
        model.addAttribute("thongTinGiangVienChamDiem", tt);
        List<TieuChi> tcs = new ArrayList<>();
        for (TieuChiThuocKhoaLuan tc : this.tctkl.getTieuChiTheoKhoaLuan(tt.getKlId())) {
            tcs.add(tc.getTieuChiId());
        }
        model.addAttribute("listTCCuaKL", tcs);
        return "chamdiem";
    }
}
