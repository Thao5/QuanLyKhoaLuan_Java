/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.pojo;

import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author Chung Vu
 */
@Data
public class ThongTinDangKyKhoaLuan {
    private String studentCode;
    private String title;
    private Map<Integer,String> categories;
    private String description;
    private String author;
    private Map<Integer, String> mentor;
}
