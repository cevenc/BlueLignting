<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_jiaoyi.jsp"%> 
	<div class="ywz">
			<span>您的位置：首页</span><span>-></span><span style="color:#FF9900">房屋详情</span>
		</div>
		<div style="clear:both"></div>

		<div class="xqcon">
		<%String pp = (String)request.getAttribute("fyprice");
		String ss = (String)request.getAttribute("fysquare");
		int pp2 = Integer.parseInt(pp);
		int ss2 = Integer.parseInt(ss);
		ss2 = pp2*10000/ss2; %>
			<h3>房屋详情</h3>
			<div class="xqc_c">
				<h4><%=request.getAttribute("fytitle") %></h4>
				<table>
					<tr>
						<td><span>总价</span></td>
						<td><b><%=request.getAttribute("fyprice") %>万元</b></td>
						<td/>
						<td><span>户型</span></td>
						<td><%=request.getAttribute("fang") %><%=request.getAttribute("ting") %>厅</td>
					</tr>
					<tr>
						<td><span>单价</span></td>
						<td><b><%out.println(ss2); %>元/平米</b></td>
						<td/>
						<td><span>面积</span></td>
						<td><%=request.getAttribute("fysquare") %>平米</td>
					</tr>
					<tr>
						<td><span>电话</span></td>
						<td><%=request.getAttribute("jjrphone") %></td>
						<td/>
						<td/>
						<td><%if(iden == 1 || iden == 0) {%><a href="/bluelighting/user/YyAction.action?userid = <%=session.getAttribute("userid") %>&fyid=<%=request.getAttribute("fyid") %>&jjrid=<%=request.getAttribute("jjrid") %>"><input type="button" style="background:url(img/landb-now.png);width:80px;color:#fff;font-weight: bold;border:1px #CC9900;cursor:pointer;padding:7px;" value="预约看房"/></a><%} %></td>
					</tr>
					<tr><td colspan = "2">${message}</td></tr>
				</table>
			</div>
			<div class="lpxx">
				<p><b><%=request.getAttribute("fytitle") %></b></p>
			</div>
			<div class="xqjs">
				<p><%=request.getAttribute("fyxq") %></p>
				<p><img src="img/fw.jpg"/></p>
			</div>

		</div>
		<%@ include file="dongtail.jsp"%>
<%@ include file="footer.jsp"%> 
