/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.GiangVienChamDiem;
import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.repository.GiangVienChamDiemRepository;
import com.thao.repository.GiangVienThuocHoiDongRepository;
import com.thao.repository.KhoaLuanTotNghiepRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
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
public class GiangVienChamDiemRepositoryImpl implements GiangVienChamDiemRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private KhoaLuanTotNghiepRepository khoaLuanRepo;
    @Autowired
    private GiangVienThuocHoiDongRepository giangVienThuocHoiDongRepo;

    @Override
    public List<GiangVienChamDiem> getDiemKhoaLuan(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<GiangVienChamDiem> q = b.createQuery(GiangVienChamDiem.class);
        Root root = q.from(GiangVienChamDiem.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String khoaLuanId = params.get("khoaLuanId");
            if (khoaLuanId != null && !khoaLuanId.isEmpty()) {
                predicates.add(b.equal(root.get("khoaLuanId.id"), Integer.parseInt(khoaLuanId)));
            }
            String giangVienId = params.get("giangVienId");
            if (giangVienId != null && !giangVienId.isEmpty()) {
                predicates.add(b.equal(root.get("giangVienThuocHoiDongId.id"), Integer.parseInt(giangVienId)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addGiangVienChamDiem(float diem, LocalDateTime ngayCham, int giangVienThuocHoiDongId, int khoaLuanId) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            GiangVienChamDiem gv = new GiangVienChamDiem();
            gv.setDiem(diem);
            gv.setNgayCham(Date.from(ngayCham.atZone(ZoneId.systemDefault()).toInstant()));
            Query q1 = s.createQuery("from GiangVienThuocHoiDong where id = :giangVienThuocHoiDongId");
            q1.setParameter("giangVienThuocHoiDongId", giangVienThuocHoiDongId);
            Query q2 = s.createQuery("from KhoaLuanTotNghiep where id = :khoaLuanId");
            q2.setParameter("khoaLuanId", khoaLuanId);
            gv.setGiangVienThuocHoiDongId((GiangVienThuocHoiDong) q1.getSingleResult());
            gv.setKhoaLuanId((KhoaLuanTotNghiep) q2.getSingleResult());
            s.save(gv);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGiangVienChamDiem(int id, Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (params != null) {
                GiangVienChamDiem gv = getGiangVienChamDiemById(id);
                String tmp = params.get("diem");
                if (tmp != null && !tmp.isEmpty()) {
                    gv.setDiem(Float.parseFloat(tmp));
                }
                tmp = params.get("ngayCham");
                if (tmp != null && !tmp.isEmpty()) {
                    gv.setNgayCham(Date.from(LocalDateTime.parse(tmp).atZone(ZoneId.systemDefault()).toInstant()));
                }
                tmp = params.get("giangVienThuocHoiDongId");
                if (tmp != null && !tmp.isEmpty()) {
                    gv.setGiangVienThuocHoiDongId(this.giangVienThuocHoiDongRepo.getGiangVienThuocHoiDongById(Integer.parseInt(tmp)));
                }
                tmp = params.get("khoaLuanId");
                if (tmp != null && !tmp.isEmpty()) {
                    gv.setKhoaLuanId(this.khoaLuanRepo.getKhoaLuanById(Integer.parseInt(tmp)));
                }
                s.update(gv);
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public GiangVienChamDiem getGiangVienChamDiemById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(GiangVienChamDiem.class, id);
    }

    @Override
    public boolean updateGiangVienChamDiem(GiangVienChamDiem gv) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.update(gv);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteGiangVienChamDiem(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.delete(this.getGiangVienChamDiemById(id));
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addGiangVienChamDiem(GiangVienChamDiem gv) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(gv);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Double tongDiem(int klId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("select sum(diem) from GiangVienChamDiem where khoaLuanId.id = :klId group by khoaLuanId");
        q.setParameter("klId", klId);
        return (Double) q.getSingleResult();
    }

    @Override
    public Double diemTrungBinh(int klId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("select avg(diem) from GiangVienChamDiem where khoaLuanId.id = :klId group by khoaLuanId");
        q.setParameter("klId", klId);
        return (Double) q.getSingleResult();
    }

//    @Override
//    public Long demHoiDongChamKhoaLuan(int hd) {
//        Session s = this.factory.getObject().getCurrentSession();
//        //Query q = s.createNativeQuery("select count(khoa_luan_id) OVER() from giang_vien_cham_diem a join giang_vien_thuoc_hoi_dong b on a.giang_vien_thuoc_hoi_dong_id = b.id join hoi_dong_bao_ve_khoa_luan c on b.hoi_dong_id = c.id where c.id = ? group by c.id, a.khoa_luan_id");
//        Query q = s.createQuery("select count(distinct khoaLuanId) from GiangVienChamDiem where giangVienThuocHoiDongId.hoiDongId.id = :hd");
//        q.setParameter("hd", hd);
//        return (Long) q.getSingleResult();
//    }
    @Override
    public List<Object[]> getDiemKhoaLuanOrderByKhoaLuanId(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Query q = s.createQuery("select khoaLuanId.id, khoaLuanId.tenKhoaLuan, avg(diem) from GiangVienChamDiem group by khoaLuanId order by khoaLuanId");
            List<Object[]> tmp = q.getResultList();
            for(int i = 0; i < tmp.size(); i++){
                Object[] test = new Object[4];
                q=s.createQuery("select id, giangVienThuocHoiDongId.nguoiDungId.ho, giangVienThuocHoiDongId.nguoiDungId.ten, diem, ngayCham from GiangVienChamDiem where khoaLuanId.id = :klID");
                q.setParameter("klID", tmp.get(0)[0]);
                test[0] = tmp.get(0)[0];
                test[1] = tmp.get(0)[1];
                test[2] = tmp.get(0)[2];
                test[3] = q.getResultList();
                tmp.add(test);
                tmp.remove(tmp.get(0));
            }
            return tmp;
        }catch(NoResultException ex){
            return null;
        }
    }

}
