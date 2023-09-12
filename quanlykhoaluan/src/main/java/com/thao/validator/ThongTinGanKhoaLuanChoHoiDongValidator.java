/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.validator;

import com.thao.pojo.ThongTinGanKhoaLuanChoHoiDong;
import com.thao.repository.HoiDongBaoVeKhoaLuanRepository;
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
public class ThongTinGanKhoaLuanChoHoiDongValidator implements Validator {

    @Autowired
    private KhoaLuanTotNghiepRepository klRepo;
    @Autowired
    private HoiDongBaoVeKhoaLuanRepository hdRepo;

    @Override
    public boolean supports(Class<?> clazz) {
        return ThongTinGanKhoaLuanChoHoiDong.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ThongTinGanKhoaLuanChoHoiDong ttgkl = (ThongTinGanKhoaLuanChoHoiDong) target;
        if (ttgkl.getKl2() != null) {
            if (this.klRepo.getKhoaLuanById(ttgkl.getKl2().getId()).getHoiDongId() != null) {
                errors.rejectValue("kl2", "thongTinThanhLapHoiDong.kl.existErr");
            }
        } else {
            errors.rejectValue("kl2", "thongTinGanKhoaLuanChoHoiDong.kl2.nullErr");
        }
        if (ttgkl.getKl3() != null) {
            if (ttgkl.getKl3() != null) {
                if (this.klRepo.getKhoaLuanById(ttgkl.getKl3().getId()).getHoiDongId() != null) {
                    errors.rejectValue("kl3", "thongTinThanhLapHoiDong.kl.existErr");
                }
                if (ttgkl.getKl3().getId() == ttgkl.getKl2().getId()) {
                    errors.rejectValue("kl2", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
                    errors.rejectValue("kl3", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
                }
                if (ttgkl.getKl4() != null) {
                    if (ttgkl.getKl3().getId() == ttgkl.getKl4().getId()) {
                        errors.rejectValue("kl3", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
                        errors.rejectValue("kl4", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
                    }
                }
                if (ttgkl.getKl5() != null) {
                    if (ttgkl.getKl3().getId() == ttgkl.getKl5().getId()) {
                        errors.rejectValue("kl3", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
                        errors.rejectValue("kl5", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
                    }
                }
            } else {
                errors.rejectValue("kl2", "thongTinGanKhoaLuanChoHoiDong.kl2.nullErr");
            }
        }
        if (ttgkl.getKl4() != null) {
            if (ttgkl.getKl4() != null) {
                if (this.klRepo.getKhoaLuanById(ttgkl.getKl4().getId()).getHoiDongId() != null) {
                    errors.rejectValue("kl3", "thongTinThanhLapHoiDong.kl.existErr");
                }
                if (ttgkl.getKl4().getId() == ttgkl.getKl2().getId()) {
                    errors.rejectValue("kl2", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
                    errors.rejectValue("kl4", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
                }
                if (ttgkl.getKl5() != null) {
                    if (ttgkl.getKl4().getId() == ttgkl.getKl5().getId()) {
                        errors.rejectValue("kl4", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
                        errors.rejectValue("kl5", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
                    }
                }
            } else {
                errors.rejectValue("kl2", "thongTinGanKhoaLuanChoHoiDong.kl2.nullErr");
            }
        }
        if (ttgkl.getKl5() != null) {
            if (this.klRepo.getKhoaLuanById(ttgkl.getKl5().getId()).getHoiDongId() != null) {
                errors.rejectValue("kl3", "thongTinThanhLapHoiDong.kl.existErr");
            }
            if (ttgkl.getKl5().getId() == ttgkl.getKl2().getId()) {
                errors.rejectValue("kl2", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
                errors.rejectValue("kl5", "thongTinGanKhoaLuanChoHoiDong.kl2.distinctErr");
            }
        }
        if (this.klRepo.soLuongKhoaLuanHoiDongCham(ttgkl.getId()) >= 5) {
            errors.rejectValue("kl2", "thongTinGanKhoaLuanChoHoiDong.kl2.overSizeErr");
        }
        if (this.klRepo.soLuongKhoaLuanHoiDongCham(ttgkl.getId()) == 4) {
            if (ttgkl.getKl3() != null || ttgkl.getKl4() != null || ttgkl.getKl5() != null) {
                errors.rejectValue("kl3", "thongTinGanKhoaLuanChoHoiDong.kl2.overSizeErr");
            }
        }
        if (this.klRepo.soLuongKhoaLuanHoiDongCham(ttgkl.getId()) == 3) {
            if (ttgkl.getKl3() != null && ttgkl.getKl4() != null) {
                errors.rejectValue("kl3", "thongTinGanKhoaLuanChoHoiDong.kl2.overSizeErr");
                errors.rejectValue("kl4", "thongTinGanKhoaLuanChoHoiDong.kl2.overSizeErr");
            }
            if (ttgkl.getKl3() != null && ttgkl.getKl5() != null) {
                errors.rejectValue("kl3", "thongTinGanKhoaLuanChoHoiDong.kl2.overSizeErr");
                errors.rejectValue("kl5", "thongTinGanKhoaLuanChoHoiDong.kl2.overSizeErr");
            }
            if (ttgkl.getKl4() != null && ttgkl.getKl5() != null) {
                errors.rejectValue("kl1", "thongTinGanKhoaLuanChoHoiDong.kl2.overSizeErr");
                errors.rejectValue("kl5", "thongTinGanKhoaLuanChoHoiDong.kl2.overSizeErr");
            }
        }
        if (this.klRepo.soLuongKhoaLuanHoiDongCham(ttgkl.getId()) == 2) {
            if (ttgkl.getKl3() != null && ttgkl.getKl4() != null && ttgkl.getKl5() != null) {
                errors.rejectValue("kl3", "thongTinGanKhoaLuanChoHoiDong.kl2.overSizeErr");
                errors.rejectValue("kl4", "thongTinGanKhoaLuanChoHoiDong.kl2.overSizeErr");
                errors.rejectValue("kl5", "thongTinGanKhoaLuanChoHoiDong.kl2.overSizeErr");
            }
        }
    }
}
