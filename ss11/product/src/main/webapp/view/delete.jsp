<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>
    Delete Product
</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post" action="/products">
    <input type="hidden" name="action" value="delete">
    <%--gửi đến thanh post--%>
    <input type="hidden" name="id" value="${product.getId()}">
    <%--    để xoá id mà mình chọn--%>
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Product Name:</td>
                <td>
                    ${product.productName}
                </td>
            </tr>
            <td>Product Price:</td>
            <td> ${product.productPrice}</td>
            </tr>
            <tr>
                <td>Product Description:</td>
                <td> ${product.productDescription}</td>
                </td>
            </tr>
            <tr>
                <td>Product Manufacture:</td>
                <td> ${product.productManufacture}</td>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="/products">Cancel</a>
                </td>
                <td><input type="submit" value="Delete product"></td>

            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>