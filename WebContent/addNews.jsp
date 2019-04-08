<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="http://localhost:8080/JSPandServlet/addNews">
<h1>插入新闻</h1>
<p>请输入新闻ID</p>
<input type="text" name="id"/>
<p>请输入新闻标题</p>
<input type="text" name="title"/>
<p>请输入新闻内容</p>
<input type="text" name="content"/> 
<p>请输入新闻时间</p>
<input type="text" name="time"/>
<p>请输入新闻作者</p>
<input type="text" name="name"/>
<input type="submit" value="提交"/>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>