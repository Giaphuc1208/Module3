<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/1/2024
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
    <style>
        .button-like-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #ffffff;
            text-align: center;
            text-decoration: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .button-like-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>Edit Student</h1>
<p>
    <a href="student" class="button-like-link">Back to Student list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><label for="name"></label><input type="text" name="name" id="name" value="${requestScope["students"].getName()}"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><label for="address"></label><input type="text" name="address" id="address" value="${requestScope["students"].getAddress()}"></td>
            </tr>
            <tr>
                <td>Point: </td>
                <td><label for="point"></label><input type="text" name="point" id="point" value="${requestScope["students"].getPoint()}"></td>
            </tr>

            <tr>
                <td></td>
                <td><button type="submit">Update Student</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
