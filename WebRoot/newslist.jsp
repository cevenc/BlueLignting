<%@ page language="java" import="java.util.*,news.list.gsnewsAction" pageEncoding="utf-8"%>
<%@ include file="header_languang.jsp"%> 
     <%Object obj = request.getAttribute("userList");
    if (obj !=null) {
    	List list = (List)obj; 
    	Iterator itm = list.iterator();
    	gsnewsAction user = null; 
    	while(itm.hasNext()) {
    		user = (gsnewsAction)itm.next(); 
  	%>
  	<div class="yhxx">
		<a href="<%=basePath%>user/NewsAction.action?newsId=<%=user.getNewsId() %>">
 	 		<h3><%=user.getNewsTitle() %></h3>
   	 		<p><span>来源：蓝光易居</span><span>时间：<%=user.getNewsDate() %></span></p>
   	 		</a>
   	 		</div>
 	<% }} %>
<%@ include file="footer.jsp"%> 