/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.service.KhoaLuanTotNghiepService;
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
public class ApiKhoaLuanTotNghiepController {
    @Autowired
    private KhoaLuanTotNghiepService klSer;
    
    @GetMapping("/khoaLuans/")
    public ResponseEntity<List<KhoaLuanTotNghiep>> list(@RequestParam Map<String,String> params){
        return new ResponseEntity<>(this.klSer.getKhoaLuans(params), HttpStatus.OK);
    }
}
