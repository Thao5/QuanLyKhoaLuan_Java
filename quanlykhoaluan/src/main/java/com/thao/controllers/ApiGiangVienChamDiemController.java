/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.GiangVienChamDiem;
import com.thao.service.GiangVienChamDiemService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ApiGiangVienChamDiemController {
    @Autowired
    private GiangVienChamDiemService gvcds;
    
    @CrossOrigin
    @GetMapping("/giangVienChamDiems/")
    public ResponseEntity<List<GiangVienChamDiem>> list(@RequestBody Map<String,String> params){
        return new ResponseEntity<>(this.gvcds.getDiemKhoaLuan(params), HttpStatus.OK);
    }
    
    @PostMapping("/giangVienChamDiems/")
    @ResponseStatus(HttpStatus.OK)
    public void addGiangVienChamDiem(@RequestBody @Valid GiangVienChamDiem gv, BindingResult rs){
        if(!rs.hasErrors()){
            this.gvcds.addGiangVienChamDiem(gv);
        }
    }
    
    @PutMapping("/giangVienChamDiems/{id}/")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") int id, @RequestBody Map<String,String> params , BindingResult rs){
        if(!rs.hasErrors()){
            this.gvcds.updateGiangVienChamDiem(id, params);
        }
    }
    
//    
//    @DeleteMapping("/giangVienChamDiems/delGiangVienChamDiem/{id}/")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delGiangVienChamDiem(@PathVariable(value = "id") int id){
//        this.gvcds.deleteGiangVienChamDiem(id);
//    }
}
