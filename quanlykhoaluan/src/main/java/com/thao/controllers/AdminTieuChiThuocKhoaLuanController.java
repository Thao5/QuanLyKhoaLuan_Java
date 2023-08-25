/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.pojo.TieuChiThuocKhoaLuan;
import com.thao.service.KhoaLuanTotNghiepService;
import com.thao.service.TieuChiService;
import com.thao.service.TieuChiThuocKhoaLuanService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Chung Vu
 */
@Controller
@RequestMapping("/admin")
public class AdminTieuChiThuocKhoaLuanController {
    @Autowired
    private TieuChiThuocKhoaLuanService tctklSer;
    @Autowired
    private KhoaLuanTotNghiepService klSer;
    @Autowired
    private TieuChiService tcSer;
    
    @RequestMapping("/tieuchithuockhoaluans")
    public String list(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("tieuChiThuocKhoaLuans", this.tctklSer.getTieuChiThuocKhoaLuans(params));
        return "tieuchithuockhoaluans";
    }
    
    @GetMapping("/addtieuchithuockhoaluan/{klid}")
    public String tieuChiThuocKhoaLuan(Model model, @PathVariable("klid") int klid){
        TieuChiThuocKhoaLuan tctkl = new TieuChiThuocKhoaLuan();
        tctkl.setKhoaLuanId(this.klSer.getKhoaLuanById(klid));
        model.addAttribute("tieuChiThuocKhoaLuan", tctkl);
        model.addAttribute("tieuChis", this.tcSer.getTieuChis(null));
        return "addorupdatetieuchithuockhoaluan";
    }
    
    @GetMapping("/updatetieuchithuockhoaluan/{id}")
    public String update(Model model, @PathVariable("id") int id){
        model.addAttribute("tieuChiThuocKhoaLuan", this.tctklSer.getTieuChiThuocKhoaLuanById(id));
        model.addAttribute("tieuChis", this.tcSer.getTieuChis(null));
        return "addorupdatetieuchithuockhoaluan";
    }
    
    @PostMapping("/addorupdatetieuchithuockhoaluan")
    public String addOrUpdate(Model model,@ModelAttribute(value="tieuChiThuocKhoaLuan") @Valid TieuChiThuocKhoaLuan tctkl, BindingResult rs){
        if(!rs.hasErrors())
            if(tctkl.getId() == null)
            {
                if(this.tctklSer.addTieuChiThuocKhoaLuan(tctkl))
                    return "redirect:/";
            } else{
                if(this.tctklSer.updateTieuChiThuocKhoaLuan(tctkl))
                    return "redirect:/";
            }
        model.addAttribute("tieuChis", this.tcSer.getTieuChis(null));
        return "addorupdatetieuchithuockhoaluan";
    }
    
    @DeleteMapping("/deletetieuchithuockhoaluan/{klId}/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id, @PathVariable("klId") int klId) {
        this.tctklSer.deleteTieuChiThuocKhoaLuan(id, klId);
    }
}
