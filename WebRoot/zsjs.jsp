<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_languang.jsp"%> 
	<div style="background:#CCCCCC">您的位置:<a href="#">首页</a>-><a href="#"><%=request.getAttribute("jstitle") %></a></div>
		<div><h2 align = "center"><%=request.getAttribute("jstitle") %></h2>
			

			<div style="clear:both"></div>
				<hr />
					<%=request.getAttribute("jscontent") %>
					<hr />
		</div>
<%@ include file="footer.jsp"%> 