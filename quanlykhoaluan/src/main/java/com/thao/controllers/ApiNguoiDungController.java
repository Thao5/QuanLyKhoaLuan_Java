/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.components.JwtService;
import com.thao.pojo.NguoiDung;
import com.thao.service.NguoiDungService;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Chung Vu
 */
@RestController
@RequestMapping("/api")
public class ApiNguoiDungController {
    @Autowired
    private NguoiDungService ndSer;
    @Autowired
    private JwtService jwtService;
    
    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody NguoiDung user) {
        if (this.ndSer.authNguoiDung(user.getTaiKhoan(), user.getMatKhau()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getTaiKhoan());
            
            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }
    
    @CrossOrigin
    @GetMapping("/nguoiDungs/{id}/")
    public ResponseEntity<NguoiDung> list(@PathVariable("id") int id){
        return new ResponseEntity<>(this.ndSer.getNguoiDungById(id), HttpStatus.OK);
    }
    
    @CrossOrigin
    @PutMapping(path = "/nguoiDungs/{id}/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NguoiDung> update(@PathVariable("id") int id, @RequestParam Map<String,String> params, @RequestPart MultipartFile avatar){
        Map<String,String> tmp = new HashMap<>();
        tmp.put("matKhau", params.get("matKhau"));
        return new ResponseEntity<>(this.ndSer.updateNguoiDung(id, tmp, avatar), HttpStatus.OK);
    }
    
    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<NguoiDung> details(Principal user) {
        NguoiDung u = this.ndSer.getNguoiDungByUsername(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
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
