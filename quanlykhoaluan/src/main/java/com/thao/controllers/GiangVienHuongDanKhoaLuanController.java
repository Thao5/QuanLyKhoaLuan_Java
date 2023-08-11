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
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 *
 * @author Chung Vu
 */
@Controller
public class GiangVienHuongDanKhoaLuanController {

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

    @GetMapping("/giangvienhuongdankhoaluan")
    public String list(Model model) {
        Map<String, String> tmp = new HashMap<>();
        tmp.put("vaiTro", "GIANG_VIEN");
        model.addAttribute("giangVienHuongDan", new GiangVienHuongDanKhoaLuan());
        model.addAttribute("giangViens", this.ndSer.getNguoiDungs(tmp));
        model.addAttribute("khoaLuans", this.klSer.getKhoaLuans(tmp));
        return "giangvienhuongdan";
    }

    @PostMapping("/giangvienhuongdankhoaluan")
    public String add(@ModelAttribute(value = "giangVienHuongDan") @Valid GiangVienHuongDanKhoaLuan gv, BindingResult rs, Model model) {

        if (!rs.hasErrors()) {
            if (this.giangVienHuongDanKhoaLuanService.addGiangVienHuongDanKhoaLuan(gv)) {
                return "redirect:/";
            }
        } else {
            Map<String, String> tmp = new HashMap<>();
            tmp.put("vaiTro", "GIANG_VIEN");
            model.addAttribute("giangViens", this.ndSer.getNguoiDungs(tmp));
            model.addAttribute("khoaLuans", this.klSer.getKhoaLuans(tmp));
        }
        return "giangvienhuongdan";
    }
}
