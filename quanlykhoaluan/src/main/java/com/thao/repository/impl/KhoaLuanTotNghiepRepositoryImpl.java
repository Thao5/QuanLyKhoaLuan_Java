/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.repository.KhoaLuanTotNghiepRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
            }
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
    
}
