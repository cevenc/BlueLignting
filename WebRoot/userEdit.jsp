<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_jiaoyi.jsp"%> 
<div class="xqcon">
		<h2>个人信息修改</h2>
			<div class="yhxx">
   <form action="/bluelighting/user/EditUserMsg.action" method="post">
   		<input type="hidden" name = "userid" value="<%=request.getAttribute("userid") %>"/>
    	姓名<input type="text" name="username" value="<%=request.getAttribute("username") %>"/><br>   
    	<input type="hidden" name="account" value="<%=request.getAttribute("account") %>"/>
    	密码<input type="text" name="password" value="<%=request.getAttribute("password") %>"/><br>
    	邮箱<input type="text" name="mail" value="<%=request.getAttribute("mail") %>"/><br>   
    	电话<input type="text" name="phone" value="<%=request.getAttribute("phone") %>"/><br>   
    	<input type="submit" value = "确认修改" class="button"/>
    </form>
   </div>
   </div>
   <%@ include file="dongtail.jsp"%>
  <%@ include file="footer.jsp"%> 
