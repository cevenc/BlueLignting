<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html  xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>蓝光易居</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="img/zrp_1.jpg">
	<link rel="stylesheet" style="text/css" href="css/style.css" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
  <%String username = (String)session.getAttribute("username");
  String userid = (String)session.getAttribute("userid");%>
<div >
	<div class="wrap">
		<div class="header">
			<div class="header_a">
				<div class="header_h">
					<a href="">添加收藏</a>
					<%if(username == null){ %>
					<a href = "login.jsp">用户登陆</a>
					<%}else{ %>
					<a href = "/bluelighting/user/PrintUserMsg?userid=<%=session.getAttribute("userid")%>">你好，<%=session.getAttribute("username") %></a>
					<%} %>
				</div>
				<div style="clear:both"></div>
				<div class="header_m">
					<div id="logo"><img src="img/pic_04.jpg" /></div>
					<div class="hm_g">
						<div id="city">
							<h2>【成都】</h2>
						</div>
						
						<div id="changecity"><a href="#"><img src="img/pic_10.gif" />切换城市</a></div>
					</div>
					<div class="hm_fr"><img src="img/pic_07.gif" /></div>
				</div>
			</div>
			<div class="header_f">
				<div class="header_s">
					<a href="#" class="sed">首&nbsp;&nbsp;页</a>
					<a href="#">企业文化</a>
					<a href="#">企业概况</a>
					<a href="#">企业文化</a>
					<a href="#">新闻中心</a>
					<a href="#">人力资源</a>
				</div>
				
				<div class="hf_fr"><img src="img/pic2_03.png"/><a href="#">返回蓝光易居</a>				</div>
			</div>
		</div>