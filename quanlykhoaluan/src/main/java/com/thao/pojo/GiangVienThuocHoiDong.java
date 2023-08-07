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

/**
 *
 * @author Chung Vu
 */
@Entity
@Table(name = "giang_vien_thuoc_hoi_dong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiangVienThuocHoiDong.findAll", query = "SELECT g FROM GiangVienThuocHoiDong g"),
    @NamedQuery(name = "GiangVienThuocHoiDong.findById", query = "SELECT g FROM GiangVienThuocHoiDong g WHERE g.id = :id"),
    @NamedQuery(name = "GiangVienThuocHoiDong.findByVaiTro", query = "SELECT g FROM GiangVienThuocHoiDong g WHERE g.vaiTro = :vaiTro"),
    @NamedQuery(name = "GiangVienThuocHoiDong.findByNgayVaoHoiDong", query = "SELECT g FROM GiangVienThuocHoiDong g WHERE g.ngayVaoHoiDong = :ngayVaoHoiDong")})
public class GiangVienThuocHoiDong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{giangVienThuocHoiDong.vaiTro.nullErr}")
    @Size(min = 1, max = 13)
    @Column(name = "vai_tro")
    private String vaiTro;
    @Basic(optional = false)
    @NotNull(message = "{giangVienThuocHoiDong.ngayVaoHoiDong.nullErr}")
    @Column(name = "ngay_vao_hoi_dong")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayVaoHoiDong;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giangVienThuocHoiDongId")
    @JsonIgnore
    private Set<GiangVienChamDiem> giangVienChamDiemSet;
    @JoinColumn(name = "hoi_dong_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private HoiDongBaoVeKhoaLuan hoiDongId;
    @JoinColumn(name = "nguoi_dung_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NguoiDung nguoiDungId;

    public GiangVienThuocHoiDong() {
    }

    public GiangVienThuocHoiDong(Integer id) {
        this.id = id;
    }

    public GiangVienThuocHoiDong(Integer id, String vaiTro, Date ngayVaoHoiDong) {
        this.id = id;
        this.vaiTro = vaiTro;
        this.ngayVaoHoiDong = ngayVaoHoiDong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Date getNgayVaoHoiDong() {
        return ngayVaoHoiDong;
    }

    public void setNgayVaoHoiDong(Date ngayVaoHoiDong) {
        this.ngayVaoHoiDong = ngayVaoHoiDong;
    }

    @XmlTransient
    public Set<GiangVienChamDiem> getGiangVienChamDiemSet() {
        return giangVienChamDiemSet;
    }

    public void setGiangVienChamDiemSet(Set<GiangVienChamDiem> giangVienChamDiemSet) {
        this.giangVienChamDiemSet = giangVienChamDiemSet;
    }

    public HoiDongBaoVeKhoaLuan getHoiDongId() {
        return hoiDongId;
    }

    public void setHoiDongId(HoiDongBaoVeKhoaLuan hoiDongId) {
        this.hoiDongId = hoiDongId;
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
        if (!(object instanceof GiangVienThuocHoiDong)) {
            return false;
        }
        GiangVienThuocHoiDong other = (GiangVienThuocHoiDong) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thao.pojo.GiangVienThuocHoiDong[ id=" + id + " ]";
    }
    
}
