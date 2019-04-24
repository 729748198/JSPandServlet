<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
	<h1 style="color: green;">使用javaBean获取</h1>
	<!-- 获取属性的方法1：  -->
	<h2><%=News.getNewsID() %></h2>
	<h2><%=News.getNewsTitle() %></h2>
	<h2><%=News.getNewsContent() %></h2>
	<h2><%=News.getNewsTime() %></h2>

	<!-- 获取属性的方法2:使用jsp:getProperty -->
	<h1><jsp:getProperty property="adminName" name="News"/></h1>
	
	<h2 style="color: blue;">使用EL表达式</h2>
	<h2>${News.newsID }</h2>
	<h2>${News.newsTitle }</h2>
	<h2>${News.newsContent }</h2>
	<h2>${News.newsTime }</h2>
	<h2>${News.adminName }</h2>
	
	
</body>
</html>