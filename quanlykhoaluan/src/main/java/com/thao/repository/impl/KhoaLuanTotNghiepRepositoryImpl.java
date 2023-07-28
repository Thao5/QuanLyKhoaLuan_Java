/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.GiangVienChamDiem;
import com.thao.pojo.HoiDongBaoVeKhoaLuan;
import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.pojo.NguoiDung;
import com.thao.repository.KhoaLuanTotNghiepRepository;
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
public class KhoaLuanTotNghiepRepositoryImpl implements KhoaLuanTotNghiepRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<KhoaLuanTotNghiep> getKhoaLuans(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<KhoaLuanTotNghiep> q = b.createQuery(KhoaLuanTotNghiep.class);
        Root root = q.from(KhoaLuanTotNghiep.class);
        q.select(root);
        
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if(kw != null && !kw.isEmpty()){
                predicates.add(b.like(root.get("tenKhoaLuan"), String.format("%%%s%%", kw)));
            }
            String khoaLuanId = params.get("khoaLuanId");
            if(khoaLuanId != null && !khoaLuanId.isEmpty()){
                predicates.add(b.equal(root.get("id"), Integer.parseInt(khoaLuanId)));
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
    public List<KhoaLuanTotNghiep> getDanhSachSinhVienLamKhoaLuanTheoId(Map<String,String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<NguoiDung> q = b.createQuery(NguoiDung.class);
        Root root = q.from(NguoiDung.class);
        q.select(root);
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            String id = params.get("klId");
            if(id != null && !id.isEmpty()){
                predicates.add(b.equal(root.get("khoaLuanId"), Integer.parseInt(id)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<KhoaLuanTotNghiep> getDanhSachKhoaLuanDuocGhiNhanBoiGiaoVuTheoId(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<KhoaLuanTotNghiep> q = b.createQuery(KhoaLuanTotNghiep.class);
        Root root = q.from(KhoaLuanTotNghiep.class);
        q.select(root);
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            String giaoVu = params.get("giaoVuId");
            if(giaoVu != null && !giaoVu.isEmpty()){
                predicates.add(b.equal(root.get("giaoVuId"), Integer.parseInt(giaoVu)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addKhoaLuan(KhoaLuanTotNghiep kl) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            s.save(kl);
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateKhoaLuan(int id, Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            
            if(params != null){
                KhoaLuanTotNghiep kl = (KhoaLuanTotNghiep) s.get(KhoaLuanTotNghiep.class, id);
                String tmp = params.get("tenKhoaLuan");
                if(tmp != null && !tmp.isEmpty()){
                    kl.setTenKhoaLuan(tmp);
                }
                tmp = params.get("ngayGhiNhan");
                if(tmp != null && !tmp.isEmpty()){
                    kl.setNgayGhiNhan(Date.from(LocalDate.parse(tmp).atStartOfDay(ZoneId.systemDefault()).toInstant()));
                }
                tmp = params.get("ngayKetThuc");
                if(tmp != null && !tmp.isEmpty()){
                    kl.setNgayGhiNhan(Date.from(LocalDate.parse(tmp).atStartOfDay(ZoneId.systemDefault()).toInstant()));
                }
                tmp = params.get("giaoVuId");
                if(tmp != null && !tmp.isEmpty()){
                    kl.setGiaoVuId((NguoiDung) s.get(NguoiDung.class, Integer.parseInt(tmp)));
                }
                tmp = params.get("hoiDongId");
                if(tmp != null && !tmp.isEmpty()){
                    kl.setHoiDongId((HoiDongBaoVeKhoaLuan) s.get(HoiDongBaoVeKhoaLuan.class, Integer.parseInt(tmp)));
                }
                s.update(kl);
            }
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    
}
