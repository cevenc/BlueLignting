<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userEdit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form action="/bluelighting/user/User/EditUserMsg.action" methed="post">
   		<input type="hidden" name = "userid" value="<%=request.getAttribute("userid") %>"/>
    	姓名<input type="text" name="userName" value="<%=request.getAttribute("username") %>"/><br>   
    	账号<input type="text" name="userName" value="<%=request.getAttribute("account") %>"/><br>
    	密码<input type="text" name="userName" value="<%=request.getAttribute("password") %>"/><br>
    	邮箱<input type="text" name="userMail" value="<%=request.getAttribute("mail") %>"/><br>   
    	电话<input type="text" name="userTel" value="<%=request.getAttribute("phone") %>"/><br>   
    	<input type="submit" value = "修改"/>
    </form>
  </body>
</html>
