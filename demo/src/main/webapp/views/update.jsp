<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/8/2024
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product/update" method="post">
    <input type="hidden" name="id" value="${product.id}" id="id">
    <input type="text" placeholder="Nhập sku " name="sku" value="${product.sku}">
    <input type="text" placeholder="Nhập tên sản phẩm" name="name" value="${product.name}">
    <select name="unit" id="unit" class="form-select">
        <option>Kg</option>
        <option>Bó</option>
        <option>Túi</option>
    </select>
    <input type="text" placeholder="Nhập giá sản phẩm" name="price" value="${product.price}">
    <select name="id_Category" id="id_Category">
        <c:forEach var = "category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <input type="date" class="form-control" name="dateReceive" value="${product.dateReceive}" required>
    <button type="submit">Sửa</button>
    <a href="/product/list">Hủy</a>
</form>
</body>
</html>
