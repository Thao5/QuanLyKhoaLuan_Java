/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.service.HoiDongBaoVeKhoaLuanService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Chung Vu
 */
@Controller
public class HoiDongBaoVeKhoaLuanController {
    @Autowired
    private HoiDongBaoVeKhoaLuanService hoiDongBaoVeKhoaLuanService;
    
    @GetMapping("/updateHoiDong/{id}")
    public String updateHoiDong(@PathVariable("id") int id, @RequestParam Map<String,String> params){
        this.hoiDongBaoVeKhoaLuanService.updateHoiDongBaoVeKhoaLuan(id, params);
        return "index";
    }
}
