<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>权限错误</title>  
  </head>  
    
  <body>  
    <h1>对不起，您没有权限请求此连接！</h1>  
    <img alt="" src="<%=basePath%>static/img/1.jpg">  
      
  </body>  
</html>  