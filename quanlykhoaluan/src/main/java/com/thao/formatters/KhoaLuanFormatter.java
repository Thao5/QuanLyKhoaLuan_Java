/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.formatters;

import com.thao.pojo.KhoaLuanTotNghiep;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Chung Vu
 */
public class KhoaLuanFormatter implements Formatter<KhoaLuanTotNghiep>{

    @Override
    public String print(KhoaLuanTotNghiep kl, Locale locale) {
        return String.valueOf(kl.getId());
    }

    @Override
    public KhoaLuanTotNghiep parse(String klId, Locale locale) throws ParseException {
        return new KhoaLuanTotNghiep(Integer.parseInt(klId));
    }
    
}
