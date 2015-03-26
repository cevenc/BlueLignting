<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_jiaoyi.jsp"%> 

	<div style = "margin:0 auto; text-align:center">
    <form action="/bluelighting/user/ZhuanjiaAction.action" method="post">
    	<table style = "margin:auto">
 		<tr><td>资讯标题：</td><td><input type="text" name="Zjtitle"></td></tr>
    	<tr><td>类型：</td><td><select name="type">
    			<option value="专家访谈">专家访谈</option>
    			<option value="置业指南">置业指南</option>
    			<option value="房产咨询">房产咨询</option>
    		</select></td></tr>
    	</table><br>
    	资讯内容：<br>
    	<textarea cols="58" rows="10" style="overflow:auto" name = "zym"></textarea><br><br>
    	<tr><td colspan = "2"><input type="submit" value="提交"/></td></tr>
    	
 	</form>
 	</div>
 	
<%@ include file="footer.jsp"%> 
