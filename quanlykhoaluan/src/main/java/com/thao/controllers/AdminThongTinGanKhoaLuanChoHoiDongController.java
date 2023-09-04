/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.pojo.ThongTinGanKhoaLuanChoHoiDong;
import com.thao.service.HoiDongBaoVeKhoaLuanService;
import com.thao.service.KhoaLuanTotNghiepService;
import com.thao.validator.ThongTinGanKhoaLuanChoHoiDongWebAppValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/admin")
public class AdminThongTinGanKhoaLuanChoHoiDongController {

    @Autowired
    private ThongTinGanKhoaLuanChoHoiDongWebAppValidator thongTinGanKhoaLuanChoHoiDongWebAppValidator;
    @Autowired
    private KhoaLuanTotNghiepService klSer;
    @Autowired
    private HoiDongBaoVeKhoaLuanService hdSer;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(thongTinGanKhoaLuanChoHoiDongWebAppValidator);
    }

    @GetMapping("/gankhoaluanchohoidong/{id}")
    public String klChoHd(@PathVariable("id") int id, Model model) {
        ThongTinGanKhoaLuanChoHoiDong ttgkl = new ThongTinGanKhoaLuanChoHoiDong();
        ttgkl.setId(id);
        model.addAttribute("thongTinGanKhoaLuanChoHoiDong", ttgkl);
        model.addAttribute("idHD", id);
        model.addAttribute("listKhoaLuanChuaCoHoiDong", this.klSer.listKhoaLuanChuaCoHoiDong());
        return "gankhoaluanchohoidong";
    }

    @PostMapping("/gankhoaluanchohoidong")
    public String addKlChoHd(Model model, @ModelAttribute(value = "thongTinGanKhoaLuanChoHoiDong") @Valid ThongTinGanKhoaLuanChoHoiDong ttgkl, BindingResult rs) {
        if (!rs.hasErrors()) {
            KhoaLuanTotNghiep kl2 = this.klSer.getKhoaLuanById(ttgkl.getKl2().getId());
            kl2.setHoiDongId(this.hdSer.getHoiDongById(ttgkl.getId()));
            this.klSer.updateKhoaLuan(kl2);
            if (ttgkl.getKl3() != null) {
                KhoaLuanTotNghiep kl3 = this.klSer.getKhoaLuanById(ttgkl.getKl3().getId());
                kl3.setHoiDongId(this.hdSer.getHoiDongById(ttgkl.getId()));
                this.klSer.updateKhoaLuan(kl3);
            }
            if (ttgkl.getKl4() != null) {
                KhoaLuanTotNghiep kl4 = this.klSer.getKhoaLuanById(ttgkl.getKl4().getId());
                kl4.setHoiDongId(this.hdSer.getHoiDongById(ttgkl.getId()));
                this.klSer.updateKhoaLuan(kl4);
            }
            if (ttgkl.getKl5() != null) {
                KhoaLuanTotNghiep kl5 = this.klSer.getKhoaLuanById(ttgkl.getKl5().getId());
                kl5.setHoiDongId(this.hdSer.getHoiDongById(ttgkl.getId()));
                this.klSer.updateKhoaLuan(kl5);
            }
            return "redirect:/";
        }
        model.addAttribute("thongTinGanKhoaLuanChoHoiDong", ttgkl);
        model.addAttribute("listKhoaLuanChuaCoHoiDong", this.klSer.listKhoaLuanChuaCoHoiDong());
        return "gankhoaluanchohoidong";
    }
}
