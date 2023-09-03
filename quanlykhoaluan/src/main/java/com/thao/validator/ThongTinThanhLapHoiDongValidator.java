/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.validator;

import com.thao.pojo.ThongTinThanhLapHoiDong;
import com.thao.repository.KhoaLuanTotNghiepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Chung Vu
 */
@Component
public class ThongTinThanhLapHoiDongValidator implements Validator {

    @Autowired
    private KhoaLuanTotNghiepRepository klRepo;

    @Override
    public boolean supports(Class<?> clazz) {
        return ThongTinThanhLapHoiDong.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ThongTinThanhLapHoiDong hd = (ThongTinThanhLapHoiDong) target;
        if (hd.getGiangVienCT().getId() == hd.getGiangVienPB().getId() || hd.getGiangVienCT().getId() == hd.getGiangVienTK().getId() || hd.getGiangVienPB().getId() == hd.getGiangVienTK().getId()) {
            errors.rejectValue("giangVienCT", "thongTinThanhLapHoiDong.giangVienCT.distinctError");
            errors.rejectValue("giangVienTK", "thongTinThanhLapHoiDong.giangVienCT.distinctError");
            errors.rejectValue("giangVienPB", "thongTinThanhLapHoiDong.giangVienCT.distinctError");

        }
        if (hd.getGiangVienTV1() != null && hd.getGiangVienTV2() != null) {
            if (hd.getGiangVienTV1().getId() == hd.getGiangVienTV2().getId()) {
                errors.rejectValue("giangVienTV1", "thongTinThanhLapHoiDong.giangVienCT.distinctError");
                errors.rejectValue("giangVienTV2", "thongTinThanhLapHoiDong.giangVienCT.distinctError");
            }
        }
        if (hd.getGiangVienTV1() != null) {
            if (hd.getGiangVienTV1().getId() == hd.getGiangVienCT().getId() || hd.getGiangVienPB().getId() == hd.getGiangVienTV1().getId() || hd.getGiangVienTV1().getId() == hd.getGiangVienTK().getId()) {
                errors.rejectValue("giangVienTV1", "thongTinThanhLapHoiDong.giangVienCT.distinctError");
            }
        }
        if (hd.getGiangVienTV2() != null) {
            if (hd.getGiangVienTV2().getId() == hd.getGiangVienCT().getId() || hd.getGiangVienPB().getId() == hd.getGiangVienTV2().getId() || hd.getGiangVienTV2().getId() == hd.getGiangVienTK().getId()) {
                errors.rejectValue("giangVienTV2", "thongTinThanhLapHoiDong.giangVienCT.distinctError");
            }
        }
        if (this.klRepo.getKhoaLuanById(hd.getKl().getId()).getHoiDongId() != null) {
            errors.rejectValue("kl", "thongTinThanhLapHoiDong.kl.existErr");
        }

    }

}
