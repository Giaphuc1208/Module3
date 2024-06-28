<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/28/2024
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
    <%!
        Map<String, String> dic = new HashMap<>();
    %>
    <%
        dic.put("hello", "xin chào");
        dic.put("stupid", "ngu");
        dic.put("cook", "cút");
        dic.put("porn", "è");
        String search = request.getParameter("search");
        String result = dic.get(search);
        if (result != null) {
            System.out.println("word: " + search);
            System.out.println("result: " + result);
        } else {
            System.out.println("NOT FOUND");
        }
    %>
</body>
</html>
