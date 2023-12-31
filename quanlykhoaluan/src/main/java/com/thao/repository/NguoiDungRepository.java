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
    boolean updateNguoiDung(int id, Map<String,String> params);
    boolean updateNguoiDung(NguoiDung nd);
    NguoiDung getNguoiDungById(int id);
    boolean deleteNguoiDung(int id);
    NguoiDung getNguoiDungByUsername(String username);
    boolean isAlreadyHaveEmail(String email);
    boolean isAlreadyHaveSDT(String sdt);
    boolean isAlreadyHaveTaiKhoan(String tk);
    boolean authNguoiDung(String taiKhoan, String matKhau);
    List<NguoiDung> getSinhVienChuaCoKL();
}
