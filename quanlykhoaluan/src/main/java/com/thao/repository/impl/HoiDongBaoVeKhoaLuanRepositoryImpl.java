/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.pojo.HoiDongBaoVeKhoaLuan;
import com.thao.repository.HoiDongBaoVeKhoaLuanRepository;
import java.util.ArrayList;
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
public class HoiDongBaoVeKhoaLuanRepositoryImpl implements HoiDongBaoVeKhoaLuanRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<HoiDongBaoVeKhoaLuan> getHoiDongBaoVeKhoaLuans(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<HoiDongBaoVeKhoaLuan> q = b.createQuery(HoiDongBaoVeKhoaLuan.class);
        Root root = q.from(HoiDongBaoVeKhoaLuan.class);
        q.select(root);
        
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("hoiDongId");
            if(kw != null && !kw.isEmpty()){
                predicates.add(b.equal(root.get("id"), Integer.parseInt(kw)));
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
    public boolean addHoiDongBaoVeKhoaLuan(HoiDongBaoVeKhoaLuan hd) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            s.save(hd);
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    
    
    
}