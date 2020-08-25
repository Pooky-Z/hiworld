<%--
  Created by IntelliJ IDEA.
  User: 13218
  Date: 2020/8/24
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="updateCategory">
        <input type="hidden" value="${c.id}" name="id">
        产品名称:<input type="text" value="${c.name}" name="name"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
