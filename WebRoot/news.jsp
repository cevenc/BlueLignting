<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_languang.jsp"%> 
	<div style="background:#CCCCCC">您的位置:<a href="#">首页</a>-><a href="#">新闻中心</a>-><a href="#"><b>公司新闻</b></a></div>
		<div><h2 align = "center"><%=request.getAttribute("newsTitle") %></h2>
			<ul class="zrp_1">
			  <li>发布时间：<%=request.getAttribute("newsDate") %></li>
			  <li>新闻来源：蓝光易居</li>
			</ul>

			<div style="clear:both"></div>
				<hr />
					<%=request.getAttribute("newsContent") %>
					<hr />
		</div>
<%@ include file="footer.jsp"%> 