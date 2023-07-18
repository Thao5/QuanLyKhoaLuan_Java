/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.NguoiDung;
import com.thao.repository.NguoiDungRepository;
import com.thao.service.NguoiDungService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chung Vu
 */
@Service
public class NguoiDungServiceImpl implements NguoiDungService{
    @Autowired
    private NguoiDungRepository nguoiDungRepo;

    @Override
    public List<NguoiDung> getNguoiDungs(Map<String, String> params) {
        return this.nguoiDungRepo.getNguoiDungs(params);
    }
    
    
}
