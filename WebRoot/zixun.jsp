<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_languang.jsp"%> 
   <div style="background:#CCCCCC">您的位置:<a href="#">首页</a>-><a href="#">房产资讯</a>-><a href="#"><b><%=request.getAttribute("zxType") %></b></a></div>
		<div><h2 align = "center"><%=request.getAttribute("zxTitle") %></h2>
			<ul class="zrp_1">
			  <li>发布时间：<%=request.getAttribute("zxDate") %></li>
			  <li>新闻来源：四川在线</li>
			</ul>

			<div style="clear:both"></div>
				<%=request.getAttribute("zxContent") %>
		</div>
 <%@ include file="footer.jsp"%> 
