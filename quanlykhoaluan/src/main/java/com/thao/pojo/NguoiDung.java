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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Chung Vu
 */
@Entity
@Table(name = "nguoi_dung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NguoiDung.findAll", query = "SELECT n FROM NguoiDung n"),
    @NamedQuery(name = "NguoiDung.findById", query = "SELECT n FROM NguoiDung n WHERE n.id = :id"),
    @NamedQuery(name = "NguoiDung.findByHo", query = "SELECT n FROM NguoiDung n WHERE n.ho = :ho"),
    @NamedQuery(name = "NguoiDung.findByTen", query = "SELECT n FROM NguoiDung n WHERE n.ten = :ten"),
    @NamedQuery(name = "NguoiDung.findByTaiKhoan", query = "SELECT n FROM NguoiDung n WHERE n.taiKhoan = :taiKhoan"),
    @NamedQuery(name = "NguoiDung.findByEmail", query = "SELECT n FROM NguoiDung n WHERE n.email = :email"),
    @NamedQuery(name = "NguoiDung.findByMatKhau", query = "SELECT n FROM NguoiDung n WHERE n.matKhau = :matKhau"),
    @NamedQuery(name = "NguoiDung.findBySdt", query = "SELECT n FROM NguoiDung n WHERE n.sdt = :sdt"),
    @NamedQuery(name = "NguoiDung.findByAvatar", query = "SELECT n FROM NguoiDung n WHERE n.avatar = :avatar"),
    @NamedQuery(name = "NguoiDung.findByVaiTro", query = "SELECT n FROM NguoiDung n WHERE n.vaiTro = :vaiTro"),
    @NamedQuery(name = "NguoiDung.findByCreatedDate", query = "SELECT n FROM NguoiDung n WHERE n.createdDate = :createdDate")})
public class NguoiDung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{nguoiDung.ho.nullErr}")
    @Size(min = 1, max = 50, message = "{nguoiDung.ho.lenErr}")
    @Column(name = "ho")
    private String ho;
    @Basic(optional = false)
    @NotNull(message = "{nguoiDung.ten.nullErr}")
    @Size(min = 1, max = 25, message = "{nguoiDung.ten.lenErr}")
    @Column(name = "ten")
    private String ten;
    @Basic(optional = false)
    @NotNull(message = "{nguoiDung.taiKhoan.nullErr}")
    @Size(min = 3, max = 50, message = "{nguoiDung.taiKhoan.lenErr}")
    @Column(name = "tai_khoan")
    private String taiKhoan;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull(message = "{nguoiDung.email.nullErr}")
    @Size(min = 7, max = 50, message = "{nguoiDung.email.lenErr}")
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull(message = "{nguoiDung.matKhau.nullErr}")
    @Size(min = 6, max = 18, message = "{nguoiDung.matKhau.lenErr}")
    @Column(name = "mat_khau")
    private String matKhau;
    @Basic(optional = false)
    @NotNull(message = "{nguoiDung.sdt.nullErr}")
    @Size(min = 10, max = 10, message = "{nguoiDung.sdt.lenErr}")
    @Column(name = "sdt")
    private String sdt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "avatar")
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "vai_tro")
    private String vaiTro;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Transient
    private MultipartFile img;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDungId", fetch=FetchType.LAZY)
    private Set<GiangVienHuongDanKhoaLuan> giangVienHuongDanKhoaLuanSet;
    @JoinColumn(name = "khoa_luan_id", referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.LAZY)
    private KhoaLuanTotNghiep khoaLuanId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDungId", fetch=FetchType.LAZY)
    private Set<GiangVienThuocHoiDong> giangVienThuocHoiDongSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giaoVuId", fetch=FetchType.LAZY)
    private Set<KhoaLuanTotNghiep> khoaLuanTotNghiepSet;

    public NguoiDung() {
    }

    public NguoiDung(Integer id) {
        this.id = id;
    }

    public NguoiDung(Integer id, String ho, String ten, String taiKhoan, String email, String matKhau, String sdt, String avatar, String vaiTro, Date createdDate, boolean isActive) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.taiKhoan = taiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.sdt = sdt;
        this.avatar = avatar;
        this.vaiTro = vaiTro;
        this.createdDate = createdDate;
        this.isActive = isActive;
    }
    
    public NguoiDung(String ho, String ten, String taiKhoan, String email, String matKhau, String sdt, String avatar, String vaiTro, Date createdDate, boolean isActive) {
        this.ho = ho;
        this.ten = ten;
        this.taiKhoan = taiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.sdt = sdt;
        this.avatar = avatar;
        this.vaiTro = vaiTro;
        this.createdDate = createdDate;
        this.isActive = isActive;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Set<GiangVienHuongDanKhoaLuan> getGiangVienHuongDanKhoaLuanSet() {
        return giangVienHuongDanKhoaLuanSet;
    }

    public void setGiangVienHuongDanKhoaLuanSet(Set<GiangVienHuongDanKhoaLuan> giangVienHuongDanKhoaLuanSet) {
        this.giangVienHuongDanKhoaLuanSet = giangVienHuongDanKhoaLuanSet;
    }

    public KhoaLuanTotNghiep getKhoaLuanId() {
        return khoaLuanId;
    }

    public void setKhoaLuanId(KhoaLuanTotNghiep khoaLuanId) {
        this.khoaLuanId = khoaLuanId;
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
        if (!(object instanceof NguoiDung)) {
            return false;
        }
        NguoiDung other = (NguoiDung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thao.pojo.NguoiDung[ id=" + id + " ]";
    }

    /**
     * @return the img
     */
    public MultipartFile getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(MultipartFile img) {
        this.img = img;
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
