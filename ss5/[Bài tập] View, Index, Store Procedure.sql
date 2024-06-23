create database Product;
use Product;

create table Products(
Id int not null auto_increment	primary key,
productCode int,
productName varchar(50),
productPrice varchar(50),
productAmount varchar(50),
productDescription varchar(50),
productStatus varchar(50)
);

insert into Products(Id,productCode,productName,productPrice,productAmount,productDescription,productStatus)
values (001,'115','clear','15$','10','dau goi','ton hang'),
		(002,'232','snow','17$','10','dau goi','ton hang'),
		(003,'245','panasonic','155$','10','tulanh','ton hang'),
		(004,'248','panasonic','155$','12','dieuhoa','ton hang');
        
explain select * 
from products
where productCode = '232';

create index ten_index on products(productCode);

create index halo_index on products(productName,productPrice);

create view information as
select  productCode, productName, productPrice, productStatus from products;

update information
set productCode = '1515'
where productName = 'snow';

drop view information;

DELIMITER //
create procedure store()
begin 
	select *
    from products;
    end;
// DELIMITER ;
call store();


 DELIMITER //
create procedure addProduct(in Id int,
in productCode int,
   in productName varchar(50),
	in productPrice varchar(50),
   in productAmount varchar(50),
    in productDescription varchar(50),
    in productStatus varchar(50))
begin 
	insert into products (Id ,productCode, productName, productPrice, productAmount, productDescription,productStatus) 
    values(Id ,productCode, productName, productPrice, productAmount, productDescription,productStatus);
    end
// DELIMITER ;
call addProduct(5,363, 'sony', '200$', '15', 'nuocnong','còn hàng');
drop procedure if exists addProduct;

DELIMITER //
create procedure updateProduct(in IdProduct int,
in productCode int,
   in productName varchar(50),
	in productPrice varchar(50),
   in productAmount varchar(50),
    in productDescription varchar(50),
    in productStatus varchar(50))
begin 
update products
set  productCode = productCode,
 productName = productName,
 productPrice = productPrice,
 productAmount = productAmount,
 productDescription = productDescription,
 productStatus = productStatus
 where Id = IdProduct;
 end;
 // DELIMITER ;

drop procedure if exists updateProduct;
call updateProduct(2,365, 'sámung', '300$', '15', 'điện thoại','còn hàng')


DELIMITER //
create procedure deleteProduct(in IdProduct int)
begin 
delete from products
 where Id = IdProduct;
 end;
 // DELIMITER ;
 
 call deleteProduct(5)