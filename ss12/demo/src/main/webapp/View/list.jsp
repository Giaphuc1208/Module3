<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/2/2024
  Time: 2:35 PM
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
<div class="container">
    <div class="d-flex justify-content-between">
        <h1>Danh sách người dùng</h1>
        <form action="/users/search">
            <input type="search" placeholder="Nhập tên để tìm" value="${keyword}" name="keyword">
            <button>Tìm</button>
        </form>
        <a href="/users/create" class="btn btn-sm btn-outline-warning">Thêm mới</a>

    </div>
    <table class="table table-hover">
        <tr>
            <td>STT</td>
            <td>Tên</td>
            <td>Email</td>
            <td>Quê quán</td>
            <td></td>
        </tr>
      <c:forEach var="user" items="${users}" varStatus="status" >
        <tr>
            <td>${status.count}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td>
                <a href="/users/update?id=${user.id}" class="btn btn-sm btn-outline-primary">Sửa</a>
                <a href="/users/delete?id=${user.id}" class="btn btn-sm btn-outline-danger">Xóa</a>
            </td>
        </tr>
      </c:forEach>
    </table>
</div>
</body>
</html>
