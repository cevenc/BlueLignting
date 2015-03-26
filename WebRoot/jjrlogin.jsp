<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_jiaoyi.jsp"%> 
<div class="logincon">
			<h2>经纪人登录</h2>
			<div class="lc">
			<form action="/bluelighting/user/JjrLoginAction.action" method = "post">
			<%String msg = (String)request.getAttribute("message"); %>
				<table style="margin:auto">
					<tr><td colspan = "2" style = "text-align:center">${message}</td></tr>
					<tr>
						<td>账&nbsp;&nbsp;号</td>
						<td><input name = "account" style="width:180px;height:22px;" type="text" placeholder="请输入用户名"/></td>
						
					</tr>
					<tr/>
					<tr>
						<td>密&nbsp;&nbsp;码</td>
						<td><input name = "password" style="width:180px;height:22px;" placeholder="请输入密码" type="password"/></td>
					</tr>
					<tr>
						<td/>
						<td><input id="loginb" style="background:url(img/landb-now.png);width:80px;color:#fff;font-weight: bold;border:1px #CC9900;cursor:pointer;padding:7px;" type="submit" value="登录" /></td>
					</tr>					
				</table>
				</form>
			</div>
		</div>	
<%@ include file="footer.jsp"%> 
