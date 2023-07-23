/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.repository.GiangVienThuocHoiDongRepository;
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
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chung Vu
 */
@Repository
@Transactional
public class GiangVienThuocHoiDongRepositoryImpl implements GiangVienThuocHoiDongRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<GiangVienThuocHoiDong> getGiangVienThuocHoiDong(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<GiangVienThuocHoiDong> q = b.createQuery(GiangVienThuocHoiDong.class);
        Root root = q.from(GiangVienThuocHoiDong.class);
        q.select(root);
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("hoiDongId");
            if(kw != null && !kw.isEmpty()){
                predicates.add(b.equal(root.get("hoiDongId"), Integer.parseInt(kw)));
            }
            String role = params.get("vaiTro");
            if(role != null && !role.isEmpty()){
                predicates.add(b.equal(root.get("vaiTro"), role));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = s.createQuery(q);
        return query.getResultList();
    }
}
