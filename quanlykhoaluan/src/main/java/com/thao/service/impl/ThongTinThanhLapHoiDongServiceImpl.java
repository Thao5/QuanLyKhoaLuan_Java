/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.ThongTinThanhLapHoiDong;
import com.thao.repository.ThongTinThanhLapHoiDongRepository;
import com.thao.service.ThongTinThanhLapHoiDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chung Vu
 */
@Service
public class ThongTinThanhLapHoiDongServiceImpl implements ThongTinThanhLapHoiDongService{
    @Autowired
    private ThongTinThanhLapHoiDongRepository tttlhdRepo;

    @Override
    public boolean addThongTinThanhLapHoiDong(ThongTinThanhLapHoiDong hd) {
        return this.tttlhdRepo.addThongTinThanhLapHoiDong(hd);
    }
    
    
}
