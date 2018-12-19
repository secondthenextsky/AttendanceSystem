<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js"></script>
<style type="text/css">
td{
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #666666;
background-color: #ffffff;
}
table{
font-family: verdana,arial,sans-serif;
font-size:11px;
color:#333333;
border-width: 1px;
border-color: #666666;
border-collapse: collapse;
}
</style>
<title>教师页面</title>
</head>
<body>
<h1>教师：${teacher.name }</h1>
<form action="${pageContext.request.contextPath }/TeacherServlet?method=query" method="post">
<input type="date" name="date" id="date" value="${date }"><input type="submit" value="查询">
</form>
<table>
<tr>
<td>学生id</td>
<td>学号</td>
<td>姓名</td>
<td>性别</td>
<td>状态</td>
<td>操作</td>
</tr>
<c:forEach items="${students }" var="s">
<tr>
<td>${s.id }</td>
<td>${s.number }</td>
<td>${s.name }</td>
<td>${s.gender }</td>
<td>
	<select name="status" id="${s.id }-status" 
	<c:if test="${s.status==0 }">style='background-color:green'</c:if>
	<c:if test="${s.status==1 }">style='background-color:yellow'</c:if> 
	<c:if test="${s.status==2 }">style='background-color:orange'</c:if>
	<c:if test="${s.status==3 }">style='background-color:red'</c:if>
	>
	<option value="0" <c:if test="${s.status==0 }">selected </c:if>>正常</option>
	<option value="1" <c:if test="${s.status==1 }">selected </c:if>>迟到</option>
	<option value="2" <c:if test="${s.status==2 }">selected </c:if>>早退</option>
	<option value="3" <c:if test="${s.status==3 }">selected </c:if>>旷课</option>
	</select>
</td>
<td><a onclick="record('${s.id}')" href="javascript:void(0)">修改</a></td>
</tr>
</c:forEach>
</table>
统计：
<table>
<tr>
<td style='background-color:green'>正常</td>
<td style='background-color:yellow'>迟到</td>
<td style='background-color:orange'>早退</td>
<td style='background-color:red'>旷课</td>
</tr>
<tr>
<td>${tj.zc }</td>
<td>${tj.cd }</td>
<td>${tj.zt }</td>
<td>${tj.kk }</td>
</tr>
</table>
</body>
</html>