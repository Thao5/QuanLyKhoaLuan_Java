/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.HoiDongBaoVeKhoaLuan;
import com.thao.service.HoiDongBaoVeKhoaLuanService;
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
public class ApiHoiDongBaoVeKhoaLuanController {
    @Autowired
    private HoiDongBaoVeKhoaLuanService hdSer;
    
    @CrossOrigin
    @GetMapping("/hoiDongs/")
    public ResponseEntity<List<HoiDongBaoVeKhoaLuan>> list(@RequestParam Map<String,String> params){
        return new ResponseEntity<>(this.hdSer.getHoiDongBaoVeKhoaLuans(params), HttpStatus.OK);
    }
    
//    @PostMapping("/hoiDongs/addHoiDong/")
//    @ResponseStatus(HttpStatus.OK)
//    public void addHoiDong(@ModelAttribute(value="hoiDong") @Valid HoiDongBaoVeKhoaLuan hd, BindingResult rs){
//        if(!rs.hasErrors())
//            this.hdSer.addHoiDongBaoVeKhoaLuan(hd);
//    }
//    
//    @DeleteMapping("/hoiDongs/delHoiDong/{id}/")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delHoiDong(@PathVariable(value = "id") int id){
//        this.hdSer.deleteHoiDong(id);
//    }
}
