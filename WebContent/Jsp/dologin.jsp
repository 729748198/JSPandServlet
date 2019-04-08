<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name=request.getParameter("User");
	String password=request.getParameter("Pwd");
	if(name.equals("贺文杰")&&password.equals("123456")){
		out.println("登录成功");
	}else{
		
		request.getRequestDispatcher("error.jsp").forward(request, response);
	
	}
%>
</body>
</html>