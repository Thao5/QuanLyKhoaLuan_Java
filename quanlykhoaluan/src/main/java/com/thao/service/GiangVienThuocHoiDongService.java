/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thao.service;

import com.thao.pojo.GiangVienThuocHoiDong;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chung Vu
 */
public interface GiangVienThuocHoiDongService {
    List<GiangVienThuocHoiDong> getGiangVienThuocHoiDong(Map<String, String> params);
    boolean addGiangVienThuocHoiDong(String vaiTro, LocalDate ngayVaoHoiDong, int giangVienId, int hoiDongId);
    boolean updateGiangVienThuocHoiDong(int id, Map<String,String> params);
}
