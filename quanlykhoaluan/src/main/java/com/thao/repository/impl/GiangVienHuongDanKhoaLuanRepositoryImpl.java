/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.GiangVienHuongDanKhoaLuan;
import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.pojo.NguoiDung;
import com.thao.repository.GiangVienHuongDanKhoaLuanRepository;
import com.thao.repository.KhoaLuanTotNghiepRepository;
import com.thao.repository.NguoiDungRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class GiangVienHuongDanKhoaLuanRepositoryImpl implements GiangVienHuongDanKhoaLuanRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Autowired
    private NguoiDungRepository nguoiDungRepo;
    @Autowired
    private KhoaLuanTotNghiepRepository khoaLuanRepo;

    @Override
    public List<GiangVienHuongDanKhoaLuan> getGiangVienHuongDans(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<GiangVienHuongDanKhoaLuan> q = b.createQuery(GiangVienHuongDanKhoaLuan.class);
        Root root = q.from(GiangVienHuongDanKhoaLuan.class);
        q.select(root);
        
        if(params != null){
             List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if(kw != null && !kw.isEmpty()){
                predicates.add(b.like(root.get("nguoiDungId.ten"), String.format("%%%s%%", kw)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }
        
        Query query = s.createQuery(q);
        
        if(params != null){
            String page = params.get("page");
            if(page != null){
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setFirstResult((Integer.parseInt(page)-1)*pageSize);
                query.setMaxResults(pageSize);
            }
        }
        return query.getResultList();
    }

    @Override
    public boolean addGiangVienHuongDanKhoaLuan(int giangVienId, int khoaLuanId,LocalDate ngayHuongDan) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            GiangVienHuongDanKhoaLuan gv = new GiangVienHuongDanKhoaLuan();
            Query q1 = s.createQuery("from NguoiDung where id = :giangVienId");
            q1.setParameter("giangVienId", giangVienId);
            Query q2 = s.createQuery("from KhoaLuanTotNghiep where id = :khoaLuanId");
            q2.setParameter("khoaLuanId", khoaLuanId);
            gv.setNguoiDungId((NguoiDung)q1.getSingleResult());
            gv.setKhoaLuanId((KhoaLuanTotNghiep)q2.getSingleResult());
            gv.setNgayBatDauHuongDan(Date.from(ngayHuongDan.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            s.save(gv);
            
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGiangVienHuongDanKhoaLuan(int id, Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            if(params != null){
                GiangVienHuongDanKhoaLuan gv = getGiangVienHuongDanKhoaLuanById(id);
                String tmp = params.get("ngayBatDauHuongDan");
                if(tmp != null && !tmp.isEmpty()){
                    gv.setNgayBatDauHuongDan(Date.from(LocalDate.parse(tmp).atStartOfDay(ZoneId.systemDefault()).toInstant()));
                }
                tmp = params.get("nguoiDungId");
                if(tmp != null && !tmp.isEmpty()){
                    gv.setNguoiDungId(this.nguoiDungRepo.getNguoiDungById(Integer.parseInt(tmp)));
                }
                tmp = params.get("khoaLuanId");
                if(tmp != null && !tmp.isEmpty()){
                    gv.setKhoaLuanId(this.khoaLuanRepo.getKhoaLuanById(Integer.parseInt(tmp)));
                }
                s.update(gv);
            }
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public GiangVienHuongDanKhoaLuan getGiangVienHuongDanKhoaLuanById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return  s.get(GiangVienHuongDanKhoaLuan.class, id);
    }

    @Override
    public boolean updateGiangVienHuongDanKhoaLuan(GiangVienHuongDanKhoaLuan gv) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            s.update(gv);
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteGiangVienHuongDanKhoaLuan(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            s.delete(this.getGiangVienHuongDanKhoaLuanById(id));
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    
}
