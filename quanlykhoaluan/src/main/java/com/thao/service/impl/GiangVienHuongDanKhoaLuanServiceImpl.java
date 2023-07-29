/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.GiangVienHuongDanKhoaLuan;
import com.thao.repository.GiangVienHuongDanKhoaLuanRepository;
import com.thao.service.GiangVienHuongDanKhoaLuanService;
import java.time.LocalDate;
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

    @Override
    public boolean addGiangVienHuongDanKhoaLuan(int giangVienId, int khoaLuanId, LocalDate ngayHuongDan) {
        return this.giangVienHuongDanKhoaLuanRepo.addGiangVienHuongDanKhoaLuan(giangVienId, khoaLuanId, ngayHuongDan);
    }

    @Override
    public boolean updateGiangVienHuongDanKhoaLuan(int id, Map<String, String> params) {
        return this.giangVienHuongDanKhoaLuanRepo.updateGiangVienHuongDanKhoaLuan(id, params);
    }

    @Override
    public GiangVienHuongDanKhoaLuan getGiangVienHuongDanKhoaLuanById(int id) {
        return this.giangVienHuongDanKhoaLuanRepo.getGiangVienHuongDanKhoaLuanById(id);
    }

    @Override
    public boolean updateGiangVienHuongDanKhoaLuan(GiangVienHuongDanKhoaLuan gv) {
        return this.giangVienHuongDanKhoaLuanRepo.updateGiangVienHuongDanKhoaLuan(gv);
    }
    
    
}
