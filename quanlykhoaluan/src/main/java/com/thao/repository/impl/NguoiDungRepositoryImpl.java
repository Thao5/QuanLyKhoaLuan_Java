/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.NguoiDung;
import com.thao.repository.NguoiDungRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class NguoiDungRepositoryImpl implements NguoiDungRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<NguoiDung> getNguoiDungs(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<NguoiDung> q = b.createQuery(NguoiDung.class);
        Root root = q.from(NguoiDung.class);
        q.select(root);
        
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if(kw != null && !kw.isEmpty()){
                predicates.add(b.like(root.get("ten"), String.format("%%%s%%", kw)));
            }
            String role = params.get("vaiTro");
            if(role != null && !role.isEmpty()){
                predicates.add(b.equal(root.get("vaiTro"), role));
            }
            String userId = params.get("nguoiDungId");
            if(userId != null && !userId.isEmpty()){
                predicates.add(b.equal(root.get("id"), Integer.parseInt(userId)));
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
    public Boolean addNguoiDung(NguoiDung user) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("from NguoiDung where taiKhoan = :taiKhoan OR email = :email or sdt = :sdt");
        q.setParameter("taiKhoan", user.getTaiKhoan());
        q.setParameter("email", user.getEmail());
        q.setParameter("sdt", user.getSdt());
        try{
            NguoiDung tmp = (NguoiDung)q.getSingleResult();
        }catch(Exception ex){
            user.setCreatedDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            s.save(user);
            return true;
        }
        return false;
    }
    
    
}
