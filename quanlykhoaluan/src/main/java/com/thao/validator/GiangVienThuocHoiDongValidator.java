/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.validator;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.repository.GiangVienThuocHoiDongRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Chung Vu
 */
@Component
public class GiangVienThuocHoiDongValidator implements Validator {

    @Autowired
    private GiangVienThuocHoiDongRepository gvthdSer;

    @Override
    public boolean supports(Class<?> clazz) {
        return GiangVienThuocHoiDong.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        GiangVienThuocHoiDong gv = (GiangVienThuocHoiDong) target;
        if (gvthdSer.demGiangVienThuocHoiDong(gv.getHoiDongId().getId()) >= 5 && gv.getId() == null) {
            errors.rejectValue("nguoiDungId", "giangVienThuocHoiDong.nguoiDungId.soLuongGiangVienErr");
        }
        Map<String, String> tmp = new HashMap<>();
        tmp.put("hoiDongId", gv.getHoiDongId().getId().toString());
        tmp.put("ndID", gv.getNguoiDungId().getId().toString());
        List<GiangVienThuocHoiDong> listGvTmp = this.gvthdSer.getGiangVienThuocHoiDong(tmp);
        if(!listGvTmp.isEmpty() && listGvTmp != null && gv.getId() == null){
            errors.rejectValue("nguoiDungId", "giangVienThuocHoiDong.nguoiDungId.distinctVienErr");
        }
    }
}
