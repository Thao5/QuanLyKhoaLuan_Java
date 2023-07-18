/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.pojo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chung Vu
 */
@Entity
@Table(name = "tieu_chi_thuoc_khoa_luan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TieuChiThuocKhoaLuan.findAll", query = "SELECT t FROM TieuChiThuocKhoaLuan t"),
    @NamedQuery(name = "TieuChiThuocKhoaLuan.findById", query = "SELECT t FROM TieuChiThuocKhoaLuan t WHERE t.id = :id")})
public class TieuChiThuocKhoaLuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "khoa_luan_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private KhoaLuanTotNghiep khoaLuanId;
    @JoinColumn(name = "tieu_chi_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TieuChi tieuChiId;

    public TieuChiThuocKhoaLuan() {
    }

    public TieuChiThuocKhoaLuan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public KhoaLuanTotNghiep getKhoaLuanId() {
        return khoaLuanId;
    }

    public void setKhoaLuanId(KhoaLuanTotNghiep khoaLuanId) {
        this.khoaLuanId = khoaLuanId;
    }

    public TieuChi getTieuChiId() {
        return tieuChiId;
    }

    public void setTieuChiId(TieuChi tieuChiId) {
        this.tieuChiId = tieuChiId;
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
        if (!(object instanceof TieuChiThuocKhoaLuan)) {
            return false;
        }
        TieuChiThuocKhoaLuan other = (TieuChiThuocKhoaLuan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thao.pojo.TieuChiThuocKhoaLuan[ id=" + id + " ]";
    }
    
}
