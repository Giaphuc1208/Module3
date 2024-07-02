<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Name Product </title>
</head>
<body>
<h1>Search product by name</h1>
<p>
    <c:if test="${requestScope['message'] != null}">
        <span>${requestScope['message']}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post" action="/products">
    <input type="hidden" name="action" value="search">
    <fieldset>
        <legend>Search box</legend>
        <table>
            <tr>
                <td>Product name: </td>
                <td><input type="text" name="nameProduct" id="nameProduct"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Search"></td>
            </tr>
        </table>
    </fieldset>
</form>

<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Manufacture</td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.productName}</td>
            <td>${product.productPrice}</td>
            <td>${product.productDescription}</td>
            <td>${product.productManufacture}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>