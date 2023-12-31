/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.GiangVienChamDiem;
import com.thao.repository.GiangVienChamDiemRepository;
import com.thao.service.GiangVienChamDiemService;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public boolean addGiangVienChamDiem(float diem, LocalDateTime ngayCham, int giangVienThuocHoiDongId, int khoaLuanId) {
        return this.giangVienChamDiemRepository.addGiangVienChamDiem(diem, ngayCham, giangVienThuocHoiDongId, khoaLuanId);
    }

    @Override
    public boolean updateGiangVienChamDiem(int id, Map<String, String> params) {
        return this.giangVienChamDiemRepository.updateGiangVienChamDiem(id, params);
    }

    @Override
    public GiangVienChamDiem getGiangVienChamDiemById(int id) {
        return this.giangVienChamDiemRepository.getGiangVienChamDiemById(id);
    }

    @Override
    public boolean updateGiangVienChamDiem(GiangVienChamDiem gv) {
        return this.giangVienChamDiemRepository.updateGiangVienChamDiem(gv);
    }

    @Override
    public boolean deleteGiangVienChamDiem(int id) {
        return this.giangVienChamDiemRepository.deleteGiangVienChamDiem(id);
    }

    @Override
    public boolean addGiangVienChamDiem(GiangVienChamDiem gv) {
        return this.giangVienChamDiemRepository.addGiangVienChamDiem(gv);
    }

    @Override
    public Double tongDiem(int klId) {
        return this.giangVienChamDiemRepository.tongDiem(klId);
    }

    @Override
    public Double diemTrungBinh(int klId) {
        return this.giangVienChamDiemRepository.diemTrungBinh(klId);
    }

//    @Override
//    public Long demHoiDongChamKhoaLuan(int hd) {
//        return this.giangVienChamDiemRepository.demHoiDongChamKhoaLuan(hd);
//    }

    @Override
    public List<Object[]> getDiemKhoaLuanOrderByKhoaLuanId(Map<String, String> params) {
        return this.giangVienChamDiemRepository.getDiemKhoaLuanOrderByKhoaLuanId(params);
    }

    @Override
    public List<Object[]> getDTBKL(Map<String, String> params) {
        return this.giangVienChamDiemRepository.getDTBKL(params);
    }
    
    
}
