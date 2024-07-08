create Database abc_company;
use abc_company;


create table categories (
id int primary key auto_increment,
name varchar(255)
);

create table products (
id int primary key auto_increment,
sku varchar(255),
name varchar(255),
unit varchar (20),
price double,
grown date,
id_cate int,
foreign key (id_cate) references categories (id)
);
select p.id,p.sku,p.name,p.unit,p.price,c.name as categorie_name,p.grown from products p join categories c on c.id = p.id_cate;
