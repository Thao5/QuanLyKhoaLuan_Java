/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thao.repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Chung Vu
 */
public interface StatsRepository {
    List<Object[]> statDiem(Map<String, String> params);
    List<Object[]> statTuanSuatTheoNganh(Map<String,String> params);
    List<Object[]> statDTB(int klId);
}