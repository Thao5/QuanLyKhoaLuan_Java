/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.formatters;

import com.thao.pojo.NguoiDung;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Chung Vu
 */
public class NguoiDungFormatter implements Formatter<NguoiDung>{

    @Override
    public String print(NguoiDung object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public NguoiDung parse(String text, Locale locale) throws ParseException {
        return new NguoiDung(Integer.parseInt(text));
    }
    
}
