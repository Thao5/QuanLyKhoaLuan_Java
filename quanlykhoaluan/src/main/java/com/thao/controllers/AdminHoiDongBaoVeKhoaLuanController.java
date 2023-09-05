/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.HoiDongBaoVeKhoaLuan;
import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.pojo.ThongTinGanKhoaLuanChoHoiDong;
import com.thao.pojo.ThongTinThanhLapHoiDong;
import com.thao.service.HoiDongBaoVeKhoaLuanService;
import com.thao.service.KhoaLuanTotNghiepService;
import com.thao.service.NguoiDungService;
import com.thao.service.ThongTinThanhLapHoiDongService;
import com.thao.utils.MailUtil;
import com.thao.validator.ThongTinGanKhoaLuanChoHoiDongWebAppValidator;
import com.thao.validator.ThongTinThanhLapHoiDongWebAppValidator;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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

/**
 *
 * @author Chung Vu
 */
@Controller
@RequestMapping("/admin")
public class AdminHoiDongBaoVeKhoaLuanController {

    @Autowired
    private HoiDongBaoVeKhoaLuanService hoiDongBaoVeKhoaLuanService;
    @Autowired
    private NguoiDungService ndSer;
    @Autowired
    private KhoaLuanTotNghiepService klSer;
    @Autowired
    private ThongTinThanhLapHoiDongService tttlhdSer;
    @Autowired
    private MailUtil mailUtil;
    @Autowired
    private ThongTinThanhLapHoiDongWebAppValidator thongTinThanhLapHoiDongWebAppValidator;
    

    

    @RequestMapping("/hoidongbaove")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("hoiDongs", this.hoiDongBaoVeKhoaLuanService.getHoiDongBaoVeKhoaLuans(params));
        return "hoidongbaove";
    }

    @GetMapping("/addorupdatehoidong/{id}")
    public String updateHoiDong(@PathVariable("id") int id, Model model) {
        model.addAttribute("hoiDong", this.hoiDongBaoVeKhoaLuanService.getHoiDongById(id));
        return "addorupdatehoidong";
    }

    @GetMapping("/addorupdatehoidong")
    public String addHoiDong(Model model) {
        model.addAttribute("hoiDong", new HoiDongBaoVeKhoaLuan());
        return "addorupdatehoidong";
    }

    @PostMapping("/addorupdatehoidong")
    public String addOrUpdateHoiDong(@ModelAttribute(value = "hoiDong") @Valid HoiDongBaoVeKhoaLuan hd, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (hd.getId() == null) {
                if (this.hoiDongBaoVeKhoaLuanService.addHoiDongBaoVeKhoaLuan(hd)) {
                    return "redirect:/";
                }
            }
            if (this.hoiDongBaoVeKhoaLuanService.updateHoiDongBaoVeKhoaLuan(hd)) {
                return "redirect:/";
            }
        }
        return "addorupdatehoidong";
    }

    @DeleteMapping("/deletehoidong/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNguoiDung(@PathVariable("id") int id) {
        this.hoiDongBaoVeKhoaLuanService.deleteHoiDong(id);
    }

    
    
    
}
