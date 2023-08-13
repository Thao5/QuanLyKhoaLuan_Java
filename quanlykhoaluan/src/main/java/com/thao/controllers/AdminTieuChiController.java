/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.TieuChi;
import com.thao.service.TieuChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chung Vu
 */
@Controller
@RequestMapping("/admin")
public class AdminTieuChiController {
    @Autowired
    private TieuChiService tieuChiService;
    
    @GetMapping("/tieuchi")
    public String list(Model model){
        model.addAttribute("tieuChi", new TieuChi());
        return "tieuchi";
    }
    
    @PostMapping("/tieuchi")
    public String add(@ModelAttribute(value = "tieuChi") TieuChi tc){
        if(this.tieuChiService.addTieuChi(tc) == true)
            return "redirect:/";
        return "tieuchi";
    }
}
