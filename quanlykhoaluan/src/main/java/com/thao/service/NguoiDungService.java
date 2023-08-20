/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thao.service;

import com.thao.pojo.NguoiDung;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Chung Vu
 */
public interface NguoiDungService extends UserDetailsService {
    List<NguoiDung> getNguoiDungs(Map<String,String> params);
    Boolean addNguoiDung(NguoiDung user);
    Boolean ganKhoaLuanChoSinhVien(int userId, int khoaLuanId);
    NguoiDung updateNguoiDung(int id, Map<String,String> params, MultipartFile avatar);
    boolean updateNguoiDung(NguoiDung nd);
    NguoiDung getNguoiDungById(int id);
    NguoiDung getNguoiDungByUsername(String username);
    boolean deleteNguoiDung(int id);
    boolean authNguoiDung(String taiKhoan, String matKhau);
}
