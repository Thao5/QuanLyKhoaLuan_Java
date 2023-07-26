/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.GiangVienChamDiem;
import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.repository.GiangVienChamDiemRepository;
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
@Transactional
public class GiangVienChamDiemRepositoryImpl implements GiangVienChamDiemRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<GiangVienChamDiem> getDiemKhoaLuan(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<GiangVienChamDiem> q = b.createQuery(GiangVienChamDiem.class);
        Root root = q.from(GiangVienChamDiem.class);
        q.select(root);
        
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            String khoaLuanId = params.get("khoaLuanId");
            if(khoaLuanId != null && !khoaLuanId.isEmpty()){
                predicates.add(b.equal(root.get("khoaLuanId"), Integer.parseInt(khoaLuanId)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addGiangVienChamDiem(float diem, LocalDate ngayCham, int giangVienThuocHoiDongId, int khoaLuanId) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            GiangVienChamDiem gv = new GiangVienChamDiem();
            gv.setDiem(diem);
            gv.setNgayCham(Date.from(ngayCham.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            Query q1 = s.createQuery("from GiangVienThuocHoiDong where id = :giangVienThuocHoiDongId");
            q1.setParameter("giangVienThuocHoiDongId", giangVienThuocHoiDongId);
            Query q2 = s.createQuery("from KhoaLuanTotNghiep where id = :khoaLuanId");
            q2.setParameter("khoaLuanId", khoaLuanId);
            gv.setGiangVienThuocHoiDongId((GiangVienThuocHoiDong)q1.getSingleResult());
            gv.setKhoaLuanId((KhoaLuanTotNghiep)q2.getSingleResult());
            s.save(gv);
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    
}
