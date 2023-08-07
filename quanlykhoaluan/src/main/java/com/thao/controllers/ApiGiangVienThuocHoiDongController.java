/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.service.GiangVienThuocHoiDongService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chung Vu
 */
@RestController
@RequestMapping("/api")
public class ApiGiangVienThuocHoiDongController {
    @Autowired
    private GiangVienThuocHoiDongService gvthds;
    
    @GetMapping("/giangVienThuocHoiDongs/")
    public ResponseEntity<List<GiangVienThuocHoiDong>> list(@RequestParam Map<String,String> params){
        return new ResponseEntity<>(this.gvthds.getGiangVienThuocHoiDong(params), HttpStatus.OK);
    }
    
    @PostMapping("/giangVienThuocHoiDongs/addGiangVienThuocHoiDong/")
    @ResponseStatus(HttpStatus.OK)
    public void addGiangVienThuocHoiDong(@ModelAttribute(value="giangVienThuocHoiDong") @Valid GiangVienThuocHoiDong gv, BindingResult rs){
        if(!rs.hasErrors())
            this.gvthds.addGiangVienThuocHoiDong(gv);
    }
}
