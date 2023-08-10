/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.GiangVienHuongDanKhoaLuan;
import com.thao.service.GiangVienHuongDanKhoaLuanService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ApiGiangVienHuongDanKhoaLuanController {
    @Autowired
    private GiangVienHuongDanKhoaLuanService gvhdkls;
    
    @GetMapping("/giangVienHuongDans/")
    public ResponseEntity<List<GiangVienHuongDanKhoaLuan>> list(@RequestParam Map<String,String> params){
        return new ResponseEntity<>(this.gvhdkls.getGiangVienHuongDans(params), HttpStatus.OK);
    }
    
    
    
//    @PostMapping("/giangVienHuongDans/addGiangVienHuongDan/")
//    @ResponseStatus(HttpStatus.OK)
//    public void addGiangVienHuongDan(@ModelAttribute(value="giangVienHuongDan")@Valid GiangVienHuongDanKhoaLuan gv, BindingResult rs){
//        if(!rs.hasErrors())
//            this.gvhdkls.addGiangVienHuongDanKhoaLuan(gv);
//    }
//    
//    @DeleteMapping("/giangVienHuongDans/delGiangVienHuongDan/{id}/")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delGiangVienHuongDan(@PathVariable(value = "id") int id){
//        this.gvhdkls.deleteGiangVienHuongDanKhoaLuan(id);
//    }
}
