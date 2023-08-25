/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.formatters;

import com.thao.pojo.TieuChi;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Chung Vu
 */
public class TieuChiFormatter implements Formatter<TieuChi>{

    @Override
    public String print(TieuChi object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public TieuChi parse(String text, Locale locale) throws ParseException {
        return new TieuChi(Integer.parseInt(text));
    }
    
}
