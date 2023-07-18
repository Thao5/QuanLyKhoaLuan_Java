/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chung Vu
 */
@Entity
@Table(name = "hoi_dong_bao_ve_khoa_luan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoiDongBaoVeKhoaLuan.findAll", query = "SELECT h FROM HoiDongBaoVeKhoaLuan h"),
    @NamedQuery(name = "HoiDongBaoVeKhoaLuan.findById", query = "SELECT h FROM HoiDongBaoVeKhoaLuan h WHERE h.id = :id"),
    @NamedQuery(name = "HoiDongBaoVeKhoaLuan.findByNgayThanhLap", query = "SELECT h FROM HoiDongBaoVeKhoaLuan h WHERE h.ngayThanhLap = :ngayThanhLap"),
    @NamedQuery(name = "HoiDongBaoVeKhoaLuan.findByNgayKhoa", query = "SELECT h FROM HoiDongBaoVeKhoaLuan h WHERE h.ngayKhoa = :ngayKhoa")})
public class HoiDongBaoVeKhoaLuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_thanh_lap")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayThanhLap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_khoa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayKhoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoiDongId")
    private Set<GiangVienThuocHoiDong> giangVienThuocHoiDongSet;
    @OneToMany(mappedBy = "hoiDongId")
    private Set<KhoaLuanTotNghiep> khoaLuanTotNghiepSet;

    public HoiDongBaoVeKhoaLuan() {
    }

    public HoiDongBaoVeKhoaLuan(Integer id) {
        this.id = id;
    }

    public HoiDongBaoVeKhoaLuan(Integer id, Date ngayThanhLap, Date ngayKhoa) {
        this.id = id;
        this.ngayThanhLap = ngayThanhLap;
        this.ngayKhoa = ngayKhoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(Date ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    public Date getNgayKhoa() {
        return ngayKhoa;
    }

    public void setNgayKhoa(Date ngayKhoa) {
        this.ngayKhoa = ngayKhoa;
    }

    @XmlTransient
    public Set<GiangVienThuocHoiDong> getGiangVienThuocHoiDongSet() {
        return giangVienThuocHoiDongSet;
    }

    public void setGiangVienThuocHoiDongSet(Set<GiangVienThuocHoiDong> giangVienThuocHoiDongSet) {
        this.giangVienThuocHoiDongSet = giangVienThuocHoiDongSet;
    }

    @XmlTransient
    public Set<KhoaLuanTotNghiep> getKhoaLuanTotNghiepSet() {
        return khoaLuanTotNghiepSet;
    }

    public void setKhoaLuanTotNghiepSet(Set<KhoaLuanTotNghiep> khoaLuanTotNghiepSet) {
        this.khoaLuanTotNghiepSet = khoaLuanTotNghiepSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoiDongBaoVeKhoaLuan)) {
            return false;
        }
        HoiDongBaoVeKhoaLuan other = (HoiDongBaoVeKhoaLuan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thao.pojo.HoiDongBaoVeKhoaLuan[ id=" + id + " ]";
    }
    
}
