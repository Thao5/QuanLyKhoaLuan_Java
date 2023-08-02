/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thao.service;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.pojo.HoiDongBaoVeKhoaLuan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chung Vu
 */
public interface HoiDongBaoVeKhoaLuanService {
    List<HoiDongBaoVeKhoaLuan> getHoiDongBaoVeKhoaLuans(Map<String,String> params);
    boolean addHoiDongBaoVeKhoaLuan(HoiDongBaoVeKhoaLuan hd);
    boolean updateHoiDongBaoVeKhoaLuan(int id, Map<String,String> params);
    boolean updateHoiDongBaoVeKhoaLuan(HoiDongBaoVeKhoaLuan hd);
    HoiDongBaoVeKhoaLuan getHoiDongById(int id);
    boolean deleteHoiDong(int id);
}
