/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.pojo.HoiDongBaoVeKhoaLuan;
import com.thao.pojo.NguoiDung;
import com.thao.repository.GiangVienThuocHoiDongRepository;
import com.thao.repository.HoiDongBaoVeKhoaLuanRepository;
import com.thao.repository.NguoiDungRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
    @Autowired
    private NguoiDungRepository nguoiDungRepo;
    @Autowired
    private HoiDongBaoVeKhoaLuanRepository hoiDongRepo;
    
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
                predicates.add(b.equal(root.get("hoiDongId.id"), Integer.parseInt(kw)));
            }
            String ndID = params.get("ndID");
            if(ndID != null && !ndID.isEmpty()){
                System.out.println(ndID);
                predicates.add(b.equal(root.get("nguoiDungId"), Integer.parseInt(ndID)));
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

    @Override
    public boolean addGiangVienThuocHoiDong(String vaiTro, LocalDateTime ngayVaoHoiDong, int giangVienId, int hoiDongId) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            GiangVienThuocHoiDong gv = new GiangVienThuocHoiDong();
            gv.setVaiTro(vaiTro);
            gv.setNgayVaoHoiDong(Date.from(ngayVaoHoiDong.atZone(ZoneId.systemDefault()).toInstant()));
            Query q1 = s.createQuery("from NguoiDung where id = :giangVienId");
            q1.setParameter("giangVienId", giangVienId);
            Query q2 = s.createQuery("from HoiDongBaoVeKhoaLuan where id = :hoiDongId");
            q2.setParameter("hoiDongId", hoiDongId);
            gv.setNguoiDungId((NguoiDung)q1.getSingleResult());
            gv.setHoiDongId((HoiDongBaoVeKhoaLuan)q2.getSingleResult());
            s.save(gv);
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGiangVienThuocHoiDong(int id, Map<String, String> params) {
       Session s = this.factory.getObject().getCurrentSession();
       try{
           if(params != null){
               GiangVienThuocHoiDong gv = getGiangVienThuocHoiDongById(id);
               String tmp = params.get("vaiTro");
               if(tmp != null && !tmp.isEmpty()){
                   gv.setVaiTro(tmp);
               }
               tmp = params.get("ngayVaoHoiDong");
               if(tmp != null && !tmp.isEmpty()){
                   gv.setNgayVaoHoiDong(Date.from(LocalDate.parse(tmp).atStartOfDay(ZoneId.systemDefault()).toInstant()));
               }
               tmp = params.get("nguoiDungId");
               if(tmp != null && !tmp.isEmpty()){
                   gv.setNguoiDungId(this.nguoiDungRepo.getNguoiDungById(Integer.parseInt(tmp)));
               }
               tmp = params.get("hoiDongId");
               if(tmp != null && !tmp.isEmpty()){
                   gv.setHoiDongId(this.hoiDongRepo.getHoiDongById(Integer.parseInt(tmp)));
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
    public GiangVienThuocHoiDong getGiangVienThuocHoiDongById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(GiangVienThuocHoiDong.class, id);
    }

    @Override
    public boolean updateGiangvienThuocHoiDong(GiangVienThuocHoiDong gv) {
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
    public boolean addGiangVienThuocHoiDong(GiangVienThuocHoiDong gv) {
        Session s = this.factory.getObject().getCurrentSession();
        try{
            s.save(gv);
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Long demGiangVienThuocHoiDong(int hdId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("select count(*) from GiangVienThuocHoiDong where hoiDongId.id = :hdId group by hoiDongId");
        q.setParameter("hdId", hdId);
        return (Long) q.getSingleResult();
    }

    @Override
    public GiangVienThuocHoiDong getGiangVienThuocHoiDongByNguoiDungAndHoiDong(int ndID, int hdID) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q= s.createQuery("from GiangVienThuocHoiDong where hoiDongId.id = :hdID and nguoiDungId.id = :ndID");
        q.setParameter("hdID", hdID);
        q.setParameter("ndID", ndID);
        try{
            return (GiangVienThuocHoiDong) q.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }
    
    
}
