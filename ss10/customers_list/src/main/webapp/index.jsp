<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<style>
  table {
    border-collapse: collapse;
    border: 1px solid black;
    width: 100%;
  }
  td {
    text-align: center;
  }
  tr, td, th {
    border-collapse: collapse;
    border: 1px solid black;
  }
  img {
    width: 100px;
    height: auto;
  }
</style>
<table>
  <h1>Customers List</h1>

  <tr>
    <th>Name</th>
    <th>Date Of Birth</th>
    <th>Address</th>
    <th>Img</th>
  </tr>
  <c:forEach var="customersObj" items="${list}">
    <tr>
      <td>${customersObj.name}</td>
      <td>${customersObj.dateOfBirth}</td>
      <td>${customersObj.address}</td>
      <td><img src="/img/${customersObj.getImg()}" width="50px" ></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>