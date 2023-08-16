/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pdf.PDFUtil;
import com.thao.pojo.GiangVienChamDiem;
import com.thao.service.GiangVienChamDiemService;
import com.thao.service.StatsService;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Chung Vu
 */
@Controller
@RequestMapping("/admin")
public class AdminGiangVienChamDiemController {
    @Autowired
    private GiangVienChamDiemService gvcdSer;
    @Autowired
    private StatsService statSer;
    
    @RequestMapping("/giangvienchamdiems")
    public String list(Model model, @RequestParam Map<String,String> params){
        model.addAttribute("giangVienChamDiems",  this.gvcdSer.getDiemKhoaLuan(params));
        return "giangvienchamdiems";
    }
    
    @GetMapping("/addorupdategiangvienchamdiem")
    public String gvcd(Model model){
        model.addAttribute("giangVienChamDiem", new GiangVienChamDiem());
        return "addorupdategiangvienchamdiem";
    }
    
    @GetMapping("/addorupdategiangvienchamdiem/{id}")
    public String update(Model model, @PathVariable("id") int id){
        model.addAttribute("giangVienChamDiem", this.gvcdSer.getGiangVienChamDiemById(id));
        return "addorupdategiangvienchamdiem";
    }
    
    @PostMapping("/addorupdategiangvienchamdiem")
    public String addOrUpdate(@ModelAttribute(value="giangVienChamDiem") @Valid GiangVienChamDiem gv, BindingResult rs){
        if(!rs.hasErrors())
        {
            if(gv.getId() == null){
                if(this.gvcdSer.addGiangVienChamDiem(gv))
                    return "redirect:/";
            } else{
                if(this.gvcdSer.updateGiangVienChamDiem(gv))
                    return "redirect:/";
            }
        }
        return "addorupdategiangvienchamdiem";
    }
    
    @GetMapping("/statDTB/{klId}")
    public ModelAndView statDTB(@PathVariable("klId") int id,@RequestParam Map<String,String> params){
        return new ModelAndView(new PDFUtil(), "statDTB" , this.statSer.statDTB(id));
    }
}