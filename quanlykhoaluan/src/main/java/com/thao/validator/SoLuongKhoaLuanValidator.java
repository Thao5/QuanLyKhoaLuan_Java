/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.validator;

import com.thao.pojo.GiangVienHuongDanKhoaLuan;
import com.thao.repository.GiangVienHuongDanKhoaLuanRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Chung Vu
 */
@Component
//@DependsOn("giangVienHuongDanKhoaLuanRepository")
//@Order(Ordered.LOWEST_PRECEDENCE)
public class SoLuongKhoaLuanValidator implements Validator{
    @Autowired
    private GiangVienHuongDanKhoaLuanRepository gvRepo;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return GiangVienHuongDanKhoaLuan.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        GiangVienHuongDanKhoaLuan gv = (GiangVienHuongDanKhoaLuan) target;
        if(this.gvRepo.demGiangVienHuongDanCuaKhoaLuan(gv.getKhoaLuanId().getId()) >= 2 && gv.getId() == null){
            errors.rejectValue("khoaLuanId", "giangVienHuongDan.khoaLuanId.soLuongKhoaLuanMsg");
        }
        Map<String,String> tmp = new HashMap<>();
        tmp.put("giangVienId", gv.getNguoiDungId().getId().toString());
        tmp.put("khoaLuanId", gv.getKhoaLuanId().getId().toString());
        if(!this.gvRepo.getGiangVienHuongDans(tmp).isEmpty() && this.gvRepo.getGiangVienHuongDans(tmp) != null){
            errors.rejectValue("khoaLuanId", "giangVienHuongDan.nguoiDungId.distinctErr");
            errors.rejectValue("nguoiDungId", "giangVienHuongDan.nguoiDungId.distinctErr");
        }
    }
}
