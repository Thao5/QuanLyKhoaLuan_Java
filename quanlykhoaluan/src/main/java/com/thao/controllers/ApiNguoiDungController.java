/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.NguoiDung;
import com.thao.service.NguoiDungService;
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
public class ApiNguoiDungController {
    @Autowired
    private NguoiDungService ndSer;
    
    @GetMapping("/nguoiDungs/")
    public ResponseEntity<List<NguoiDung>> list(@RequestParam Map<String,String> params){
        return new ResponseEntity<>(this.ndSer.getNguoiDungs(params), HttpStatus.OK);
    }
    
    @PostMapping("/nguoiDungs/addNguoiDung/")
    @ResponseStatus(HttpStatus.OK)
    public void addNguoidung(@ModelAttribute(value = "nguoiDung") @Valid NguoiDung nd, BindingResult rs){
        if(!rs.hasErrors())
            this.ndSer.addNguoiDung(nd);
    }
    
    @DeleteMapping("/nguoiDungs/delNguoiDung/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNguoiDung(@PathVariable(value = "id") int id){
        this.ndSer.deleteNguoiDung(id);
    }
}
