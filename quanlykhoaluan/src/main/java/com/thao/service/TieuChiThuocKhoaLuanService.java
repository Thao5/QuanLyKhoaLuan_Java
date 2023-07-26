/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thao.service;

import com.thao.pojo.TieuChiThuocKhoaLuan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chung Vu
 */
public interface TieuChiThuocKhoaLuanService {
    List<TieuChiThuocKhoaLuan> getTieuChiThuocKhoaLuans(Map<String,String> params);
    boolean addTieuChiThuocKhoaLuan(int tieuChiId, int khoaLuanId);
}
