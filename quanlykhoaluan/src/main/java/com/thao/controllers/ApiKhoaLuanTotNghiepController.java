/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.service.KhoaLuanTotNghiepService;
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
public class ApiKhoaLuanTotNghiepController {
    @Autowired
    private KhoaLuanTotNghiepService klSer;
    
    @GetMapping("/khoaLuans/{id}")
    public ResponseEntity<KhoaLuanTotNghiep> list(@PathVariable("id") int id){
        return new ResponseEntity<>(this.klSer.getKhoaLuanById(id), HttpStatus.OK);
    }
    
//    @PostMapping("/khoaLuans/addKhoaLuan/")
//    @ResponseStatus(HttpStatus.OK)
//    public void addKhoaLuan(@ModelAttribute(value = "khoaLuan") @Valid KhoaLuanTotNghiep kl, BindingResult rs){
//        if(!rs.hasErrors())
//            this.klSer.addKhoaLuan(kl);
//    }
//    
//    @DeleteMapping("/khoaLuans/delKhoaLuan/{id}/")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delKhoaLuan(@PathVariable(value = "id") int id){
//        this.klSer.deleteKhoaLuan(id);
//    }
}
