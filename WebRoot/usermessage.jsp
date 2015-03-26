<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_jiaoyi.jsp"%> 
<div class="xqcon">
		<h2>个人信息修改</h2>
			<div class="yhxx">
  <form action = "/bluelighting/user/SendUserMsg.action" method = "post">
  <div style = "margin:10px auto; border:1px solid #ddd">
  <input type="hidden" name = "userid" value="<%=request.getAttribute("userid") %>"/>
    <table style = "margin:0 auto">
    <tr><td>用户名：</td><td><%=request.getAttribute("username")%></td></tr>
    <tr><td>账号：</td><td><%=request.getAttribute("account") %></td></tr>
    <tr><td>密码：</td><td><%=request.getAttribute("password") %></td></tr>
    <tr><td>电话：</td><td><%=request.getAttribute("phone") %></td></tr>
    <tr><td>邮箱：</td><td><%=request.getAttribute("mail") %></td></tr>
    <tr><td colspan = "2"><input type = "submit" value = "修改" class="button"/></td></tr>
    </table>
   </div>
    </form>
    </div></div>
    <%@ include file="dongtail.jsp"%>
<%@ include file="footer.jsp"%> 
