/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.HoiDongBaoVeKhoaLuan;
import com.thao.service.HoiDongBaoVeKhoaLuanService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chung Vu
 */
@RestController
@RequestMapping("/api")
public class ApiHoiDongBaoVeKhoaLuanController {
    @Autowired
    private HoiDongBaoVeKhoaLuanService hdSer;
    
    @GetMapping("/hoiDongs/")
    public ResponseEntity<List<HoiDongBaoVeKhoaLuan>> list(@RequestParam Map<String,String> params){
        return new ResponseEntity<>(this.hdSer.getHoiDongBaoVeKhoaLuans(params), HttpStatus.OK);
    }
}
