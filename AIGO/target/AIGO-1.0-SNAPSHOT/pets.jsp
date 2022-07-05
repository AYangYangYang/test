<%--
  Created by IntelliJ IDEA.
  User: 毛兴涛
  Date: 2021/7/27
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table BORDER="1PX" width="500PX">
    <tr>

        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>类型</th>



    </tr>
    <c:forEach items="${users}" var="pp">
        <tr>
            <td>${pp.id}</td>
            <td>${pp.username}</td>
            <td>${pp.password}</td>
            <td>${pp.type}</td>


        </tr>
    </c:forEach>

</table>
</body>
</html>
