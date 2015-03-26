<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>蓝光二手房后台管理系统</title>
<link rel="stylesheet" type="text/css" href="/bluelighting/admin/style.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'>
<!-- jQuery file -->

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
    <li><a href="#" class="selected">公司展示设置</a></li>
    <li><a href="<%=basePath%>admin/zixunadmin.jsp" >房产资讯</a></li>
   
    </ul>
    </div>          
                    
    <div class="center_content">  
 
    <div id="right_wrap">
    <div id="right_content">             
    
    
    <ul id="tabsmenu" class="tabsmenu">
        <li class="active"><a href="#tab1">企业概况</a></li>
        <li><a href="#tab2">企业文化</a></li>
        <li><a href="#tab3">人力资源</a></li>
        <li><a href="#tab4">新闻发表</a></li>
    </ul>
    <div id="tab1" class="tabcontent">
        <h3>企业概况</h3>
        <div class="form">
            
            
            <form action="<%=basePath%>user/Gkf.action"  method = "post">
             <div class="form_row">
            <label>内容:</label>
            
            <textarea class="form_textarea" name="gkfcontent"></textarea>
            </div>
            <div class="form_row">
            <input type="submit" class="form_submit" value="修改" />
            </div> </form>
            <div class="clear"></div>
        </div>
    </div>
    <div id="tab2" class="tabcontent">
        <h3>企业文化</h3>
         <div class="form">
            <form action="<%=basePath%>user/Whf.action" method = "post">
            <div class="form_row">
	            <label>内容:</label>
	            
	             <textarea class="form_textarea" name="whfcontent"></textarea>
	            </div>
	             <div class="form_row">
	            <input type="submit" class="form_submit" value="修改" />
	            </div> </form>
	            <div class="clear"></div>
   			</div>
    </div>

    <div id="tab3" class="tabcontent">
        <h3>人力资源</h3>
       <div class="form">
            <form action="<%=basePath%>user/Renlif.action" method = "post">
            <div class="form_row">
            <label>内容:</label>
             <textarea class="form_textarea" name="renlifcontent"></textarea>
            </div>
             <div class="form_row">
            <input type="submit" class="form_submit" value="修改" />
            </div> </form>
            <div class="clear"></div>
    </div>
    </div> 

    <div id="tab4" class="tabcontent">
        <h3>发表新闻</h3>
        <div class="form">
         <form action="<%=basePath%>user/Newsf.action" method = "post">
        <div class="form_row">
            <label>标题:</label>
            <input type="text" class="form_input" name="newsftitle" />
            </div>
             <div class="form_row">
            <label>内容:</label>
            <textarea class="form_textarea" name="newsfcontent"></textarea>
            </div>
            <div class="form_row">
            <input type="submit" class="form_submit" value="发表" />
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
