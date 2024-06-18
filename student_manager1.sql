create database student_manager;
use student_manager;


create table student( 
id int primary key auto_increment,
name varchar(200),
age int,
country varchar(100)
);

create table class(
id int primary key auto_increment,
name varchar(100),
student_id int,
foreign key (student_id) references student (id)
);

create table teacher(
id int primary key auto_increment,
name varchar(200),
age int,
country varchar(100)
);