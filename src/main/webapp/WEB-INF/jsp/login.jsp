<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录管理系统</title>
<link href="<%=basePath%>bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>bootstrap/css/signin.css" rel="stylesheet">
</head>
<body>

<div class="signin">
	<div class="signin-head"><img src="<%=basePath%>bootstrap/images/test/head_120.png" alt="" class="img-circle"></div>
	<form class="form-signin" role="form" action="<%=basePath%>login" method="post">
		<input type="text" name="userName" class="form-control" placeholder="用户名" required autofocus />
		<input type="password" name="password" class="form-control" placeholder="密码" required />
		<button class="btn btn-lg btn-warning btn-block" type="submit">登录</button>
		<label class="checkbox">
			<input type="checkbox" value="remember-me">记住我
		</label>
	</form>
</div>
</body>
</html>
