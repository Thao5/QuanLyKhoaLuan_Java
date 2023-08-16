/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.repository.StatsRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chung Vu
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> statDiem(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("select diem, ngayCham, giangVienThuocHoiDongId.nguoiDungId.ho, giangVienThuocHoiDongId.nguoiDungId.ten, khoaLuanId.tenKhoaLuan from GiangVienChamDiem");
        if(params != null){
            String y = params.get("y");
            if(y != null && !y.isEmpty()){
                q = s.createQuery("select diem, ngayCham, giangVienThuocHoiDongId.nguoiDungId.ho, giangVienThuocHoiDongId.nguoiDungId.ten, khoaLuanId.tenKhoaLuan from GiangVienChamDiem where year(ngayCham) = :y");
                q.setParameter("y", Integer.parseInt(y));
            }
        }
        return q.getResultList();
    }

    @Override
    public List<Object[]> statTuanSuatTheoNganh(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("select nganh, count(*) from NguoiDung group by nganh");
        if(params != null){
            String nganh = params.get("nganh");
            if(nganh != null && !nganh.isEmpty()){
                q = s.createQuery("select nganh, count(*) from NguoiDung where nganh = :nganh group by nganh");
                q.setParameter("nganh", nganh);
            }
        }
        return q.getResultList();
    }

    @Override
    public List<Object[]> statDTB(int klId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("select diem, ngayCham, giangVienThuocHoiDongId.nguoiDungId.ho, giangVienThuocHoiDongId.nguoiDungId.ten, khoaLuanId.tenKhoaLuan from GiangVienChamDiem where khoaLuanId.id = :klId");
        q.setParameter("klId", klId);
        return q.getResultList();
    }
    
}
