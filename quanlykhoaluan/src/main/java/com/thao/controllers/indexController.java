/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.service.KhoaLuanTotNghiepService;
import com.thao.service.NguoiDungService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Chung Vu
 */
@Controller
public class indexController {
    @Autowired
    private KhoaLuanTotNghiepService khoaLuanService;
    
    @Autowired
    private NguoiDungService nguoiDungService;
    
    @RequestMapping(value="/")
    public String index(Model model, @RequestParam Map<String,String> params){
        model.addAttribute("nguoiDungs", nguoiDungService.getNguoiDungs(params));
        return "index";
    }
}
