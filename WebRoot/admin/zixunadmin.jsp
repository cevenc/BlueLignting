<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Panelo - Free Admin Template</title>
<link rel="stylesheet" type="text/css" href="/bluelighting/admin/style.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'>
<!-- jQuery file -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var $ = jQuery.noConflict();
$(function() {
$('#tabsmenu').tabify();
$(".toggle_container").hide(); 
$(".trigger").click(function(){
	$(this).toggleClass("active").next().slideToggle("slow");
	return false;
});
});
</script>
</head>
  
  <body>
    <div id="panelwrap">
  	
	<div class="header">
    <div class="title"><a href="#">蓝光易居二手房交易平台后台管理系统</a></div>
    
    <div class="header_right">欢迎！ Admin,<a href="#" class="logout">退出登录</a> </div>
    
    <div class="menu">
    <ul>
    <li><a href="#" class="selected">网站主页</a></li>
    
    </ul>
    </div>
    
    </div>
    
    <div class="submenu">
    <ul>
    <li><a href="<%=basePath%>admin/admin.jsp" >公司展示设置</a></li>
    <li><a href="#" class="selected">房产资讯</a></li>
   
    </ul>
    </div>          
                    
    <div class="center_content">  
 
    <div id="right_wrap">
    <div id="right_content">             
    
    
    <ul id="tabsmenu" class="tabsmenu">
        <li class="active"><a href="#tab1">房产资讯发布</a></li>
       
        
    </ul>
    <form action = "/bluelighting/user/ZhuanjiaAction.action" method = "post">
    <div id="tab1" class="tabcontent">
        <h3>房产资讯</h3>
        <div class="form">
            
            <div class="form_row">
            <label>资讯标题:</label>
            <input type="text" class="form_input" name="Zjtitle" />
            </div>
             
            <div class="form_row">
            <label>资讯来源:</label>
            <input type="text" class="form_input" name="" />
            </div>
            
            <div class="form_row">
            <label>资讯种类:</label>
            <select class="form_select" name="type">
            <option value="专家访谈">专家访谈</option>
            <option value="置业指南">置业指南</option>
            <option value="房产资讯">房产资讯</option>
            </select>
            </div>
            
             <div class="form_row">
            <label>资讯内容:</label>
            <textarea class="form_textarea" name="zym"></textarea>
            </div>
            <div class="form_row">
            <input type="submit" class="form_submit" value="发布" />
            </div> 
            
            </form>
            <div class="clear"></div>
        </div>
    </div>
    
     
    

    
      
     </div>
     </div><!-- end of right content-->
                     
                    
          
    
    
    <div class="clear"></div>
    </div> <!--end of center_content-->
    
    <div class="footer">
 <a href="#">蓝光易居</a>
</div>

</div>
  </body>
</html>
