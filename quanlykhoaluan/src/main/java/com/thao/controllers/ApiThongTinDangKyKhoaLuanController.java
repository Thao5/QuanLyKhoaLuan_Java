/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.ThongTinDangKyKhoaLuan;
import com.thao.service.NguoiDungService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chung Vu
 */
@RestController
@RequestMapping("/api")
public class ApiThongTinDangKyKhoaLuanController {
    
    @Autowired
    private NguoiDungService ndSer;
    
    public static HttpSession sessionTmp;

    @PostMapping(value = "/documents/upload/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
    public ResponseEntity<ThongTinDangKyKhoaLuan> dangKyKhoaLuan(HttpSession session, /*@RequestBody Map<String, String> params*/@RequestBody ThongTinDangKyKhoaLuan kl /*@RequestBody Map<String, List<Integer>> arrays*/) {
        Map<String, ThongTinDangKyKhoaLuan> kls;
        if(sessionTmp == null)
            kls = (Map<String, ThongTinDangKyKhoaLuan>) session.getAttribute("kls");
        else
            kls = (Map<String, ThongTinDangKyKhoaLuan>) sessionTmp.getAttribute("kls");
        if (kls == null) {
            kls = new HashMap<>();
        }
//        if (!kls.containsKey(params.get("studentCode"))) {
//            ThongTinDangKyKhoaLuan kl = new ThongTinDangKyKhoaLuan();
//            kl.setStudentCode(params.get("studentCode"));
//            kl.setTitle(params.get("title"));
//            kl.setAuthor(params.get("author"));
//            kl.setDescription(params.get("description"));
//            kl.setCategories(arrays.get("categories"));
//            kl.setMentor(arrays.get("mentor"));
//        }
            if(!kls.containsKey(kl.getStudentCode()) && this.ndSer.getNguoiDungByUsername(kl.getStudentCode()).getKhoaLuanId() == null){
                kls.put(kl.getStudentCode(), kl);
            }

        session.setAttribute("kls", kls);
        if(sessionTmp == null){
            sessionTmp = session;
        }
        sessionTmp.setAttribute("kls", kls);
        if(this.ndSer.getNguoiDungByUsername(kl.getStudentCode()).getKhoaLuanId() != null){
            return new ResponseEntity(kl,HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(kl,HttpStatus.OK);
    }
    
//    @GetMapping(value = "/documents/upload/", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @CrossOrigin
//    @ResponseStatus(HttpStatus.OK)
//    public void dangKyKhoaLuan2(HttpSession session, @RequestBody Map<String, String> params/*@RequestBody ThongTinDangKyKhoaLuan kl*/ /*@RequestBody Map<String, List<Integer>> arrays*/) {
//        Map<String, ThongTinDangKyKhoaLuan> kls = (Map<String, ThongTinDangKyKhoaLuan>) session.getAttribute("kls");
//        if (kls == null) {
//            kls = new HashMap<>();
//        }
//        if (!kls.containsKey(params.get("studentCode"))) {
//            ThongTinDangKyKhoaLuan kl = new ThongTinDangKyKhoaLuan();
//            kl.setStudentCode(params.get("studentCode"));
//            kl.setTitle(params.get("title"));
//            kl.setAuthor(params.get("author"));
//            kl.setDescription(params.get("description"));
//            kl.setCategories(arrays.get("categories"));
//            kl.setMentor(arrays.get("mentor"));
//        }
//            if(!kls.containsKey(kl.getStudentCode())){
//                kls.put(kl.getStudentCode(), kl);
//            }
//
//        session.setAttribute("kls", kls);
//    }
}
