/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thao.repository;

import com.thao.pojo.KhoaLuanTotNghiep;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chung Vu
 */
public interface KhoaLuanTotNghiepRepository {
    List<KhoaLuanTotNghiep> getKhoaLuans(Map<String,String> params);
    List<KhoaLuanTotNghiep> getDanhSachSinhVienLamKhoaLuanTheoId(Map<String,String> params);
    List<KhoaLuanTotNghiep> getDanhSachKhoaLuanDuocGhiNhanBoiGiaoVuTheoId(Map<String,String> params);
    boolean addKhoaLuan(KhoaLuanTotNghiep kl);
}
