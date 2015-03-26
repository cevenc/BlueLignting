<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="/bluelighting/admin/style.css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action = "/bluelighting/user/gaikuang.action" method = "post">
    <textarea class="form_textarea" name="gaikuang"></textarea>
    <input type="submit" class="form_submit" value="修改" />
    </form>
    
    
    
    
    
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
            
            
            <form action="/bluelighting/user/gaikuang.action" method = "post">
             <div class="form_row">
            <label>内容:</label>
            
            <textarea class="form_textarea" name="gaikuang"></textarea>
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
            <form action="<%=basePath%>user/Whf.action">
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
            <form action="<%=basePath%>user/Renlif.action">
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
         <form action="<%=basePath%>user/Newsf.action">
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
