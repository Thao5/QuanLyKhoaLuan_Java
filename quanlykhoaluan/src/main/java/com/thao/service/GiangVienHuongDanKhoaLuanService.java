/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thao.service;

import com.thao.pojo.GiangVienHuongDanKhoaLuan;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chung Vu
 */
public interface GiangVienHuongDanKhoaLuanService {
    List<GiangVienHuongDanKhoaLuan> getGiangVienHuongDans(Map<String, String> params);
    boolean addGiangVienHuongDanKhoaLuan(int giangVienId, int khoaLuanId, LocalDate ngayHuongDan);
    boolean updateGiangVienHuongDanKhoaLuan(int id, Map<String, String> params);
    boolean updateGiangVienHuongDanKhoaLuan(GiangVienHuongDanKhoaLuan gv);
    GiangVienHuongDanKhoaLuan getGiangVienHuongDanKhoaLuanById(int id);
    boolean deleteGiangVienHuongDanKhoaLuan(int id);
    boolean addGiangVienHuongDanKhoaLuan(GiangVienHuongDanKhoaLuan gv);
    Long demGiangVienHuongDanCuaKhoaLuan(int klId);
}
