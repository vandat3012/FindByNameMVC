<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 31/01/2024
  Time: 2:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>List Customer</title>
</head>
<body>
<p>
  <a href="/customer?action=create">Create</a>
</p>
<form action="/customer">
  <input type="hidden" name="action" value="find">
  <input type="text" name="searchName">
  <button type="submit">Search</button>
</form>
<h1>List Customers</h1>
<table border="1px">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
    <th>Edit</th>
    <th>Delete</th>
    <th>View</th>
  </tr>
  <c:forEach items="${customer}" var="customer">
    <tr>
      <td>${customer.id}</td>
      <td>${customer.name}</td>
      <td>${customer.email}</td>
      <td>${customer.address}</td>
      <td><a href="/customer?action=edit&id=${customer.getId()}">Edit</a> </td>
      <td><a href="/customer?action=delete&id=${customer.getId()}">Delete</a> </td>
      <td><a href="/customer?action=view&id=${customer.getId()}">View</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
