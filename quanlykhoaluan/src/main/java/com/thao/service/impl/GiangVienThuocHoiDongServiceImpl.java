/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.repository.GiangVienThuocHoiDongRepository;
import com.thao.service.GiangVienThuocHoiDongService;
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
public class GiangVienThuocHoiDongServiceImpl implements GiangVienThuocHoiDongService{
    @Autowired
    private GiangVienThuocHoiDongRepository giangVienThuocHoiDongRepository;
    
    @Override
    public List<GiangVienThuocHoiDong> getGiangVienThuocHoiDong(Map<String, String> params) {
        return this.giangVienThuocHoiDongRepository.getGiangVienThuocHoiDong(params);
    }

    @Override
    public boolean addGiangVienThuocHoiDong(String vaiTro, LocalDateTime ngayVaoHoiDong, int giangVienId, int hoiDongId) {
        return this.giangVienThuocHoiDongRepository.addGiangVienThuocHoiDong(vaiTro, ngayVaoHoiDong, giangVienId, hoiDongId);
    }

    @Override
    public boolean updateGiangVienThuocHoiDong(int id, Map<String, String> params) {
        return this.giangVienThuocHoiDongRepository.updateGiangVienThuocHoiDong(id, params);
    }

    @Override
    public GiangVienThuocHoiDong getGiangVienThuocHoiDongById(int id) {
        return this.giangVienThuocHoiDongRepository.getGiangVienThuocHoiDongById(id);
    }

    @Override
    public boolean updateGiangvienThuocHoiDong(GiangVienThuocHoiDong gv) {
        return this.giangVienThuocHoiDongRepository.updateGiangvienThuocHoiDong(gv);
    }

    @Override
    public boolean addGiangVienThuocHoiDong(GiangVienThuocHoiDong gv) {
        return this.giangVienThuocHoiDongRepository.addGiangVienThuocHoiDong(gv);
    }

    @Override
    public Long demGiangVienThuocHoiDong(int hdId) {
        return this.giangVienThuocHoiDongRepository.demGiangVienThuocHoiDong(hdId);
    }

    @Override
    public GiangVienThuocHoiDong getGiangVienThuocHoiDongByNguoiDungAndHoiDong(int ndID, int hdID) {
        return this.giangVienThuocHoiDongRepository.getGiangVienThuocHoiDongByNguoiDungAndHoiDong(ndID, hdID);
    }
    
    
}
