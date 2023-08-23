/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.NguoiDung;
import com.thao.service.NguoiDungService;
import com.thao.utils.MailUtil;
import com.thao.validator.NguoiDungWebAppValidator;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
public class AdminNguoiDungController {

    @Autowired
    private NguoiDungService nguoiDungService;

    @Autowired
    private MailUtil mailUtil;

    @Autowired
    private NguoiDungWebAppValidator nguoiDungValids;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(nguoiDungValids);
    }

    @RequestMapping("/nguoidungs")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("nguoiDungs", this.nguoiDungService.getNguoiDungs(params));
        return "nguoidungs";
    }

    @GetMapping("/addorupdatenguoidung")
    public String nd(Model model) {
        model.addAttribute("nguoiDung", new NguoiDung());
        List<String> listNganh = new ArrayList<>();
        listNganh.add("CNTT");
        listNganh.add("KHMT");
        listNganh.add("HTQLTT");
        listNganh.add("Anh ngữ");
        listNganh.add("Nhật ngữ");
        listNganh.add("Môi trường");
        listNganh.add("Tâm lý học");
        model.addAttribute("listNganh", listNganh);
        List<String> listVaiTro = new ArrayList<>();
        listVaiTro.add("GIAO_VU");
        listVaiTro.add("GIANG_VIEN");
        listVaiTro.add("SINH_VIEN");
        model.addAttribute("listVaiTro", listVaiTro);
        return "addorupdatenguoidung";
    }

    @PostMapping("/addorupdatenguoidung")
    public String add(@ModelAttribute(value = "nguoiDung") @Valid NguoiDung nd, BindingResult rs, Model model) {
//        System.out.println(nd.getId());
//        for (Object object : rs.getAllErrors()) {
//            if (object instanceof FieldError) {
//                FieldError fieldError = (FieldError) object;
//
//                System.out.println(fieldError.getCode());
//            }
//
//            if (object instanceof ObjectError) {
//                ObjectError objectError = (ObjectError) object;
//
//                System.out.println(objectError.getCode());
//            }
//        }
        if (!rs.hasErrors()) {

            if (nd.getId() == null) {
                if (this.nguoiDungService.addNguoiDung(nd) == true) {
                    return "redirect:/";
                }
            } else {
                if (this.nguoiDungService.updateNguoiDung(nd) == true) {
                    mailUtil.sendMail(nd.getEmail(), "Your information has been changed!", "Your information has been changed!");
                    return "redirect:/";
                }
            }
        }
        List<String> listNganh = new ArrayList<>();
        listNganh.add("CNTT");
        listNganh.add("KHMT");
        listNganh.add("HTQLTT");
        listNganh.add("Anh ngữ");
        listNganh.add("Nhật ngữ");
        listNganh.add("Môi trường");
        listNganh.add("Tâm lý học");
        model.addAttribute("listNganh", listNganh);
        List<String> listVaiTro = new ArrayList<>();
        listVaiTro.add("GIAO_VU");
        listVaiTro.add("GIANG_VIEN");
        listVaiTro.add("SINH_VIEN");
        model.addAttribute("listVaiTro", listVaiTro);
        return "addorupdatenguoidung";
    }

    @GetMapping("/addorupdatenguoidung/{id}")
    public String updateNguoiDung(@PathVariable("id") int id, Model model) {
        model.addAttribute("nguoiDung", this.nguoiDungService.getNguoiDungById(id));
        List<String> listNganh = new ArrayList<>();
        listNganh.add("CNTT");
        listNganh.add("KHMT");
        listNganh.add("HTQLTT");
        listNganh.add("Anh ngữ");
        listNganh.add("Nhật ngữ");
        listNganh.add("Môi trường");
        listNganh.add("Tâm lý học");
        model.addAttribute("listNganh", listNganh);
        List<String> listVaiTro = new ArrayList<>();
        listVaiTro.add("GIAO_VU");
        listVaiTro.add("GIANG_VIEN");
        listVaiTro.add("SINH_VIEN");
        model.addAttribute("listVaiTro", listVaiTro);
        return "addorupdatenguoidung";
    }

    @DeleteMapping("/deletenguoidung/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNguoiDung(@PathVariable("id") int id) {
        this.nguoiDungService.deleteNguoiDung(id);
    }

//    @RequestMapping("/deleteNguoiDung/{id}")
//    public String deleteNguoiDung(@PathVariable("id") int id) {
//        this.nguoiDungService.deleteNguoiDung(id);
//        return "index";
//    }
}
