/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.validator;

import com.thao.pojo.KhoaLuanTotNghiep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Chung Vu
 */
@Component
public class KhoaLuanValidator implements Validator{
    
    
    @Override
    public boolean supports(Class<?> clazz) {
        return KhoaLuanTotNghiep.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        KhoaLuanTotNghiep kl = (KhoaLuanTotNghiep) target;
        if(kl.getHoiDongId().getKhoaLuanTotNghiepSet().size() >= 5){
            errors.rejectValue("hoiDongId", "khoaLuan.hoiDongId.outOfSizeErr");
        }
    }
    
}
