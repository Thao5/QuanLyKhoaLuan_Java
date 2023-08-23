/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.formatters;

import com.thao.pojo.HoiDongBaoVeKhoaLuan;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Chung Vu
 */
public class HoiDongBaoVeKhoaLuanFormatter implements Formatter<HoiDongBaoVeKhoaLuan>{

    @Override
    public String print(HoiDongBaoVeKhoaLuan object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public HoiDongBaoVeKhoaLuan parse(String text, Locale locale) throws ParseException {
        return new HoiDongBaoVeKhoaLuan(Integer.parseInt(text));
    }
    
}
