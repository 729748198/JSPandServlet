<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用JavaBean接收JavaBean中传过来的值</title>
</head>
<body>
<!-- 引入JavaBean  -->
<jsp:useBean id="News" scope="page" class="vo.News"/>
<%
	//设置编码
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	
	//设置属性的方法1：直接调用
	News.setNewsID(Integer.valueOf(request.getParameter("id")));
	News.setNewsTitle(request.getParameter("title"));
	News.setNewsContent(request.getParameter("content"));
	News.setNewsTime(request.getParameter("time"));
	//News.setAdminName(request.getParameter("name"));
	String name=request.getParameter("name");
%>
	<!-- 设置属性的方法2:利用jsp:setProperty -->
	<jsp:setProperty property="adminName" name="News" value="<%=name %>" />
	<p>输入的新闻为</p>
	
	<!-- 获取属性的方法1：  -->
	<h1><%=News.getNewsID() %></h1>
	<h1><%=News.getNewsTitle() %></h1>
	<h1><%=News.getNewsContent() %></h1>
	<h1><%=News.getNewsTime() %></h1>
	
	<!-- 获取属性的方法2:使用jsp:getProperty -->
	<h1><jsp:getProperty property="adminName" name="News"/></h1>
</body>
</html>