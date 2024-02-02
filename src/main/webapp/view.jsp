<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/02/2024
  Time: 2:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<h1>Details Customer</h1>
<p>
    <a href="/customer">Back to list customer</a>
</p>
<table>
    <tr>
        <td>ID</td>
        <td>${requestScope["customer"].getId()}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${requestScope["customer"].getName()}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${requestScope["customer"].getEmail()}</td>
    </tr>
    <tr>
        <td>Address</td>
        <td>${requestScope["customer"].getAddress()}</td>
    </tr>
</table>
</body>
</html>
