<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="Math" scope="page" class="vo.Math"/>
<%
	//设置编码
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	Math.setA(Integer.valueOf(request.getParameter("a")));
	Math.setB(Integer.valueOf(request.getParameter("b")));
	String string=request.getParameter("op");
	int jia=0;
	if(string.equals("+")){
		jia=Math.add();
	}
	if(string.equals("-")){
		jia=Math.jian();
	}
	if(string.equals("*")){
		jia=Math.cheng();
	}
	if(string.equals("/")){
		jia=Math.chu();
	}
	%>
	<!-- 获取属性的方法1：  -->
<p>	<%=Math.getA() %><%=string %>
	<%=Math.getB() %>=<%=jia
	%></p>
</body>
</html>