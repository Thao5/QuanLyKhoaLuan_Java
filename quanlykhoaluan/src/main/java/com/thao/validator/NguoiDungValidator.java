/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.validator;

import com.thao.pojo.NguoiDung;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Chung Vu
 */
@Component
public class NguoiDungValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return NguoiDung.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NguoiDung nd = (NguoiDung) target;
        if(nd.getImg().isEmpty()){
            errors.rejectValue("img", "nguoiDung.img.nullErr");
        }
    }
    
}
