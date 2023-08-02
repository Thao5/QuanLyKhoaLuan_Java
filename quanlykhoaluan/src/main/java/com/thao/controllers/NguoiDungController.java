/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.NguoiDung;
import com.thao.service.NguoiDungService;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 *
 * @author Chung Vu
 */
@Controller
public class NguoiDungController {

    @Autowired
    private NguoiDungService nguoiDungService;

    private int userId;

    @GetMapping("/nguoidung")
    public String list(Model model) {
        model.addAttribute("nguoiDung", new NguoiDung());
        return "nguoidung";
    }

    @PostMapping("/nguoidung")
    public String add(@ModelAttribute(value = "nguoiDung") @Valid NguoiDung nd, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.nguoiDungService.addNguoiDung(nd) == true) {
                return "redirect:/";
            }
        }

        return "nguoidung";
    }

    @RequestMapping("/ganKhoaLuanChoSinhVien")
    public String ganKhoaLuanChoSinhVien(@RequestParam Map<String, String> params) {
        this.nguoiDungService.ganKhoaLuanChoSinhVien(Integer.parseInt(params.get("userId")), Integer.parseInt(params.get("khoaLuanId")));
        return "index";
    }

    @RequestMapping("/updateNguoiDung/{id}")
    public String updateNguoiDung(@PathVariable("id") int id, @RequestParam Map<String, String> params) {
        this.nguoiDungService.updateNguoiDung(id, params);
        return "index";
    }

    @RequestMapping("/deleteNguoiDung/{id}")
    public String deleteNguoiDung(@PathVariable("id") int id) {
        this.nguoiDungService.deleteNguoiDung(id);
        return "index";
    }
}
