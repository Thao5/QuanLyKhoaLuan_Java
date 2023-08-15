/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.repository.StatsRepository;
import com.thao.service.StatsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chung Vu
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepo;

    @Override
    public List<Object[]> statDiem(Map<String, String> params) {
        return this.statsRepo.statDiem(params);
    }

    @Override
    public List<Object[]> statTuanSuatTheoNganh(Map<String, String> params) {
        return this.statsRepo.statTuanSuatTheoNganh(params);
    }

    @Override
    public List<Object[]> statDTB(int klId) {
        return this.statsRepo.statDTB(klId);
    }
    
    
}
