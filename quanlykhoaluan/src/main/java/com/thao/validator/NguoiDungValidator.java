/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.validator;

import com.thao.pojo.NguoiDung;
import com.thao.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Chung Vu
 */
@Component
public class NguoiDungValidator implements Validator{
    @Autowired
    private NguoiDungRepository ndRepo;

    @Override
    public boolean supports(Class<?> clazz) {
        return NguoiDung.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NguoiDung nd = (NguoiDung) target;
        if(nd.getImg().isEmpty()){
            if (nd.getAvatar() == null || nd.getAvatar().trim().isEmpty()){
                    errors.rejectValue("img", "nguoiDung.img.nullErr");
                }
        }
        if(this.ndRepo.isAlreadyHaveEmail(nd.getEmail())){
            if(nd.getId() == null)
                errors.rejectValue("email", "nguoiDung.email.alreadyHaveErr");
            else{
                if(!this.ndRepo.getNguoiDungById(nd.getId()).getEmail().equals(nd.getEmail()))
                    errors.rejectValue("email", "nguoiDung.email.alreadyHaveErr");
            }
        }
        if(this.ndRepo.isAlreadyHaveSDT(nd.getSdt())){
            if(nd.getId() == null)
                errors.rejectValue("sdt", "nguoiDung.sdt.alreadyHaveErr");
            else{
                if(!this.ndRepo.getNguoiDungById(nd.getId()).getSdt().equals(nd.getSdt()))
                    errors.rejectValue("sdt", "nguoiDung.sdt.alreadyHaveErr");
            }
        }
        if(this.ndRepo.isAlreadyHaveTaiKhoan(nd.getTaiKhoan())){
            if(nd.getId() == null)
                errors.rejectValue("taiKhoan", "nguoiDung.taiKhoan.alreadyHaveErr");
            else{
                if(!this.ndRepo.getNguoiDungById(nd.getId()).getTaiKhoan().equals(nd.getTaiKhoan()))
                    errors.rejectValue("taiKhoan", "nguoiDung.taiKhoan.alreadyHaveErr");
            }
        }
        if(nd.getVaiTro().equals("SINH_VIEN") && nd.getNganh()==null){
            errors.rejectValue("nganh", "nguoiDung.nganh.nullErr");
        }
    }
    
}
