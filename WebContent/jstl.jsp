<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- 判断el表达式是否为空的标准函数声明 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %><!-- 判断el集合是否为空的声明 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
String user=(String)request.getSession().getAttribute("user");
%>
</head>
<body>
<c:if test="${user!=null}">
Hello ,Welcome ${user }
</c:if>
<c:if test="${user==null}">
请登录
</c:if>
</body>
</html>