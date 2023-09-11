/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.controllers;

import com.thao.pojo.TieuChi;
import com.thao.service.TieuChiService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
public class AdminTieuChiController {

    @Autowired
    private TieuChiService tieuChiService;
    @Autowired
    private Environment env;

    @RequestMapping("/tieuchi")
    public String list(Model model, @RequestParam Map<String, String> params) {
        Map<String, String> tmp = new HashMap<>();
        List<TieuChi> listTCPages = this.tieuChiService.getTieuChis(tmp);
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages", Math.ceil(listTCPages.size() * 1.0 / pageSize));
        model.addAttribute("tieuChis", this.tieuChiService.getTieuChis(params));
        return "tieuchi";
    }

    @GetMapping("/addorupdatetieuchi")
    public String add(Model model) {
        model.addAttribute("tieuChi", new TieuChi());
        return "addorupdatetieuchi";
    }

    @GetMapping("/addorupdatetieuchi/{id}")
    public String add(Model model, @PathVariable("id") int id) {
        model.addAttribute("tieuChi", this.tieuChiService.getTieuChiById(id));
        return "addorupdatetieuchi";
    }

    @PostMapping("/addorupdatetieuchi")
    public String addOrUpdateTieuChi(@ModelAttribute(value = "tieuChi") @Valid TieuChi tc, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (tc.getId() != null) {
                if (this.tieuChiService.updateTieuChi(tc)) {
                    return "redirect:/";
                }
            }
            if (this.tieuChiService.addTieuChi(tc) == true) {
                return "redirect:/";
            }
        }

        return "addorupdatetieuchi";
    }

    @DeleteMapping("/deletetieuchi/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNguoiDung(@PathVariable("id") int id) {
        this.tieuChiService.deleteTieuChi(id);
    }
}
