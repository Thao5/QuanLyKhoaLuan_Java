/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.GiangVienHuongDanKhoaLuan;
import com.thao.service.GiangVienHuongDanKhoaLuanService;
import com.thao.service.KhoaLuanTotNghiepService;
import com.thao.service.NguoiDungService;
import com.thao.validator.GiangVienHuongDanWebAppValidator;
import com.thao.validator.SoLuongKhoaLuanValidator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 *
 * @author Chung Vu
 */
@Controller
@RequestMapping("/admin")
public class AdminGiangVienHuongDanKhoaLuanController {

    @Autowired
    private GiangVienHuongDanKhoaLuanService giangVienHuongDanKhoaLuanService;
    @Autowired
    private NguoiDungService ndSer;
    @Autowired
    private KhoaLuanTotNghiepService klSer;
    @Autowired
    private GiangVienHuongDanWebAppValidator giangVienHuongDanValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(giangVienHuongDanValidator);
    }

    @RequestMapping("/giangvienhuongdan")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("giangVienHuongDans", this.giangVienHuongDanKhoaLuanService.getGiangVienHuongDanByKhoaLuanId(params));
        return "giangvienhuongdan";
    }

    @GetMapping("/addorupdategiangvienhuongdan")
    public String gvhd(Model model) {
        Map<String, String> tmp = new HashMap<>();
        tmp.put("vaiTro", "GIANG_VIEN");
        model.addAttribute("giangVienHuongDan", new GiangVienHuongDanKhoaLuan());
        model.addAttribute("giangViens", this.ndSer.getNguoiDungs(tmp));
        model.addAttribute("khoaLuans", this.klSer.getKhoaLuans(tmp));
        return "addorupdategiangvienhuongdan";
    }

    @GetMapping("/addorupdategiangvienhuongdan/{id}")
    public String updateGvhd(Model model, @PathVariable("id") int id) {
        Map<String, String> tmp = new HashMap<>();
        tmp.put("vaiTro", "GIANG_VIEN");
        model.addAttribute("giangVienHuongDan", this.giangVienHuongDanKhoaLuanService.getGiangVienHuongDanKhoaLuanById(id));
        model.addAttribute("giangViens", this.ndSer.getNguoiDungs(tmp));
        model.addAttribute("khoaLuans", this.klSer.getKhoaLuans(tmp));
        return "addorupdategiangvienhuongdan";
    }

    @PostMapping("/addorupdategiangvienhuongdan")
    public String add(@ModelAttribute(value = "giangVienHuongDan") @Valid GiangVienHuongDanKhoaLuan gv, BindingResult rs, Model model) {

        if (!rs.hasErrors()) {
            gv.setKhoaLuanId(this.klSer.getKhoaLuanById(gv.getKhoaLuanId().getId()));
            gv.setNguoiDungId(this.ndSer.getNguoiDungById(gv.getNguoiDungId().getId()));
            if (gv.getId() != null) {

                if (this.giangVienHuongDanKhoaLuanService.updateGiangVienHuongDanKhoaLuan(gv)) {
                    return "redirect:/";
                }
            } else {
                gv.setNgayBatDauHuongDan(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
                if (this.giangVienHuongDanKhoaLuanService.addGiangVienHuongDanKhoaLuan(gv)) {
                    return "redirect:/";
                }
            }
        } else {
            Map<String, String> tmp = new HashMap<>();
            tmp.put("vaiTro", "GIANG_VIEN");
            model.addAttribute("giangViens", this.ndSer.getNguoiDungs(tmp));
            model.addAttribute("khoaLuans", this.klSer.getKhoaLuans(tmp));
        }
        return "addorupdategiangvienhuongdan";
    }

    @DeleteMapping("/deletegiangvienhuongdan/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        this.giangVienHuongDanKhoaLuanService.deleteGiangVienHuongDanKhoaLuan(id);
    }
}
