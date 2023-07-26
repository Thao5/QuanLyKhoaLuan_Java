/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thao.repository;

import com.thao.pojo.NguoiDung;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chung Vu
 */
public interface NguoiDungRepository {
    List<NguoiDung> getNguoiDungs(Map<String,String> params);
    Boolean addNguoiDung(NguoiDung user);
    Boolean ganKhoaLuanChoSinhVien(int userId, int khoaLuanId);
}
