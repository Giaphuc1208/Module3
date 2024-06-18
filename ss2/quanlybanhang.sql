create database QuanLyBanHang ;
use QuanLyBanHang ;

create table Customer(
cID int not null primary key,
cName varchar(50) ,
cAge tinyint(20)
);

create table `Order`(
oID int not null primary key,
oDate datetime ,
oTotalPrice int ,
cID int not null,
foreign key (cID) references Customer(cID)
);

create table Product(
pID int not null primary key,
pName varchar(50) ,
pPrice int
);

create table OrderDetail(
odQTY int,
oID int,
pID int,
foreign key (oID) references `Order`(oID),
foreign key (pID) references Product(pID)
);