<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="http://localhost:8080/JSPandServlet/selectNews">
<h1>新闻查找</h1>
<p>请输入新闻ID</p>
<input type="text" name="id"/>
<input type="submit" value="提交"/>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>