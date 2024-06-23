delimiter //
create procedure findAllCustomers()
begin
select * from customers;
end;
	// delimiter ;
call findAllCustomers();

delimiter //
drop procedure if exists findAllCustomers//
CREATE PROCEDURE findAllCustomers()
BEGIN

SELECT * FROM customers where customerNumber = 175;

END //
DELIMITER ;

call findAllCustomers();