/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.service.GiangVienThuocHoiDongService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Chung Vu
 */
@Controller
@RequestMapping("/admin")
public class AdminGiangVienThuocHoiDongController {
    @Autowired
    private GiangVienThuocHoiDongService gvthdSer;
    
    @RequestMapping("/giangvienthuochoidongs")
    public String list(Model model, @RequestParam Map<String,String> params){
        model.addAttribute("giangVienThuocHoiDongs", this.gvthdSer.getGiangVienThuocHoiDong(params));
        return "giangvienthuochoidongs";
    }
    
    @GetMapping("/addorupdategiangvienthuochoidong")
    public String gvthd(Model model){
        model.addAttribute("giangVienThuocHoiDong", new GiangVienThuocHoiDong());
        return "addorupdategiangvienthuochoidong";
    }
    
    @GetMapping("/addorupdategiangvienthuochoidong/{id}")
    public String update(Model model, @PathVariable("id") int id){
        model.addAttribute("giangVienThuocHoiDong", this.gvthdSer.getGiangVienThuocHoiDongById(id));
        return "addorupdategiangvienthuochoidong";
    }
    
    @PostMapping("/addorupdategiangvienthuochoidong")
    public String addOrUpdate(@ModelAttribute(value="giangVienThuocHoiDong") @Valid GiangVienThuocHoiDong gv, BindingResult rs){
        if(!rs.hasErrors()){
            if(gv.getId() == null){
                if(this.gvthdSer.addGiangVienThuocHoiDong(gv))
                    return "redirect:/";
            }else{
                if(this.gvthdSer.updateGiangvienThuocHoiDong(gv))
                    return "redirect:/";
            }
        }
        return "addorupdategiangvienthuochoidong";
    }
}
