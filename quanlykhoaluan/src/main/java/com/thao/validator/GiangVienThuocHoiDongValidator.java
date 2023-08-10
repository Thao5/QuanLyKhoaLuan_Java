/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.validator;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.repository.GiangVienThuocHoiDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Chung Vu
 */
@Component
public class GiangVienThuocHoiDongValidator implements Validator{
    @Autowired
    private GiangVienThuocHoiDongRepository gvthdSer;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return GiangVienThuocHoiDong.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        GiangVienThuocHoiDong gv = (GiangVienThuocHoiDong) target;
        if(gvthdSer.demGiangVienThuocHoiDong(gv.getHoiDongId().getId()) >= 5){
            errors.rejectValue("nguoiDungId", "giangVienThuocHoiDong.nguoiDungId.soLuongGiangVienErr");
        }
    }
}
