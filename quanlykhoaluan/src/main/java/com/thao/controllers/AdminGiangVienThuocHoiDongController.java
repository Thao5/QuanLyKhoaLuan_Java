/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.service.GiangVienThuocHoiDongService;
import com.thao.service.HoiDongBaoVeKhoaLuanService;
import com.thao.service.NguoiDungService;
import com.thao.validator.GiangVienThuocHoiDongWebAppValidator;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
    @Autowired
    private NguoiDungService ndSer;
    @Autowired
    private HoiDongBaoVeKhoaLuanService hdSer;
    @Autowired
    private GiangVienThuocHoiDongWebAppValidator giangVienThuocHoiDongWebAppValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(giangVienThuocHoiDongWebAppValidator);
    }
    
    @RequestMapping("/giangvienthuochoidongs")
    public String list(Model model, @RequestParam Map<String,String> params){
        model.addAttribute("giangVienThuocHoiDongs", this.gvthdSer.getGiangVienThuocHoiDong(params));
        return "giangvienthuochoidongs";
    }
    
    @GetMapping("/addgiangvienthuochoidong/{id}")
    public String gvthd(Model model, @PathVariable("id") int id){
        Map<String, String> tmp = new HashMap<>();
        tmp.put("vaiTro", "GIANG_VIEN");
        GiangVienThuocHoiDong gv = new GiangVienThuocHoiDong();
        gv.setHoiDongId(this.hdSer.getHoiDongById(id));
        gv.setNgayVaoHoiDong(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        gv.setVaiTro("THANH_VIEN");
        model.addAttribute("giangVienThuocHoiDong", gv);
        model.addAttribute("giangViens", this.ndSer.getNguoiDungs(tmp));
        return "addorupdategiangvienthuochoidong";
    }
    
    @GetMapping("/addorupdategiangvienthuochoidong/{id}")
    public String update(Model model, @PathVariable("id") int id){
        Map<String, String> tmp = new HashMap<>();
        tmp.put("vaiTro", "GIANG_VIEN");
        model.addAttribute("giangVienThuocHoiDong", this.gvthdSer.getGiangVienThuocHoiDongById(id));
        model.addAttribute("giangViens", this.ndSer.getNguoiDungs(tmp));
        return "addorupdategiangvienthuochoidong";
    }
    
    @PostMapping("/addorupdategiangvienthuochoidong")
    public String addOrUpdate(Model model,@ModelAttribute(value="giangVienThuocHoiDong") @Valid GiangVienThuocHoiDong gv, BindingResult rs){
        if(!rs.hasErrors()){
            if(gv.getId() == null){
                if(this.gvthdSer.addGiangVienThuocHoiDong(gv))
                    return "redirect:/";
            }else{
                GiangVienThuocHoiDong gvTmp = this.gvthdSer.getGiangVienThuocHoiDongById(gv.getId());
                Map<String,String> tmp = new HashMap<>();
                tmp.put("hoiDongId", gv.getHoiDongId().getId().toString());
                tmp.put("ndID", gv.getNguoiDungId().getId().toString());
                List<GiangVienThuocHoiDong> listGvTmp = this.gvthdSer.getGiangVienThuocHoiDong(tmp);
                GiangVienThuocHoiDong gvTmp2 = new GiangVienThuocHoiDong();
                if(!listGvTmp.isEmpty() && listGvTmp != null){
                    gvTmp2 = listGvTmp.get(0);
                    gvTmp2.setNguoiDungId(gvTmp.getNguoiDungId());
                    this.gvthdSer.updateGiangvienThuocHoiDong(gvTmp2);
                }
                if(this.gvthdSer.updateGiangvienThuocHoiDong(gv))
                    return "redirect:/";
            }
        }
        Map<String, String> tmp = new HashMap<>();
        tmp.put("vaiTro", "GIANG_VIEN");
        model.addAttribute("giangVienThuocHoiDong", gv);
        model.addAttribute("giangViens", this.ndSer.getNguoiDungs(tmp));
        return "addorupdategiangvienthuochoidong";
    }
}
