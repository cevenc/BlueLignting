<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_jiaoyi.jsp"%> 
<div class="logincon">
			<h2>用户登录</h2>
			<div class="lc">
			<form action="/bluelighting/user/login.action" method = "post">
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
						<td><input id="loginb" style="background:url(img/daohang.jpg);border:1px #CC9900;cursor:pointer" type="submit" value="用户登录" /></td>
					</tr>					
				</table>
				</form>
			</div>
		</div>
		
		<div class="zhucecon">
			<h2>还没有账号？</h2>
			<div class="zc">
			<form action="/bluelighting/user/regist.action" method = "post">
				<table style="margin:auto">
					<tr>
						<td>账&nbsp;&nbsp;&nbsp;&nbsp;号</td>
						<td><input name = "account" style="width:180px;height:22px;" type="text" placeholder="请输入用户名" name="username"/></td>
						
					</tr>
					<tr/>
					<tr>
						<td>密&nbsp;&nbsp;&nbsp;&nbsp;码</td>
						<td><input name = "password" style="width:180px;height:22px;" placeholder="请输入密码" type="password" name="userpsw" /></td>
					</tr>
					<tr>
						<td>确认密码</td>
						<td><input style="width:180px;height:22px;" placeholder="请确认密码" type="password" name="userpsw" /></td>
					</tr>
					<tr>
						<td>邮&nbsp;&nbsp;&nbsp;&nbsp;箱</td>
						<td><input name = "mail" style="width:180px;height:22px;" placeholder="请输入邮箱" type="text" name="usermail" /></td>
					</tr>
					<tr>
						<td>姓&nbsp;&nbsp;&nbsp;&nbsp;名</td>
						<td><input name = "username" style="width:180px;height:22px;" placeholder="请输入您的姓名" type="text" name="userrealname" /></td>
					</tr>
					<tr>
						<td>电&nbsp;&nbsp;&nbsp;&nbsp;话</td>
						<td><input name = "phone" style="width:180px;height:22px;" placeholder="请输入您的电话" type="text" name="usertel" /></td>
					</tr>
					
					<tr>
						<td/>
						<td><input id="loginb" style="background:url(img/daohang.jpg);border:1px #CC9900;cursor:pointer" type="submit" value="注册" /></td>
					</tr>
					
				</table>
				</form>
			</div>
		</div>
<%@ include file="footer.jsp"%> 
