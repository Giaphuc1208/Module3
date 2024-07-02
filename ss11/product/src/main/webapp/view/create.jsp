<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<h1>Create new Product</h1>
<p>
    <c:if test="${requestScope['message']!= null}">
        <span class="text-success">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post" action="products">
    <input type="hidden" name="action" value="create">
    <fieldset>
        <legend>Information Product</legend>
        <table>
            <tr>
                <td>Product Name:</td>
                <td><input class="text-bg-warning" type="text" name="productName" id="productName"></td>
            </tr>
            <tr>
                <td>Product Price:</td>
                <td><input type="text" name="productPrice" id="productPrice"></td>
            </tr>
            <tr>
                <td>Product Description:</td>
                <td><input type="text" name="productDescription" id="productDescription"></td>
            </tr>
            <tr>
                <td>Product Manufacture:</td>
                <td><input type="text" name="productManufacture" id="productManufacture"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create product"></td>
            </tr>
        </table>
    </fieldset>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>