/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thao.repository;

import com.thao.pojo.GiangVienChamDiem;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chung Vu
 */
public interface GiangVienChamDiemRepository {
    List<GiangVienChamDiem> getDiemKhoaLuan(Map<String,String> params);
    boolean addGiangVienChamDiem(float diem, LocalDate ngayCham, int giangVienThuocHoiDongId, int khoaLuanId);
    boolean updateGiangVienChamDiem(int id, Map<String,String> params);
    boolean updateGiangVienChamDiem(GiangVienChamDiem gv);
    GiangVienChamDiem getGiangVienChamDiemById(int id);
    boolean deleteGiangVienChamDiem(int id);
    boolean addGiangVienChamDiem(GiangVienChamDiem gv);
    Double tongDiem(int klId);
    Double diemTrungBinh(int klId);
//    Long demHoiDongChamKhoaLuan(int hd);
}
