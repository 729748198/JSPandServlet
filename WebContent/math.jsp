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
<title>数学运算</title>
</head>
<body>
<form action="domath.jsp" method="post">
	<h1>输入数字</h1>
<p>a</p>
<input type="text" name="a"/>
<p>b</p>
<input type="text" name="b"/>
<select name="op">
  <option value ="+" >加</option>
  <option value ="-" >减</option>
  <option value="*" >乘</option>
  <option value="/">除</option>
</select>
<input type="submit" value="提交"/>
</form>
</body>
</html>