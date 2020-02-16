<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20.2.9
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<html>
<head>
	<title>首页</title>
</head>
<body>
<h1>用户管理系统</h1>
<table>
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>得分</th>
	</tr>
	<c:forEach  items="${list}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.score}</td>
		</tr>

	</c:forEach>
</table>

</body>
</html>
