<%@ page language="java" import="java.util.*,fc.yy.YuserlAction" pageEncoding="utf-8"%>
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
    	YuserlAction user = null; 
    	while(itm.hasNext()) {
    		user = (YuserlAction)itm.next(); 
  	%> 	
 	 		
			<div class="yhxx">
 	 		<p><span>房产:<b><%=user.getFyTitle() %></b></span></p>
   	 		<p><span>经纪人姓名：<%=user.getJingjiName() %></span><span>E-MAIL：<%=user.getJingjiMail() %></span></p>
   	 		<p><span>TEL:<%=user.getJingjiTel() %></span><span class="redb"><%if(Integer.parseInt(user.getYyAgree())==1){%>审批已通过！请等待经纪人联系！<%}else{%>经纪人未审批！请等待审批！<%} %></span></p>
   	 		
 			</div><% }} %>
 			</div>
 			<%@ include file="dongtail.jsp"%> 
 <%@ include file="footer.jsp"%> 
