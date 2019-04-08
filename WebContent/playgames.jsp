<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String socketPath = request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>玩游戏</title>
</head>
<body> 
<h1>来猜数字吧</h1>
<form action="http://localhost:8080/JSPandServlet/playGames" method="get">
用户名:<input type="text" name="user">
<br>
数字:<input type="text" name="number">
<input type="submit">
</form>
<% if(request.getAttribute("meg")!=null){
	
	%>
	<p><%=request.getAttribute("meg") %></p>
<% }%>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>