/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.repository.KhoaLuanTotNghiepRepository;
import com.thao.service.KhoaLuanTotNghiepService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chung Vu
 */
@Service
public class KhoaLuanTotNghiepServiceImpl implements KhoaLuanTotNghiepService{
    @Autowired
    private KhoaLuanTotNghiepRepository khoaLuanRepo;

    @Override
    public List<KhoaLuanTotNghiep> getKhoaLuans(Map<String, String> params) {
        return this.khoaLuanRepo.getKhoaLuans(params);
    }
    
    
}
