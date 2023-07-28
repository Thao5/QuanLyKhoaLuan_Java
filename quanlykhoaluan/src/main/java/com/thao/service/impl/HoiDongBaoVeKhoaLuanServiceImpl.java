/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.pojo.HoiDongBaoVeKhoaLuan;
import com.thao.repository.HoiDongBaoVeKhoaLuanRepository;
import com.thao.service.HoiDongBaoVeKhoaLuanService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chung Vu
 */
@Service
public class HoiDongBaoVeKhoaLuanServiceImpl implements HoiDongBaoVeKhoaLuanService{
    @Autowired
    private HoiDongBaoVeKhoaLuanRepository hoiDongBaoVeKhoaLuanRepository;

    @Override
    public List<HoiDongBaoVeKhoaLuan> getHoiDongBaoVeKhoaLuans(Map<String, String> params) {
        return this.hoiDongBaoVeKhoaLuanRepository.getHoiDongBaoVeKhoaLuans(params);
    }

    @Override
    public boolean addHoiDongBaoVeKhoaLuan(HoiDongBaoVeKhoaLuan hd) {
        return this.hoiDongBaoVeKhoaLuanRepository.addHoiDongBaoVeKhoaLuan(hd);
    }

    @Override
    public boolean updateHoiDongBaoVeKhoaLuan(int id, Map<String, String> params) {
        return this.hoiDongBaoVeKhoaLuanRepository.updateHoiDongBaoVeKhoaLuan(id, params);
    }
    
    
}
