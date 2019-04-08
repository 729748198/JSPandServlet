<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String socketPath = request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head lang="en">
		<meta charset="UTF-8">
		<title>登录页面</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="stylesheet"
			href="/css/amazeui.min.css" />
		<style>
		
.header {
	text-align: center;
}

.header h1 {
	font-size: 200%;
	color: #333;
	margin-top: 30px;
}

.header p {
	font-size: 14px;
}
</style>
	</head>

	<body>
		
		<div class="header">
			<div class="am-g">
				<h1>
					登录
				</h1>
			</div>
			<hr />
		</div>
		
		<div class="am-g">
			<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
				<form action="dologin.jsp" method="get" class="am-form login-form" onSubmit="return LoginCheck()">
					<label for="name">
						用户名:
					</label>
					<input type="text" name="User" id="User"  value="">
					<br>
					<label for="ps">
						密码:
					</label>
					<input type="password" name="Pwd"  id="Pwd"  value="">
					<br>
					<label for="imagecode">
						验证码:
					</label>
					<img alt="验证码" id="imagecode" src="http://localhost:8080/JSPandServlet/img"/>
  					 <input type="password" name="yzm"  id="yzm"  value="">
					<br />
					<div class="am-cf">
					
					<input name="Action" type="hidden" value="Login">
					
					
					<input type="submit" value="登 录" id="save"	class="am-btn am-btn-primary am-btn-sm am-fl">

					</div>
				</form>
				
			</div>
		</div>
		
	</body>

	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.min.js"></script>
<script>
function LoginCheck() 
{   

    var LoginCheck = false;
    if($("#User").val()==="" || $("#Pwd").val()===""){
		alert("用户名或密码不能为空!");
        return false;
	}
    
    return true;
}
</script>
	<!--<![endif]-->
</html>