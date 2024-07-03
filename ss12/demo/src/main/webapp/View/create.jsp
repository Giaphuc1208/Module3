<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/2/2024
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-5">
    <form class="m-auto" action="/users/create" method="post">

        <div class="input-group input-group-sm mb-3 w-25">
            <input type="text" class="form-control" placeholder="nhập tên" name="name">
        </div>
        <div class="input-group input-group-sm mb-3 w-25">
            <input type="text" class="form-control" placeholder="nhập email" name="email">
        </div>
        <div class="input-group input-group-sm mb-3 w-25">
            <input type="text" class="form-control" placeholder="nhập quê quán" name="country">
        </div>
        <button class="btn btn-success">Thêm</button>

        <a href="/users/list" class="btn btn-outline-danger">Hủy</a>
    </form>
</div>
</body>
</html>
