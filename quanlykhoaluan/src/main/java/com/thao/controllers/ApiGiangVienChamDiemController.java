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
public class ApiGiangVienChamDiemController {
    @Autowired
    private GiangVienChamDiemService gvcds;
    
    @GetMapping("/giangVienChamDiems/")
    public ResponseEntity<List<GiangVienChamDiem>> list(@RequestParam Map<String,String> params){
        return new ResponseEntity<>(this.gvcds.getDiemKhoaLuan(params), HttpStatus.OK);
    }
    
    @PostMapping("/giangVienChamDiems/addGiangVienChamDiem/")
    @ResponseStatus(HttpStatus.OK)
    public void addGiangVienChamDiem(@ModelAttribute(value="giangVienChamDiem") @Valid GiangVienChamDiem gv, BindingResult rs){
        if(!rs.hasErrors()){
            this.gvcds.addGiangVienChamDiem(gv);
        }
    }
    
    @DeleteMapping("/giangVienChamDiems/delGiangVienChamDiem/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delGiangVienChamDiem(@PathVariable(value = "id") int id){
        this.gvcds.deleteGiangVienChamDiem(id);
    }
}
