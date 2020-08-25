<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 13218
  Date: 2020/8/24
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Delete</td>
            <td>Edit</td>
        </tr>
        <c:forEach items="${cs}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="deleteCategory?id=${c.id}">delete</a></td>
                <td><a href="editCategory?id=${c.id}">edit</a></td>
            </tr>
        </c:forEach>
    </table>
    <table align="center">
        <tr>
            <td><a href="?start=0">首页</a></td>
            <td><a href="?start=${(page.start-page.count)<0?0:(page.start-page.count)}">上一页</a></td>
            <td><a href="?start=${(page.start+page.count)>page.last?(page.last):(page.start+page.count)}">下一页</a></td>
            <td><a href="?start=${page.last}">尾页</a></td>
        </tr>
    </table>
    <div align="center">
        <form action="addCategory" method="post">
            种类名称:<input type="text" name="name"><br>
            <input type="submit" value="submit">
        </form>
    </div>
</body>
</html>
