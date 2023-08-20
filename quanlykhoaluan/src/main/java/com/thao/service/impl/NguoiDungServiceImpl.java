/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.service.impl;

import com.thao.pojo.NguoiDung;
import com.thao.repository.NguoiDungRepository;
import com.thao.service.NguoiDungService;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Chung Vu
 */
@Service("userDetailsService")
public class NguoiDungServiceImpl implements NguoiDungService {

    @Autowired
    private NguoiDungRepository nguoiDungRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<NguoiDung> getNguoiDungs(Map<String, String> params) {
        return this.nguoiDungRepo.getNguoiDungs(params);
    }

    @Override
    public Boolean addNguoiDung(NguoiDung user) {
        user.setMatKhau(this.passwordEncoder.encode(user.getMatKhau()));
        if (!user.getImg().isEmpty()) {
                Map res;
            try {
                res = this.cloudinary.uploader().upload(user.getImg().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                user.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NguoiDungServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
        }
        return this.nguoiDungRepo.addNguoiDung(user);
    }

    @Override
    public Boolean ganKhoaLuanChoSinhVien(int userId, int khoaLuanId) {
        return this.nguoiDungRepo.ganKhoaLuanChoSinhVien(userId, khoaLuanId);
    }

    @Override
    public NguoiDung updateNguoiDung(int id, Map<String, String> params, MultipartFile avatar) {
        NguoiDung nd = this.nguoiDungRepo.getNguoiDungById(id);
        nd.setMatKhau(this.passwordEncoder.encode(params.get("matKhau")));
        if (!avatar.isEmpty()) {
           
            try { 
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                nd.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NguoiDungServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        this.nguoiDungRepo.updateNguoiDung(nd);
        return nd;
    }

    @Override
    public NguoiDung getNguoiDungById(int id) {
        return this.nguoiDungRepo.getNguoiDungById(id);
    }

    @Override
    public boolean updateNguoiDung(NguoiDung nd) {
        if(!nd.getMatKhau().equals(this.getNguoiDungById(nd.getId()).getMatKhau())){
            nd.setMatKhau(this.passwordEncoder.encode(nd.getMatKhau()));
        }
        
        if (!nd.getImg().isEmpty()) {
                Map res;
            try {
                res = this.cloudinary.uploader().upload(nd.getImg().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                nd.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NguoiDungServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
        }
        return this.nguoiDungRepo.updateNguoiDung(nd);
    }

    @Override
    public boolean deleteNguoiDung(int id) {
        return this.nguoiDungRepo.deleteNguoiDung(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NguoiDung nd = this.nguoiDungRepo.getNguoiDungByUsername(username);
        if (nd == null) {
            throw new UsernameNotFoundException("Invalid");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(nd.getVaiTro()));
        return new org.springframework.security.core.userdetails.User(
                nd.getTaiKhoan(), nd.getMatKhau(), authorities);

    }

    @Override
    public NguoiDung getNguoiDungByUsername(String username) {
        return this.nguoiDungRepo.getNguoiDungByUsername(username);
    }

    @Override
    public boolean authNguoiDung(String taiKhoan, String matKhau) {
        return this.nguoiDungRepo.authNguoiDung(taiKhoan, matKhau);
    }
    
    
}
