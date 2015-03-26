<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_languang.jsp"%> 
	<div style="background:#CCCCCC">您的位置:<a href="#">首页</a>-><a href="#">市场动态</a></div>
		<div><h1 align = "center"><%=request.getAttribute("dttitle") %></h1><br>
			
			<h4 align = center">日期：<%=request.getAttribute("dtdate") %>&nbsp;&nbsp;&nbsp;&nbsp;来源：<%=request.getAttribute("dtly") %></h4>
			<div style="clear:both"></div>
				<hr />
					<%=request.getAttribute("dtcon") %>
					<hr />
		</div>
<%@ include file="footer.jsp"%>
