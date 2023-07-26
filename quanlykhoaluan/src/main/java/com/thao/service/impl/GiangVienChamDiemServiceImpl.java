/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.GiangVienChamDiem;
import com.thao.repository.GiangVienChamDiemRepository;
import com.thao.service.GiangVienChamDiemService;
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
public class GiangVienChamDiemServiceImpl implements GiangVienChamDiemService{
    @Autowired
    private GiangVienChamDiemRepository giangVienChamDiemRepository;

    @Override
    public List<GiangVienChamDiem> getDiemKhoaLuan(Map<String, String> params) {
        return this.giangVienChamDiemRepository.getDiemKhoaLuan(params);
    }

    @Override
    public boolean addGiangVienChamDiem(float diem, LocalDate ngayCham, int giangVienThuocHoiDongId, int khoaLuanId) {
        return this.giangVienChamDiemRepository.addGiangVienChamDiem(diem, ngayCham, giangVienThuocHoiDongId, khoaLuanId);
    }
    
    
}