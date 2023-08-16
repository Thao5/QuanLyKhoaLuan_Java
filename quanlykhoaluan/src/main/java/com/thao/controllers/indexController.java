/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.service.GiangVienChamDiemService;
import com.thao.service.KhoaLuanTotNghiepService;
import com.thao.service.NguoiDungService;
import com.thao.service.StatsService;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Chung Vu
 */
@Controller
public class IndexController {
    @Autowired
    private KhoaLuanTotNghiepService khoaLuanService;
    @Autowired
    private GiangVienChamDiemService gvcdSer;
    
    @Autowired
    private NguoiDungService nguoiDungService;
    
    @Autowired
    private StatsService statSer;
    
    @Autowired
    private SimpleDateFormat simpleDateFormat;
    
    @RequestMapping(value="/")
    public String index(Model model, @RequestParam Map<String,String> params){
        List<Object[]> list = this.statSer.statTuanSuatTheoNganh(params);
        for(Object[] l : list){
            System.out.printf("%s %d\n", l[0], l[1]);
        }
        return "index";
    }
}
