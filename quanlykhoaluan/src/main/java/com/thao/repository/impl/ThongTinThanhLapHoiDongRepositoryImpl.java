/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository.impl;

import com.thao.pojo.GiangVienThuocHoiDong;
import com.thao.pojo.HoiDongBaoVeKhoaLuan;
import com.thao.pojo.KhoaLuanTotNghiep;
import com.thao.pojo.ThongTinThanhLapHoiDong;
import com.thao.repository.ThongTinThanhLapHoiDongRepository;
import com.thao.service.KhoaLuanTotNghiepService;
import com.thao.service.NguoiDungService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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
public class ThongTinThanhLapHoiDongRepositoryImpl implements ThongTinThanhLapHoiDongRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private KhoaLuanTotNghiepService klSer;
    @Autowired
    private NguoiDungService ndSer;

    @Override
    public boolean addThongTinThanhLapHoiDong(ThongTinThanhLapHoiDong hd) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            HoiDongBaoVeKhoaLuan hdbv = new HoiDongBaoVeKhoaLuan();
            hdbv.setTenHoiDong(hd.getTenHoiDong());
            hdbv.setIsActive(true);
            hdbv.setNgayKhoa(hd.getNgayKhoa());
            hdbv.setNgayThanhLap(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
            s.save(hdbv);
            KhoaLuanTotNghiep kl = this.klSer.getKhoaLuanById(hd.getKl().getId());
            kl.setHoiDongId(hdbv);
            s.update(kl);
            GiangVienThuocHoiDong gv = new GiangVienThuocHoiDong();
            gv.setVaiTro("CHU_TICH");
            gv.setNgayVaoHoiDong(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
            gv.setNguoiDungId(this.ndSer.getNguoiDungById(hd.getGiangVienCT().getId()));
            gv.setHoiDongId(hdbv);
            s.save(gv);
            GiangVienThuocHoiDong gv1 = new GiangVienThuocHoiDong();
            gv1.setVaiTro("THU_KY");
            gv1.setNgayVaoHoiDong(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
            gv1.setNguoiDungId(this.ndSer.getNguoiDungById(hd.getGiangVienTK().getId()));
            gv1.setHoiDongId(hdbv);
            s.save(gv1);
            GiangVienThuocHoiDong gv2 = new GiangVienThuocHoiDong();
            gv2.setVaiTro("PHAN_BIEN");
            gv2.setNgayVaoHoiDong(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
            gv2.setNguoiDungId(this.ndSer.getNguoiDungById(hd.getGiangVienPB().getId()));
            gv2.setHoiDongId(hdbv);
            s.save(gv2);
            if (hd.getGiangVienTV1() != null) {
                GiangVienThuocHoiDong gv3 = new GiangVienThuocHoiDong();
                gv3.setVaiTro("THANH_VIEN");
                gv3.setNgayVaoHoiDong(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
                gv3.setNguoiDungId(this.ndSer.getNguoiDungById(hd.getGiangVienTV1().getId()));
                gv3.setHoiDongId(hdbv);
                s.save(gv3);
            }
            if(hd.getGiangVienTV2() != null){
                GiangVienThuocHoiDong gv4 = new GiangVienThuocHoiDong();
                gv4.setVaiTro("THANH_VIEN");
                gv4.setNgayVaoHoiDong(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
                gv4.setNguoiDungId(this.ndSer.getNguoiDungById(hd.getGiangVienTV2().getId()));
                gv4.setHoiDongId(hdbv);
                s.save(gv4);
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

}
