/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.ThongTinThanhLapHoiDong;
import com.thao.service.KhoaLuanTotNghiepService;
import com.thao.service.NguoiDungService;
import com.thao.service.ThongTinThanhLapHoiDongService;
import com.thao.utils.MailUtil;
import com.thao.validator.ThongTinThanhLapHoiDongWebAppValidator;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chung Vu
 */
@Controller
@RequestMapping("/admin")
public class AdminThongTinThanhLapHoiDongController {
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
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(thongTinThanhLapHoiDongWebAppValidator);
    }
    
    @GetMapping("/thanhlaphoidong")
    public String thanhLapHoiDong(Model model) {
        model.addAttribute("thongTinThanhLapHoiDong", new ThongTinThanhLapHoiDong());
        Map<String, String> tmp = new HashMap<>();
        tmp.put("vaiTro", "GIANG_VIEN");
        model.addAttribute("giangViens", this.ndSer.getNguoiDungs(tmp));
        model.addAttribute("khoaLuans", this.klSer.listKhoaLuanChuaCoHoiDong());
        return "thanhlaphoidong";
    }

    @PostMapping("/thanhlaphoidong")
    public String addThongTinThanhLapHoiDong(Model model, @ModelAttribute(value = "thongTinThanhLapHoiDong") @Valid ThongTinThanhLapHoiDong hd, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.tttlhdSer.addThongTinThanhLapHoiDong(hd)) {
                this.mailUtil.sendMail(this.ndSer.getNguoiDungById(hd.getGiangVienCT().getId()).getEmail(), String.format("Thong bao duoc chon vao %s", hd.getTenHoiDong()), "Vai Tro Chu Tich hoi dong");
                this.mailUtil.sendMail(this.ndSer.getNguoiDungById(hd.getGiangVienTK().getId()).getEmail(), String.format("Thong bao duoc chon vao %s", hd.getTenHoiDong()), "Vai Tro Thu Ky hoi dong");
                this.mailUtil.sendMail(this.ndSer.getNguoiDungById(hd.getGiangVienPB().getId()).getEmail(), String.format("Thong bao duoc chon vao %s", hd.getTenHoiDong()), "Vai Tro Phan Bien hoi dong");
                if(hd.getGiangVienTV1() != null){
                    this.mailUtil.sendMail(this.ndSer.getNguoiDungById(hd.getGiangVienTV1().getId()).getEmail(), String.format("Thong bao duoc chon vao %s", hd.getTenHoiDong()), "Vai Tro Thanh Vien hoi dong");
                }
                if(hd.getGiangVienTV2() != null){
                    this.mailUtil.sendMail(this.ndSer.getNguoiDungById(hd.getGiangVienTV2().getId()).getEmail(), String.format("Thong bao duoc chon vao %s", hd.getTenHoiDong()), "Vai Tro Thanh Vien hoi dong");
                }
                return "redirect:/";
            }
        }
        Map<String, String> tmp = new HashMap<>();
        tmp.put("vaiTro", "GIANG_VIEN");
        model.addAttribute("giangViens", this.ndSer.getNguoiDungs(tmp));
        model.addAttribute("khoaLuans", this.klSer.listKhoaLuanChuaCoHoiDong());
        return "thanhlaphoidong";
    }
}
