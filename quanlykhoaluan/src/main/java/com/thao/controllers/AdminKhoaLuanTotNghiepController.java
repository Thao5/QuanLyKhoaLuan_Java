/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.service.KhoaLuanTotNghiepService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Chung Vu
 */
@Controller
@RequestMapping("/admin")
public class AdminKhoaLuanTotNghiepController {
    @Autowired
    private KhoaLuanTotNghiepService klSer;
    
    @RequestMapping("/khoaluantotnghieps")
    public String list(@RequestParam Map<String, String> params, Model model){
        model.addAttribute("khoaLuans", this.klSer.getKhoaLuans(params));
        return "khoaluantotnghieps";
    }
    
    @GetMapping("/khoaluantotnghieps/{id}")
    public String kl(Model model, @PathVariable("id") int id){
        model.addAttribute("khoaLuan", this.klSer.getKhoaLuanById(id));
        return "updatekhoaluan";
    }
    
    @PostMapping("/khoaluantotnghieps")
    public String update(@ModelAttribute(value = "khoaLuan") @Valid KhoaLuanTotNghiep kl, BindingResult rs){
        if(!rs.hasErrors()){
            if(this.klSer.updateKhoaLuan(kl)){
                return "redirect:/";
            }
        }
        return "khoaluantotnghieps";
    }
}
