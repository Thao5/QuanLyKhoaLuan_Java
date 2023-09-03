/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.pojo;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Chung Vu
 */
@Data
public class ThongTinThanhLapHoiDong {
    @NotNull(message = "{hoiDong.tenHoiDong.nullErr}")
    @Size(min = 1, max = 100, message = "{hoiDong.tenHoiDong.lenErr}")
    private String tenHoiDong;
    @NotNull(message = "{hoiDong.ngayKhoa.nullErr}")
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date ngayKhoa;
    private NguoiDung giangVienCT;
    private NguoiDung giangVienTK;
    private NguoiDung giangVienPB;
    private NguoiDung giangVienTV1;
    private NguoiDung giangVienTV2;
    private KhoaLuanTotNghiep kl;
}
