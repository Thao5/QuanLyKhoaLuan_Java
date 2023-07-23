/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thao.service;

import com.thao.pojo.TieuChi;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chung Vu
 */
public interface TieuChiService {
    List<TieuChi> getTieuChis(Map<String, String> params);
    boolean addTieuChi(TieuChi tc);
}
