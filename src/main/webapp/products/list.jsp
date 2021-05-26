<%--
  Created by IntelliJ IDEA.
  User: Huy Hoang
  Date: 5/26/2021
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="/products/create.jsp">Tạo mới</a>
</div>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${dssp}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>
                <form action="/products" method="post">
                    <input type="text" name="id" value="${p.id}" hidden>
                    <input type="text" name="action" value="edit" hidden>

                    <button type="submit"><a href="/products?action=edit&id=${p.id}">Edit</a></button>
                </form>
            </td>

            <td>
                <form action="/products" method="post">
                    <input type="text" name="id" value="${p.id}" hidden>
                    <input type="text" name="action" value="delete" hidden>
                    <button type="submit"><a href="/products?action=delete&id=${p.id}">delete</a></button>
                </form>
            </td>


        </tr>
    </c:forEach>
</table>


</body>
</html>
