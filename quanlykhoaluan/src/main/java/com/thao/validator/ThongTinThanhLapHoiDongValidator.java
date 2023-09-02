/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.validator;

import com.thao.pojo.ThongTinThanhLapHoiDong;
import com.thao.repository.ThongTinThanhLapHoiDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Chung Vu
 */
@Component
public class ThongTinThanhLapHoiDongValidator implements Validator{
    @Autowired
    private ThongTinThanhLapHoiDongRepository tttlhdRepo;

    @Override
    public boolean supports(Class<?> clazz) {
        return ThongTinThanhLapHoiDong.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ThongTinThanhLapHoiDong hd = (ThongTinThanhLapHoiDong) target;
        if(hd.getGiangVienCT().getId() == hd.getGiangVienPB().getId() || hd.getGiangVienCT().getId() == hd.getGiangVienTK().getId() || hd.getGiangVienPB().getId() == hd.getGiangVienTK().getId()){
            errors.rejectValue("giangVienCT", "thongTinThanhLapHoiDong.giangVienCT.distinctError");
            errors.rejectValue("giangVienTK", "thongTinThanhLapHoiDong.giangVienCT.distinctError");
            errors.rejectValue("giangVienPB", "thongTinThanhLapHoiDong.giangVienCT.distinctError");
        }
    }
    
}
