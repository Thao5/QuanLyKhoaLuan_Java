/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.TieuChiThuocKhoaLuan;
import com.thao.repository.TieuChiThuocKhoaLuanRepository;
import com.thao.service.TieuChiThuocKhoaLuanService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chung Vu
 */
@Service
public class TieuChiThuocKhoaLuanServiceImpl implements TieuChiThuocKhoaLuanService{
    @Autowired
    private TieuChiThuocKhoaLuanRepository tieuChiThuocKhoaLuanRepository;

    @Override
    public List<TieuChiThuocKhoaLuan> getTieuChiThuocKhoaLuans(Map<String, String> params) {
        return this.tieuChiThuocKhoaLuanRepository.getTieuChiThuocKhoaLuans(params);
    }

    @Override
    public boolean addTieuChiThuocKhoaLuan(int tieuChiId, int khoaLuanId) {
        return this.tieuChiThuocKhoaLuanRepository.addTieuChiThuocKhoaLuan(tieuChiId, khoaLuanId);
    }
    
    
}
