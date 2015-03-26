<%@ page language="java" import="java.util.*,fc.yy.YujjlAction" pageEncoding="utf-8"%>
<%@ include file="header_jiaoyi.jsp"%> 
  <div class="xqcon">
			<h2>个人消息</h2>
   <%if(!(request.getAttribute("message").equals("hello"))){ 
  out.println(request.getAttribute("message"));
  }
  %>
  
	<%Object obj = request.getAttribute("userList");
    if (obj !=null) {
    	List list = (List)obj; 
    	Iterator itm = list.iterator();
    	YujjlAction user = null; 
    	while(itm.hasNext()) {
    		user = (YujjlAction)itm.next(); 
  	%>
 	 		
			<div class="yhxx">
 	 		<p><span>房产:<b><%=user.getFyTitle() %></b></span></p>
   	 		<p><span>申请人姓名：<%=user.getKehuName() %></span><span>E-MAIL：<%=user.getKehuMail() %></span></p>
   	 		<p><span>TEL:<%=user.getKehuTel() %></span><span class="redb"><%if(Integer.parseInt(user.getYyAgree())==1){%>审批已通过！<%}else{%><a href="/bluelighting/user/YpassedAction.action?yyId=<%=user.getYyId() %>&jjrId=<%=user.getJjrId() %>"><input type="button" style="background:url(img/landb-now.png);width:80px;color:#fff;font-weight: bold;border:1px #CC9900;cursor:pointer;padding:7px;" value="审批通过"/></a><%} %></span></p>
   	 		
 			</div>

		<% }} %></div>
 	
 <%@ include file="dongtail.jsp"%> 
 <%@ include file="footer.jsp"%> 