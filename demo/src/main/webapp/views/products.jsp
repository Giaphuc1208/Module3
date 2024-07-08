<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/8/2024
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container" >
    <a href="/product/create" class="btn btn-sm btn-outline-warning">Thêm mới</a>
    <form action="/product/search">
        <input type="search" name="keyword" value="${keyword}">
        <button type="submit">search</button>
    </form>
    <table class="table table-hover mt-5">
        <tr>
            <td>#</td>
            <td>Mã Hàng Hóa</td>
            <td>Tên Hàng Hóa</td>
            <td>Đơn vị tính</td>
            <td>Giá</td>
            <td>Loại hàng hóa</td>
            <td>Ngày thu hoạch</td>
            <td>Chỉnh sửa</td>
            <td>Xóa</td>
        </tr>
        <c:forEach  var="product" items="${products}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${product.sku}</td>
                <td>${product.name}</td>
                <td>${product.unit}</td>
                <td>${product.price}</td>
                <td>${product.nameCategory}</td>
                <td>${product.dateReceive}</td>
                <td>
                    <a href="/product/update?id=${product.id}" class="btn btn-sm btn-outline-primary">Sửa</a>
                </td>
                <td>
                    <a class="btn btn-danger" href="/product/delete?id=${product.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
