use quan_ly_ban_hang ;
INSERT INTO customer (c_id,c_name,c_age)
 VALUES (1, 'Minh Quan', 10),
      (2, 'Ngoc Oanh', 20),
      (3, 'Hong Ha', 10);

INSERT INTO `order` (o_id ,o_date,o_total_price ,c_id )
VALUES		(1, '2006-03-21',null,1),
			(2, '2006-03-23',null,2),
			(3, '2006-03-16',null,1);
  
INSERT INTO product (p_id ,p_name,p_price )
VALUES		(1, 'May Giat',3),
			(2, 'Tu Lanh',5),
			(3, 'Dieu Hoa',7),
			(4, 'Quat',1),
			(5, 'Bep Dien',2);
            
INSERT INTO order_detail (o_id,p_id,od_qty )
VALUES		(1,1 ,3),
			(1,3 ,7),
			(1, 4,2),
			(2,1 ,1),
			(3,1 ,8),
			(2,5 ,4),
			(2,3 ,3);
            
	-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
  select o_id ,o_date,o_total_price
  from `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select distinct c_name,p_name
from customer
join `order` 
	using(c_id)
join order_detail
	using(o_id)
join product
	using(p_id);

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select *
from `order` right join `customer`
using(c_id)
where o_id is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT o.o_id, o.o_date, SUM(od.od_qty * p.p_price) AS total_price
FROM `order` o
JOIN order_detail od ON o.o_id = od.o_id
JOIN product p ON od.p_id = p.p_id
GROUP BY o.o_id;