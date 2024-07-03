<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<form action="/users/update" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <input type="text" placeholder="Nhập tên" name="name" value="${user.name}">
    <input type="text" placeholder="Nhập email" name="email" value="${user.email}">
    <input type="text" placeholder="Nhập quê quán" name="country" value="${user.country}">
    <select name="idHobby" id="hobby">
        <c:forEach var="hobby" items="${hobbies}">
            <option value="${hobby.id}" ${hobby.id == user.hobbyId ? 'selected' : ''}>${hobby.name}</option>
        </c:forEach>
    </select>
    <button>Sửa</button>
    <a href="/users/list">Hủy</a>
</form>
</body>
</html>
