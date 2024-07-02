
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<h1>
    Update Product
</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post" action="/products">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${product.getId()}">
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Product Name:</td>
                <td>
                    <input type="text" name="productsName" id="productsName" value="${requestScope["product"].getProductName()}">
                </td>
            </tr>
            <td>Product Price:</td>
            <td><input type="text" name="productPrice" id="productPrice" value="${requestScope["product"].getProductPrice()}"></td>
            </tr>
            <tr>
                <td>Product Description:</td>
                <td><input type="text" name="productDescription" id="productDescription" value="${requestScope["product"].getProductDescription()}">
                </td>
            </tr>
            <tr>
                <td>Product Manufacture:</td>
                <td><input type="text" name="productManufacture" id="productManufacture" value="${requestScope["product"].getProductManufacture()}">
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
