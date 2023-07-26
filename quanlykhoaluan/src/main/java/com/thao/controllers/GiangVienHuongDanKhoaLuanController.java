/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.service.GiangVienHuongDanKhoaLuanService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Chung Vu
 */
@Controller
public class GiangVienHuongDanKhoaLuanController {
    @Autowired
    private GiangVienHuongDanKhoaLuanService giangVienHuongDanKhoaLuanService;
    
    @RequestMapping("/giangvienhuongdankhoaluan")
    public String giangVienHuongDanKhoaLuan(@RequestParam Map<String, String> params){
        this.giangVienHuongDanKhoaLuanService.addGiangVienHuongDanKhoaLuan(Integer.parseInt(params.get("giangVienId")), Integer.parseInt(params.get("khoaLuanId")));
        return "index";
    }
}
