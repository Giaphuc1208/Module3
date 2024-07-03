create database demo;
use demo;
-- drop database demo;
create table hobbies(
id int primary key auto_increment,
name varchar(255)); 

create table users(
id int primary key auto_increment,
name varchar(255),
email varchar(255),
country varchar(255),
id_hb int,
foreign key (id_hb) references hobbies(id));



select users.id,users.name,users.email,users.country,hobbies.name as hobby
from users 
join hobbies
 on hobbies.id = users.id_hb;