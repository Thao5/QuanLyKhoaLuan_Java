/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.pojo.ThongTinDangKyKhoaLuan;
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

    @Override
    public KhoaLuanTotNghiep getKhoaLuanById(int id) {
        return this.khoaLuanRepo.getKhoaLuanById(id);
    }

    @Override
    public boolean updateKhoaLuan(KhoaLuanTotNghiep kl) {
        return this.khoaLuanRepo.updateKhoaLuan(kl);
    }

    @Override
    public boolean deleteKhoaLuan(int id) {
        return this.khoaLuanRepo.deleteKhoaLuan(id);
    }

    @Override
    public boolean addKhoaLuanTheoThongTinDangKy(ThongTinDangKyKhoaLuan kl, KhoaLuanTotNghiep kltn) {
        return this.khoaLuanRepo.addKhoaLuanTheoThongTinDangKy(kl, kltn);
    }

    @Override
    public List<KhoaLuanTotNghiep> listKhoaLuanChuaCoHoiDong() {
        return this.khoaLuanRepo.listKhoaLuanChuaCoHoiDong();
    }

    @Override
    public List<KhoaLuanTotNghiep> getKLTheoHoiDong(int hdID) {
        return this.khoaLuanRepo.getKLTheoHoiDong(hdID);
    }
    
    
    
}
