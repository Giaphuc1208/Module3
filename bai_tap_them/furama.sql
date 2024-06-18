CREATE DATABASE Furama_Resort;
 use Furama_Resort;
 
 create table guest_types(
 id int primary key auto_increment,
 name varchar(45)
);

create table guests(
id_guests int primary key auto_increment,
id_guests_type int ,
name varchar(45),
dob date,
code varchar(45),
phone varchar(45),
email varchar(45),
address varchar(45),
foreign key (id_guests_type) references guest_types(id)
);

create table rental_types(
id_rental_types int primary key auto_increment,
name_of_rental varchar(45),
price int
);

create table service_types(
id int primary key auto_increment,
name_service varchar(45)
);

create table service(
id_service int primary key auto_increment,
name_service varchar(45),
area int,
floors int,
max_capacity int,
rental_cost double,
id_rental int,
id_type int,
status varchar(45),
foreign key (id_rental) references rental_types(id_rental_types),
foreign key (id_type) references service_types(id)
);

create table location(
id int primary key auto_increment,
name varchar(45)
);

create table levels(
id int primary key auto_increment,
name varchar(45)
);

create table parts(
id int primary key auto_increment,
name varchar(45)
);

create table employees(
id int primary key auto_increment,
name varchar(45),
id_location int,
id_level int,
id_part int,
dob date,
indifition varchar(45),
salary double,
phone varchar(10),
email varchar(60),
address varchar(45),
foreign key (id_location) references location(id),
foreign key (id_level) references levels(id),
foreign key (id_part) references parts(id)
);

create table contact(
id int primary key auto_increment,
id_employee int,
id_customer int,
id_services int,
date_create date,
date_end date,
cost double,
total double,
foreign key (id_employee) references employees(id),
foreign key (id_customer) references guests(id_guests),
foreign key (id_services) references service(id_service)
);

create table sub_service(
id int primary key auto_increment,
name varchar(45),
price double,
quantity int,
status varchar(45)
);

create table detailed_contract(
id int primary key auto_increment,
id_contact int,
id_sub int,
quantity int,
foreign key (id_contact) references contact(id),
foreign key (id_sub) references sub_service(id)
);



 