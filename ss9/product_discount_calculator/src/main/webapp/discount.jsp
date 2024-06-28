<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/27/2024
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/discount" method="post">
    <label>
        <input type="text" name="product_description" placeholder="Product Description">
    </label>
    <label>
        <input type="text" name="list_price" placeholder="List Price">
    </label>
    <label>
        <input type="text" name="discount_percent" placeholder="Discount Percent">
    </label>
    <input type="submit" id="submit" value="Calculate Discount">

</form>
</body>
</html>
