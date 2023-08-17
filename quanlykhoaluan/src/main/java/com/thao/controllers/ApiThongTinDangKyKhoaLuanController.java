/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.ThongTinDangKyKhoaLuan;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ApiThongTinDangKyKhoaLuanController {
    
    
    @CrossOrigin
    @PostMapping("/documents/upload/")
    @ResponseStatus(HttpStatus.OK)
    public void dangKyKhoaLuan(HttpSession session, @RequestBody ThongTinDangKyKhoaLuan kl){
        Map<String, ThongTinDangKyKhoaLuan> kls = (Map<String, ThongTinDangKyKhoaLuan>) session.getAttribute("kls");
        if(kls == null){
            kls = new HashMap<>();
        } 
        if(!kls.containsKey(kl.getStudentCode())){
            kls.put(kl.getStudentCode(), kl);
            
        }
        session.setAttribute("kls", kls);
    }
}
