/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chung Vu
 */
@Entity
@Table(name = "tieu_chi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TieuChi.findAll", query = "SELECT t FROM TieuChi t"),
    @NamedQuery(name = "TieuChi.findById", query = "SELECT t FROM TieuChi t WHERE t.id = :id"),
    @NamedQuery(name = "TieuChi.findByNoiDungTieuChi", query = "SELECT t FROM TieuChi t WHERE t.noiDungTieuChi = :noiDungTieuChi"),
    @NamedQuery(name = "TieuChi.findByDiem", query = "SELECT t FROM TieuChi t WHERE t.diem = :diem")})
public class TieuChi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "noi_dung_tieu_chi")
    private String noiDungTieuChi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diem")
    private float diem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tieuChiId")
    private Set<TieuChiThuocKhoaLuan> tieuChiThuocKhoaLuanSet;

    public TieuChi() {
    }

    public TieuChi(Integer id) {
        this.id = id;
    }

    public TieuChi(Integer id, String noiDungTieuChi, float diem) {
        this.id = id;
        this.noiDungTieuChi = noiDungTieuChi;
        this.diem = diem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoiDungTieuChi() {
        return noiDungTieuChi;
    }

    public void setNoiDungTieuChi(String noiDungTieuChi) {
        this.noiDungTieuChi = noiDungTieuChi;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    @XmlTransient
    public Set<TieuChiThuocKhoaLuan> getTieuChiThuocKhoaLuanSet() {
        return tieuChiThuocKhoaLuanSet;
    }

    public void setTieuChiThuocKhoaLuanSet(Set<TieuChiThuocKhoaLuan> tieuChiThuocKhoaLuanSet) {
        this.tieuChiThuocKhoaLuanSet = tieuChiThuocKhoaLuanSet;
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
        if (!(object instanceof TieuChi)) {
            return false;
        }
        TieuChi other = (TieuChi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thao.pojo.TieuChi[ id=" + id + " ]";
    }
    
}
