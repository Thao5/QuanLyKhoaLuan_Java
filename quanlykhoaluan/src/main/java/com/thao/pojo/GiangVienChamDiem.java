/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chung Vu
 */
@Entity
@Table(name = "giang_vien_cham_diem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiangVienChamDiem.findAll", query = "SELECT g FROM GiangVienChamDiem g"),
    @NamedQuery(name = "GiangVienChamDiem.findById", query = "SELECT g FROM GiangVienChamDiem g WHERE g.id = :id"),
    @NamedQuery(name = "GiangVienChamDiem.findByDiem", query = "SELECT g FROM GiangVienChamDiem g WHERE g.diem = :diem"),
    @NamedQuery(name = "GiangVienChamDiem.findByNgayCham", query = "SELECT g FROM GiangVienChamDiem g WHERE g.ngayCham = :ngayCham")})
public class GiangVienChamDiem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diem")
    private float diem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_cham")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayCham;
    @JoinColumn(name = "giang_vien_thuoc_hoi_dong_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GiangVienThuocHoiDong giangVienThuocHoiDongId;
    @JoinColumn(name = "khoa_luan_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private KhoaLuanTotNghiep khoaLuanId;

    public GiangVienChamDiem() {
    }

    public GiangVienChamDiem(Integer id) {
        this.id = id;
    }

    public GiangVienChamDiem(Integer id, float diem, Date ngayCham) {
        this.id = id;
        this.diem = diem;
        this.ngayCham = ngayCham;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public Date getNgayCham() {
        return ngayCham;
    }

    public void setNgayCham(Date ngayCham) {
        this.ngayCham = ngayCham;
    }

    public GiangVienThuocHoiDong getGiangVienThuocHoiDongId() {
        return giangVienThuocHoiDongId;
    }

    public void setGiangVienThuocHoiDongId(GiangVienThuocHoiDong giangVienThuocHoiDongId) {
        this.giangVienThuocHoiDongId = giangVienThuocHoiDongId;
    }

    public KhoaLuanTotNghiep getKhoaLuanId() {
        return khoaLuanId;
    }

    public void setKhoaLuanId(KhoaLuanTotNghiep khoaLuanId) {
        this.khoaLuanId = khoaLuanId;
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
        if (!(object instanceof GiangVienChamDiem)) {
            return false;
        }
        GiangVienChamDiem other = (GiangVienChamDiem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thao.pojo.GiangVienChamDiem[ id=" + id + " ]";
    }
    
}
