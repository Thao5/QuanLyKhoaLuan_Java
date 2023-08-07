/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Type;

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
    @NotNull(message = "{hoiDong.ngayThanhLap.nullErr}")
    @Column(name = "ngay_thanh_lap")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayThanhLap;
    @Basic(optional = false)
    @NotNull(message = "{hoiDong.ngayKhoa.nullErr}")
    @Column(name = "ngay_khoa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayKhoa;
    @Basic(optional = false)
    @NotNull(message = "{hoiDong.tenHoiDong.nullErr}")
    @Size(min = 1, max = 100, message = "{hoiDong.tenHoiDong.lenErr}")
    @Column(name = "ten_hoi_dong")
    private String tenHoiDong;
    @Basic(optional = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoiDongId",fetch=FetchType.LAZY)
    @JsonIgnore
    private Set<GiangVienThuocHoiDong> giangVienThuocHoiDongSet;
    @OneToMany(mappedBy = "hoiDongId",fetch=FetchType.LAZY)
    @JsonIgnore
    private Set<KhoaLuanTotNghiep> khoaLuanTotNghiepSet;

    public HoiDongBaoVeKhoaLuan() {
    }

    public HoiDongBaoVeKhoaLuan(Integer id) {
        this.id = id;
    }

    public HoiDongBaoVeKhoaLuan(Integer id, Date ngayThanhLap, Date ngayKhoa, boolean isActive) {
        this.id = id;
        this.ngayThanhLap = ngayThanhLap;
        this.ngayKhoa = ngayKhoa;
        this.isActive = isActive;
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

    /**
     * @return the tenHoiDong
     */
    public String getTenHoiDong() {
        return tenHoiDong;
    }

    /**
     * @param tenHoiDong the tenHoiDong to set
     */
    public void setTenHoiDong(String tenHoiDong) {
        this.tenHoiDong = tenHoiDong;
    }

    /**
     * @return the isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
}
