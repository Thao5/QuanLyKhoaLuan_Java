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

    @Override
    public List<KhoaLuanTotNghiep> getDanhSachSinhVienLamKhoaLuanTheoId(Map<String,String> params) {
        return this.khoaLuanRepo.getDanhSachSinhVienLamKhoaLuanTheoId(params);
    }

    @Override
    public List<KhoaLuanTotNghiep> getDanhSachKhoaLuanDuocGhiNhanBoiGiaoVuTheoId(Map<String, String> params) {
        return this.khoaLuanRepo.getDanhSachKhoaLuanDuocGhiNhanBoiGiaoVuTheoId(params);
    }

    @Override
    public boolean addKhoaLuan(KhoaLuanTotNghiep kl) {
        return this.khoaLuanRepo.addKhoaLuan(kl);
    }

    @Override
    public boolean updateKhoaLuan(int id, Map<String, String> params) {
        return this.khoaLuanRepo.updateKhoaLuan(id, params);
    }
    
    
}
