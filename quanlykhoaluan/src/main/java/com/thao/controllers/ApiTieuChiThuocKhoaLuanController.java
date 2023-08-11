/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.TieuChiThuocKhoaLuan;
import com.thao.service.TieuChiThuocKhoaLuanService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chung Vu
 */
@RestController
@RequestMapping("/api")
public class ApiTieuChiThuocKhoaLuanController {
    @Autowired
    private TieuChiThuocKhoaLuanService tcService;
    
    @CrossOrigin
    @GetMapping("/tieuChiThuocKhoaLuans/")
    public ResponseEntity<List<TieuChiThuocKhoaLuan>> list(@RequestBody Map<String,String> params){
        return new ResponseEntity<>(this.tcService.getTieuChiThuocKhoaLuans(params), HttpStatus.OK);
    }
    
//    @PostMapping("/tieuChiThuocKhoaLuans/addTieuChiThuocKhoaLuan/")
//    @ResponseStatus(HttpStatus.OK)
//    public void addTieuChiThuocKhoaLuan(@ModelAttribute(value="tieuChiThuocKhoaLuan") @Valid TieuChiThuocKhoaLuan tc, BindingResult rs){
//        if(!rs.hasErrors())
//            this.tcService.addTieuChiThuocKhoaLuan(tc);
//    }
//    
//    @DeleteMapping("/tieuChiThuocKhoaLuans/delTieuChiThuocKhoaLuan/{id}/")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delTieuChiThuocKhoaLuan(@PathVariable(value = "id") int id){
//        this.delTieuChiThuocKhoaLuan(id);
//    }
}
