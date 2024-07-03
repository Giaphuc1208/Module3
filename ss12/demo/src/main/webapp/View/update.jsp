<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/2/2024
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users/update" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <input type="text" placeholder="Nhập tên" name="name" value="${user.name}">
    <input type="text" placeholder="Nhập email" name="email" value="${user.email}">
    <input type="text" placeholder="Nhập quê quán" name="country" value="${user.country}">
    <button>Sửa</button>
    <a href="/users/list" >Hủy</a>
</form>
</body>
</html>
