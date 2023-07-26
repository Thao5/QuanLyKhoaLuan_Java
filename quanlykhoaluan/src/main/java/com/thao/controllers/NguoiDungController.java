/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.NguoiDung;
import com.thao.service.NguoiDungService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Chung Vu
 */
@Controller
public class NguoiDungController {
    @Autowired
    private NguoiDungService nguoiDungService;
    
    private int userId;
    
    @GetMapping("/nguoidung")
    public String list(Model model){
        model.addAttribute("nguoiDung", new NguoiDung());
        return "nguoidung";
    }
    
    @PostMapping("/nguoidung")
    public String add(@ModelAttribute(value="nguoiDung") NguoiDung nd){
        if(this.nguoiDungService.addNguoiDung(nd) == true)
            return "redirect:/";
        return "nguoidung";
    }
    
    @RequestMapping("/ganKhoaLuanChoSinhVien")
    public String ganKhoaLuanChoSinhVien(@RequestParam Map<String,String> params){
        this.nguoiDungService.ganKhoaLuanChoSinhVien(Integer.parseInt(params.get("userId")), Integer.parseInt(params.get("khoaLuanId")));
        return "index";
    }
}
