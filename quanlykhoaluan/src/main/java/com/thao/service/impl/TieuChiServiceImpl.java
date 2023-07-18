/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.TieuChi;
import com.thao.repository.TieuChiRepository;
import com.thao.service.TieuChiService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chung Vu
 */
@Service
public class TieuChiServiceImpl implements TieuChiService{
    @Autowired
    private TieuChiRepository tieuChiRepository;

    @Override
    public List<TieuChi> getTieuChis(Map<String, String> params) {
        return this.tieuChiRepository.getTieuChis(params);
    }
    
    
}
