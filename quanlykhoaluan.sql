use quanlykhoaluan;

create table nguoi_dung(
	id int not null auto_increment,
    ho nvarchar(50) not null,
    ten nvarchar(25) not null,
    tai_khoan nvarchar(50) not null,
    email nvarchar(50) not null,
    mat_khau nvarchar(18) not null,
    sdt nvarchar(10) not null,
    avatar nvarchar(200) not null,
    vai_tro nvarchar(10) not null,
    created_date datetime not null,
    khoa_luan_id int,
    primary key(id)
);

create table khoa_luan_tot_nghiep(
	id int not null auto_increment,
	ten_khoa_luan nvarchar(100) not null,
    ngay_ghi_nhan datetime not null,
    ngay_ket_thuc datetime,
    giao_vu_id int not null,
    hoi_dong_id int,
    primary key(id),
    foreign key(giao_vu_id) references nguoi_dung(id)
);

alter table nguoi_dung add foreign key (khoa_luan_id) references khoa_luan_tot_nghiep(id);

create table tieu_chi(
	id int not null auto_increment,
    noi_dung_tieu_chi nvarchar(255) not null,
    diem float not null,
    primary key(id)
);

create table hoi_dong_bao_ve_khoa_luan(
	id int not null auto_increment,
    ngay_thanh_lap datetime not null,
    ngay_khoa datetime not null,
    primary key(id)
);

alter table khoa_luan_tot_nghiep add foreign key (hoi_dong_id) references hoi_dong_bao_ve_khoa_luan(id);

create table giang_vien_huong_dan_khoa_luan(
	id int not null auto_increment,
    ngay_bat_dau_huong_dan datetime not null,
    nguoi_dung_id int not null,
    khoa_luan_id int not null,
    primary key(id),
    foreign key(nguoi_dung_id) references nguoi_dung(id),
    foreign key (khoa_luan_id) references khoa_luan_tot_nghiep(id)
);

create table tieu_chi_thuoc_khoa_luan(
	id int not null auto_increment,
    khoa_luan_id int not null,
    tieu_chi_id int not null,
    primary key(id),
    foreign key(tieu_chi_id) references tieu_chi(id),
    foreign key (khoa_luan_id) references khoa_luan_tot_nghiep(id)
);

create table giang_vien_thuoc_hoi_dong(
	id int not null auto_increment,
    vai_tro nvarchar(13) not null,
    ngay_vao_hoi_dong datetime not null,
    nguoi_dung_id int not null,
    hoi_dong_id int not null,
    primary key(id),
    foreign key(nguoi_dung_id) references nguoi_dung(id),
    foreign key (hoi_dong_id) references hoi_dong_bao_ve_khoa_luan(id)
);

create table giang_vien_cham_diem(
	id int not null auto_increment,
    diem float not null,
    ngay_cham datetime not null,
    giang_vien_thuoc_hoi_dong_id int not null,
    khoa_luan_id int not null,
    primary key(id),
    foreign key(giang_vien_thuoc_hoi_dong_id) references giang_vien_thuoc_hoi_dong(id),
    foreign key (khoa_luan_id) references khoa_luan_tot_nghiep(id)
);