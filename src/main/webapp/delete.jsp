<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/02/2024
  Time: 1:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1>Delete Customer</h1>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<form method="post">
    <h2>Do you want to delete</h2>
    <fieldset>
        <legend>Information Customer</legend>
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
                <td><input type="submit" value="Delete"></td>
                <td><a href="/customer">Back to customer list</a></td>
            </tr>

        </table>
    </fieldset>
</form>
</body>
</html>
