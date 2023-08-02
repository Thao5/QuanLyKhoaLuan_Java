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
@Table(name = "giang_vien_huong_dan_khoa_luan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiangVienHuongDanKhoaLuan.findAll", query = "SELECT g FROM GiangVienHuongDanKhoaLuan g"),
    @NamedQuery(name = "GiangVienHuongDanKhoaLuan.findById", query = "SELECT g FROM GiangVienHuongDanKhoaLuan g WHERE g.id = :id"),
    @NamedQuery(name = "GiangVienHuongDanKhoaLuan.findByNgayBatDauHuongDan", query = "SELECT g FROM GiangVienHuongDanKhoaLuan g WHERE g.ngayBatDauHuongDan = :ngayBatDauHuongDan")})
public class GiangVienHuongDanKhoaLuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{giangVienHuongDan.ngayBatDauHuongDan.nullErr}")
    @Column(name = "ngay_bat_dau_huong_dan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayBatDauHuongDan;
    @JoinColumn(name = "khoa_luan_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private KhoaLuanTotNghiep khoaLuanId;
    @JoinColumn(name = "nguoi_dung_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NguoiDung nguoiDungId;

    public GiangVienHuongDanKhoaLuan() {
    }

    public GiangVienHuongDanKhoaLuan(Integer id) {
        this.id = id;
    }

    public GiangVienHuongDanKhoaLuan(Integer id, Date ngayBatDauHuongDan) {
        this.id = id;
        this.ngayBatDauHuongDan = ngayBatDauHuongDan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayBatDauHuongDan() {
        return ngayBatDauHuongDan;
    }

    public void setNgayBatDauHuongDan(Date ngayBatDauHuongDan) {
        this.ngayBatDauHuongDan = ngayBatDauHuongDan;
    }

    public KhoaLuanTotNghiep getKhoaLuanId() {
        return khoaLuanId;
    }

    public void setKhoaLuanId(KhoaLuanTotNghiep khoaLuanId) {
        this.khoaLuanId = khoaLuanId;
    }

    public NguoiDung getNguoiDungId() {
        return nguoiDungId;
    }

    public void setNguoiDungId(NguoiDung nguoiDungId) {
        this.nguoiDungId = nguoiDungId;
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
        if (!(object instanceof GiangVienHuongDanKhoaLuan)) {
            return false;
        }
        GiangVienHuongDanKhoaLuan other = (GiangVienHuongDanKhoaLuan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thao.pojo.GiangVienHuongDanKhoaLuan[ id=" + id + " ]";
    }
    
}
