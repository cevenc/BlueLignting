<%@ page language="java" import="java.util.*,news.list.zxnewsAction" pageEncoding="utf-8"%>
<%@ include file="header_jiaoyi.jsp"%> 
    <%Object obj = request.getAttribute("userList");
    if (obj !=null) {
    	List list = (List)obj; 
    	Iterator itm = list.iterator();
    	zxnewsAction user = null; 
    	while(itm.hasNext()) {
    		user = (zxnewsAction)itm.next(); 
  	%>
  	<div class="yhxx">
		<a href="<%=basePath%>user/zxAction.action?zxId=<%=user.getZxId() %>">
 	 		<h3><%=user.getZxTitle() %></h3>
   	 		<p><span>类型：<%=user.getZxType() %></span><span>时间：<%=user.getZxDate() %></span></p>
   	 		</a>
   	 		</div>
 	<% }} %>
<%@ include file="footer.jsp"%> 