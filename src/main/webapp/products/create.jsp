<%--
  Created by IntelliJ IDEA.
  User: Huy Hoang
  Date: 5/26/2021
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tạo mới</h1>
<form method="post" action="/products">
    <input name="action" value="create" hidden>
    <input name="name" type="text" placeholder="Nhập Tên">
    <input name="price" type="number" placeholder="Nhập Giá">
    <input type="submit" value="Create">
</form>

</body>
</html>
