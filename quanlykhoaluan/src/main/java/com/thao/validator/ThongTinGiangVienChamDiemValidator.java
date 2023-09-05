/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.validator;

import com.thao.pojo.ThongTinGiangVienChamDiem;
import com.thao.repository.GiangVienChamDiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Chung Vu
 */
@Component
public class ThongTinGiangVienChamDiemValidator implements Validator{
    @Autowired
    private GiangVienChamDiemRepository gvcdRepo;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return ThongTinGiangVienChamDiem.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ThongTinGiangVienChamDiem tt = (ThongTinGiangVienChamDiem) target;
        if(this.gvcdRepo.getGiangVienChamDiemTheoNDAndKL(tt.getNdId(), tt.getKlId()) != null){
            errors.rejectValue("klId", "thongTinGiangVienChamDiem.listCT.distinctErr");
        }
        if(tt.getListTC().isEmpty() || tt.getListTC() == null){
            errors.rejectValue("klId", "thongTinGiangVienChamDiem.klId.nullErr");
        }
    }
    
    
}
