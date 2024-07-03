create database demo;
use demo;

create table users(
id int primary key auto_increment,
name varchar(50),
email varchar(20),
country varchar(20));

insert into users(name, email, country) values
("Ronaldo","ronaldo@codegym.com","poturgal"),
("Messi","messi@codegym.com","argentina");