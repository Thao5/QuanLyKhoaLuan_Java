/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.TieuChi;
import com.thao.repository.TieuChiRepository;
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
public class TieuChiRepositoryImpl  implements TieuChiRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<TieuChi> getTieuChis(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<TieuChi> q = b.createQuery(TieuChi.class);
        Root root = q.from(TieuChi.class);
        q.select(root);
        
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if(kw != null && !kw.isEmpty()){
                predicates.add(b.like(root.get("noiDungTieuChi"), String.format("%%%s%%", kw)));
            }
            String klId = params.get("klId");
            if(klId != null && !klId.isEmpty()){
                predicates.add(b.equal(root.get("khoaLuanId"), Integer.parseInt(klId)));
            }
            String tieuChiId = params.get("tieuChiId");
            if(tieuChiId != null && !tieuChiId.isEmpty()){
                predicates.add(b.equal(root.get("id"), Integer.parseInt(tieuChiId)));
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
    public boolean addTieuChi(TieuChi tc) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            s.save(tc);
            return true;
        }
        catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateTieuChi(int id, Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            
            if(params != null){
                TieuChi tc = getTieuChiById(id);
                String tmp = params.get("noiDungTieuChi");
                if(tmp != null && !tmp.isEmpty()){
                    tc.setNoiDungTieuChi(tmp);
                }
                tmp = params.get("diem");
                if(tmp != null && !tmp.isEmpty()){
                    tc.setDiem(Float.parseFloat(tmp));
                }
                s.update(tc);
            }
        }
        catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTieuChi(TieuChi tc) {
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
    public TieuChi getTieuChiById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(TieuChi.class, id);
    }

    @Override
    public boolean deleteTieuChi(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            TieuChi tc = this.getTieuChiById(id);
            if(!tc.getTieuChiThuocKhoaLuanSet().isEmpty()){
                tc.getTieuChiThuocKhoaLuanSet().forEach((t) -> s.delete(t));
            }
            s.delete(tc);
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    
}
