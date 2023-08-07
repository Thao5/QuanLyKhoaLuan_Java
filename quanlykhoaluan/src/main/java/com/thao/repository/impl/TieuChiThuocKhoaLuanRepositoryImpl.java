/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.pojo.TieuChi;
import com.thao.pojo.TieuChiThuocKhoaLuan;
import com.thao.repository.KhoaLuanTotNghiepRepository;
import com.thao.repository.TieuChiRepository;
import com.thao.repository.TieuChiThuocKhoaLuanRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chung Vu
 */
@Repository
@PropertySource("classpath:configs.properties")
@Transactional
public class TieuChiThuocKhoaLuanRepositoryImpl implements TieuChiThuocKhoaLuanRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Autowired
    private KhoaLuanTotNghiepRepository khoaLuanRepo;
    @Autowired
    private TieuChiRepository tieuChiRepo;

    @Override
    public List<TieuChiThuocKhoaLuan> getTieuChiThuocKhoaLuans(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("from TieuChiThuocKhoaLuan");
        if(params != null){
            if(params.get("klId")!= null && !params.get("klId").isEmpty()){
                q = s.createQuery("from TieuChiThuocKhoaLuan where khoaLuanId = :khoaLuanId");
                q.setParameter("khoaLuanId", params.get("klId")); 
            }
        }
        return q.getResultList();
    }

    @Override
    public boolean addTieuChiThuocKhoaLuan(int tieuChiId, int khoaLuanId) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            Query q1 = s.createQuery("from TieuChi where id = :tieuChiId");
            q1.setParameter("tieuChiId", tieuChiId);
            Query q2 = s.createQuery("from KhoaLuanTotNghiep where id = :khoaLuanId");
            q2.setParameter("khoaLuanId", khoaLuanId);
            TieuChiThuocKhoaLuan tc = new TieuChiThuocKhoaLuan();
            tc.setTieuChiId((TieuChi)q1.getSingleResult());
            tc.setKhoaLuanId((KhoaLuanTotNghiep)q2.getSingleResult());
            s.save(tc);
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTieuChiThuocKhoaLuan(int id, Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            if(params != null){
                TieuChiThuocKhoaLuan tc = getTieuChiThuocKhoaLuanById(id);
                String tmp = params.get("khoaLuanId");
                if(tmp != null && !tmp.isEmpty()){
                    tc.setKhoaLuanId(this.khoaLuanRepo.getKhoaLuanById(Integer.parseInt(tmp)));
                }
                tmp = params.get("tieuChiId");
                if(tmp != null && !tmp.isEmpty()){
                    tc.setTieuChiId(this.tieuChiRepo.getTieuChiById(Integer.parseInt(tmp)));
                }
                s.update(tc);
            }
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public TieuChiThuocKhoaLuan getTieuChiThuocKhoaLuanById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(TieuChiThuocKhoaLuan.class, id);
    }

    @Override
    public boolean updateTieuChiThuocKhoaLuan(TieuChiThuocKhoaLuan tc) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            s.update(tc);
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteTieuChiThuocKhoaLuan(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            s.delete(this.getTieuChiThuocKhoaLuanById(id));
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addTieuChiThuocKhoaLuan(TieuChiThuocKhoaLuan tc) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            s.save(tc);
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    
}
