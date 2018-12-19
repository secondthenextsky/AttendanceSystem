<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js"></script>
<title>教师登录</title>
</head>
<body>
<h1>考勤管理系统-教师端登录</h1>
<form action="${pageContext.request.contextPath }/TeacherServlet?method=login" method="post">
 工号：<input type="text" name="number"><br/>
密码：<input type="password" name="password"><br/>
<input type="submit">
</form>
</body>
</html>