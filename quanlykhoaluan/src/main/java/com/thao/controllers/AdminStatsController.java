/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chung Vu
 */
@Controller
@RequestMapping("/admin")
public class AdminStatsController {
    @RequestMapping("/thongke")
    public String list(){
        return "charts";
    }
}
