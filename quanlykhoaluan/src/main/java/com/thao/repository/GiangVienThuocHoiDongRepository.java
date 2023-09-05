/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thao.repository;

import com.thao.pojo.GiangVienThuocHoiDong;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chung Vu
 */
public interface GiangVienThuocHoiDongRepository {
    List<GiangVienThuocHoiDong> getGiangVienThuocHoiDong(Map<String,String> params);
    boolean addGiangVienThuocHoiDong(String vaiTro, LocalDateTime ngayVaoHoiDong, int giangVienId, int hoiDongId);
    boolean updateGiangVienThuocHoiDong(int id, Map<String,String> params);
    boolean updateGiangvienThuocHoiDong(GiangVienThuocHoiDong gv);
    GiangVienThuocHoiDong getGiangVienThuocHoiDongById(int id);
    boolean addGiangVienThuocHoiDong(GiangVienThuocHoiDong gv);
    Long demGiangVienThuocHoiDong(int hdId);
    GiangVienThuocHoiDong getGiangVienThuocHoiDongByNguoiDungAndHoiDong(int ndID, int hdID);
}
