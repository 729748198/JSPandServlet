<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String socketPath = request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
//获取上下文
ServletContext context=this.getServletContext(); 
//总登录人数
Integer count=(Integer)context.getAttribute("count");
//当前用户
String user=(String)request.getSession().getAttribute("user");
if(user==null){
	response.sendRedirect("login.jsp");
}
Integer now=1;	
Cookie[] Cookies = request.getCookies();  
for(int i =0;i<Cookies.length;i++){  
    Cookie c = Cookies[i];  
    if(c.getName().equals(user)) {
    	now=Integer.valueOf(c.getValue());
     }
    
}  

	String liwu="您是我们的贵宾，我们给你准备了礼物";

%>
<body>
<h2>恭喜您，<%= request.getSession().getAttribute("user")%>,登录成功！,登录次数为<%=now %>,当前总登录人数<%=count %></h2>
	<%
	if(now>4){
		
	
	%>
	<p><%=liwu %></p>
	<%
	}
	%>
<p>您现在可以选择</p>
<a href="http://localhost:8080/JSPandServlet/addNews.jsp">1.插入新闻</a><br>
<a href="http://localhost:8080/JSPandServlet/selectNews.jsp">2.查找新闻</a><br>
<a href="http://localhost:8080/JSPandServlet/playgames.jsp">3.玩游戏：猜数字</a><br>
<a href="http://localhost:8080/JSPandServlet/chengfabiao.jsp">4.九九乘法表</a><br>
<a href="http://localhost:8080/JSPandServlet/Jsp/login.jsp">5.使用JSP进行登录验证</a><br>
<a href="http://localhost:8080/JSPandServlet/JavaBean.jsp">6.使用JavaBean</a><br>
<a href="http://localhost:8080/JSPandServlet/math.jsp">6.数学运算</a><br>
<a href="http://localhost:8080/JSPandServlet/jstl.jsp">8.使用JSTL表达式</a><br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>