/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.GiangVienHuongDanKhoaLuan;
import com.thao.repository.GiangVienHuongDanKhoaLuanRepository;
import com.thao.service.GiangVienHuongDanKhoaLuanService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chung Vu
 */
@Service
public class GiangVienHuongDanKhoaLuanServiceImpl implements GiangVienHuongDanKhoaLuanService{
    @Autowired
    private GiangVienHuongDanKhoaLuanRepository giangVienHuongDanKhoaLuanRepo;

    @Override
    public List<GiangVienHuongDanKhoaLuan> getGiangVienHuongDans(Map<String, String> params) {
        return this.giangVienHuongDanKhoaLuanRepo.getGiangVienHuongDans(params);
    }
    
    
}
