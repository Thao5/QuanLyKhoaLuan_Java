/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.formatters;

import com.thao.pojo.GiangVienThuocHoiDong;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Chung Vu
 */
public class GiangVienThuocHoiDongFormatter implements Formatter<GiangVienThuocHoiDong>{

    @Override
    public String print(GiangVienThuocHoiDong object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public GiangVienThuocHoiDong parse(String text, Locale locale) throws ParseException {
        return new GiangVienThuocHoiDong(Integer.parseInt(text));
    }
    
}
