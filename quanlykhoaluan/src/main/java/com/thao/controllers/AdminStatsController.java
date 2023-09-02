/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.service.StatsService;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
@RequestMapping("/admin")
public class AdminStatsController {
    @Autowired
    private StatsService statsSer;
    
    @RequestMapping("/thongke")
    public String list(Model model, @RequestParam Map<String,String> params){
        model.addAttribute("stats", this.statsSer.statDiem(params));
        Map<String, Double> tmp = new LinkedHashMap<String, Double>();
        for(Object[] o: this.statsSer.statDiem(params)){
            tmp.put(o[1].toString(), Double.parseDouble(o[0].toString()));
        }
        model.addAttribute("data", tmp);
        return "charts";
    }
}
