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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Chung Vu
 */
@Entity
@Table(name = "khoa_luan_tot_nghiep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhoaLuanTotNghiep.findAll", query = "SELECT k FROM KhoaLuanTotNghiep k"),
    @NamedQuery(name = "KhoaLuanTotNghiep.findById", query = "SELECT k FROM KhoaLuanTotNghiep k WHERE k.id = :id"),
    @NamedQuery(name = "KhoaLuanTotNghiep.findByTenKhoaLuan", query = "SELECT k FROM KhoaLuanTotNghiep k WHERE k.tenKhoaLuan = :tenKhoaLuan"),
    @NamedQuery(name = "KhoaLuanTotNghiep.findByNgayGhiNhan", query = "SELECT k FROM KhoaLuanTotNghiep k WHERE k.ngayGhiNhan = :ngayGhiNhan"),
    @NamedQuery(name = "KhoaLuanTotNghiep.findByNgayKetThuc", query = "SELECT k FROM KhoaLuanTotNghiep k WHERE k.ngayKetThuc = :ngayKetThuc")})
public class KhoaLuanTotNghiep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{khoaLuan.tenKhoaLuan.nullErr}")
    @Size(min = 1, max = 100, message = "{khoaLuan.tenKhoaLuan.lenErr}")
    @Column(name = "ten_khoa_luan")
    private String tenKhoaLuan;
    @Basic(optional = false)
    @NotNull(message = "{khoaLuan.ngayGhiNhan.nullErr}")
    @Column(name = "ngay_ghi_nhan")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date ngayGhiNhan;
    @Column(name = "ngay_ket_thuc")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date ngayKetThuc;
    @Basic(optional = false)
    @NotNull(message = "{khoaLuan.nganh.nullErr}")
    @Size(min = 1, max = 45)
    @Column(name = "nganh")
    private String nganh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoaLuanId", fetch=FetchType.LAZY)
    @JsonIgnore
    private Set<TieuChiThuocKhoaLuan> tieuChiThuocKhoaLuanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoaLuanId", fetch=FetchType.LAZY)
    @JsonIgnore
    private Set<GiangVienChamDiem> giangVienChamDiemSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoaLuanId", fetch=FetchType.LAZY)
    @JsonIgnore
    private Set<GiangVienHuongDanKhoaLuan> giangVienHuongDanKhoaLuanSet;
    @OneToMany(mappedBy = "khoaLuanId", fetch=FetchType.LAZY)
    @JsonIgnore
    private Set<NguoiDung> nguoiDungSet;
    @JoinColumn(name = "hoi_dong_id", referencedColumnName = "id")
    @ManyToOne
    private HoiDongBaoVeKhoaLuan hoiDongId;
    @JoinColumn(name = "giao_vu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NguoiDung giaoVuId;

    public KhoaLuanTotNghiep() {
    }

    public KhoaLuanTotNghiep(Integer id) {
        this.id = id;
    }

    public KhoaLuanTotNghiep(Integer id, String tenKhoaLuan, Date ngayGhiNhan) {
        this.id = id;
        this.tenKhoaLuan = tenKhoaLuan;
        this.ngayGhiNhan = ngayGhiNhan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenKhoaLuan() {
        return tenKhoaLuan;
    }

    public void setTenKhoaLuan(String tenKhoaLuan) {
        this.tenKhoaLuan = tenKhoaLuan;
    }

    public Date getNgayGhiNhan() {
        return ngayGhiNhan;
    }

    public void setNgayGhiNhan(Date ngayGhiNhan) {
        this.ngayGhiNhan = ngayGhiNhan;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @XmlTransient
    public Set<TieuChiThuocKhoaLuan> getTieuChiThuocKhoaLuanSet() {
        return tieuChiThuocKhoaLuanSet;
    }

    public void setTieuChiThuocKhoaLuanSet(Set<TieuChiThuocKhoaLuan> tieuChiThuocKhoaLuanSet) {
        this.tieuChiThuocKhoaLuanSet = tieuChiThuocKhoaLuanSet;
    }

    @XmlTransient
    public Set<GiangVienChamDiem> getGiangVienChamDiemSet() {
        return giangVienChamDiemSet;
    }

    public void setGiangVienChamDiemSet(Set<GiangVienChamDiem> giangVienChamDiemSet) {
        this.giangVienChamDiemSet = giangVienChamDiemSet;
    }

    @XmlTransient
    public Set<GiangVienHuongDanKhoaLuan> getGiangVienHuongDanKhoaLuanSet() {
        return giangVienHuongDanKhoaLuanSet;
    }

    public void setGiangVienHuongDanKhoaLuanSet(Set<GiangVienHuongDanKhoaLuan> giangVienHuongDanKhoaLuanSet) {
        this.giangVienHuongDanKhoaLuanSet = giangVienHuongDanKhoaLuanSet;
    }

    @XmlTransient
    public Set<NguoiDung> getNguoiDungSet() {
        return nguoiDungSet;
    }

    public void setNguoiDungSet(Set<NguoiDung> nguoiDungSet) {
        this.nguoiDungSet = nguoiDungSet;
    }

    public HoiDongBaoVeKhoaLuan getHoiDongId() {
        return hoiDongId;
    }

    public void setHoiDongId(HoiDongBaoVeKhoaLuan hoiDongId) {
        this.hoiDongId = hoiDongId;
    }

    public NguoiDung getGiaoVuId() {
        return giaoVuId;
    }

    public void setGiaoVuId(NguoiDung giaoVuId) {
        this.giaoVuId = giaoVuId;
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
        if (!(object instanceof KhoaLuanTotNghiep)) {
            return false;
        }
        KhoaLuanTotNghiep other = (KhoaLuanTotNghiep) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thao.pojo.KhoaLuanTotNghiep[ id=" + id + " ]";
    }

    /**
     * @return the nganh
     */
    public String getNganh() {
        return nganh;
    }

    /**
     * @param nganh the nganh to set
     */
    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
    
}
