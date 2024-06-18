create database chuyen_doi_csdl;
use chuyen_doi_csdl;


create table phieu_xuat(
soPX int not null PRIMARY KEY,
ngay_xuat date
);

create table phieu_nhap(
soPN int not null PRIMARY KEY,
ngay_nhap date
);

create table vat_tu(
ma_VTU int not null PRIMARY KEY,
ten_VTU varchar(50) not null
);
create table nha_cc(
ma_ncc int not null PRIMARY KEY,
ten_ncc varchar(45) not null,
dia_chi varchar(45) not null
);

create table SDT(
ma_ncc int not null primary key,
sdt varchar(10) not null,
foreign key(ma_ncc) references nha_cc(ma_ncc)
);

create table don_hang(
so_DH int not null PRIMARY KEY,
ngay_DH date,
ma_ncc int,
foreign key (ma_ncc) references nha_cc(ma_ncc)
);

create table chi_tiet_phieu_xuat(
so_PX int,
maVTU int,
dg_xuat varchar(45),
sl_xuat int,
primary key(so_PX, maVTU),
foreign key (so_PX) references phieu_xuat(soPX),
foreign key (maVTU) references vat_tu(ma_VTU)
);

create table chi_tiet_phieu_nhap(
so_PN int,
maVTU int,
dg_nhap varchar(45),
sl_nhap int,
primary key(so_PN, maVTU),
foreign key (so_PN) references phieu_nhap(soPN),
foreign key (maVTU) references vat_tu(ma_VTU)
);

create table chi_tiet_don_hang(
soDH int,
maVTU int,
primary key (soDH, maVTU),
foreign key (soDH) references don_hang(so_DH),
foreign key (maVTU) references vat_tu(ma_VTU)
);




