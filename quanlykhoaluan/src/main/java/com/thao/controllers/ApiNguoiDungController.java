/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.NguoiDung;
import com.thao.service.NguoiDungService;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class ApiNguoiDungController {
    @Autowired
    private NguoiDungService ndSer;
    
    @GetMapping("/nguoiDungs/{id}")
    public ResponseEntity<NguoiDung> list(@PathVariable("id") int id){
        return new ResponseEntity<>(this.ndSer.getNguoiDungById(id), HttpStatus.OK);
    }
    
    @PutMapping("/nguoiDungs/doiMatKhau/{id}/")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") int id, @RequestBody Map<String,String> params){
        Map<String,String> tmp = new HashMap<>();
        tmp.put("matKhau", params.get("matKhau"));
        this.ndSer.updateNguoiDung(id, tmp);
    }
    
//    @PostMapping("/nguoiDungs/addNguoiDung/")
//    @ResponseStatus(HttpStatus.OK)
//    public void addNguoidung(@ModelAttribute(value = "nguoiDung") @Valid NguoiDung nd, BindingResult rs){
//        if(!rs.hasErrors())
//            this.ndSer.addNguoiDung(nd);
//    }
//    
//    @DeleteMapping("/nguoiDungs/delNguoiDung/{id}/")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteNguoiDung(@PathVariable(value = "id") int id){
//        this.ndSer.deleteNguoiDung(id);
//    }
}
