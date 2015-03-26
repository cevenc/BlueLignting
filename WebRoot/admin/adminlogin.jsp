<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>蓝光易居后台管理系统</title>
<link rel="stylesheet" type="text/css" href="/bluelighting/admin/style.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'>
</head>
  
  <body>
   <div id="loginpanelwrap">
  	
	<div class="loginheader">
    <div class="logintitle"><a href="#">蓝光易居后台管理系统</a></div>
    </div>

     
    <div class="loginform">
        <form action = "/bluelighting/user/glylogin.action" method = "post">
        <div class="loginform_row">
        ${message}<br/>
        <label>账号:</label>
        <input type="text" class="loginform_input" name="account" />
        </div>
        <div class="loginform_row">
        <label>密码:</label>
        <input type="password" class="loginform_input" name="password" />
        </div>
        <div class="loginform_row">
        <input type="submit" class="loginform_submit" value="登录" />
        </div>
        </form> 
        <div class="clear"></div>
    </div>
 

</div>
  </body>
</html>
