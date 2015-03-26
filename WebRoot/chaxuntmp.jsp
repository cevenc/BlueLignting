<%@ page language="java" import="java.util.*, fc.manage.Chaxun" pageEncoding="utf-8"%>
<%@ include file="header_jiaoyi.jsp"%> 
				
		<div class="ywz">
			<span>您的位置：首页</span><span>-></span><span style="color:#FF9900">二手房</span>
		</div>
		<div style="clear:both"></div>
		<div class="chaxun_a">
			<div class="ca_aa">
				<div class="area">
					<p><b>区域：</b><a href="/bluelighting/user/Chaxun.action?quyu=0"><span>不限</span></a><a href="/bluelighting/user/Chaxun.action?quyu=1">城东</a><a href="/bluelighting/user/Chaxun.action?quyu=2">城南</a><a href="/bluelighting/user/Chaxun.action?quyu=3">城西</a><a href="/bluelighting/user/Chaxun.action?quyu=4">城北</a></p>
					<p><b>售价：</b><a href="/bluelighting/user/Chaxun.action?fyprice=0"><span>不限</span></a><a href="/bluelighting/user/Chaxun.action?fyprice=1">40万以下</a><a href="/bluelighting/user/Chaxun.action?fyprice=2">40-80万</a><a href="/bluelighting/user/Chaxun.action?fyprice=3">80-120万</a><a href="/bluelighting/user/Chaxun.action?fyprice=4">120万以上</a></p>
					<p><b>面积：</b><a href="/bluelighting/user/Chaxun.action?fysquare=0"><span>不限</span></a><a href="/bluelighting/user/Chaxun.action?fysquare=1">50平米以下</a><a href="/bluelighting/user/Chaxun.action?fysquare=2">50-70平米</a><a href="/bluelighting/user/Chaxun.action?fysquare=3">70-90平米</a><a href="/bluelighting/user/Chaxun.action?fysquare=4">90平米以上</a></p>
					<p><b>房型：</b><a href="/bluelighting/user/Chaxun.action?fytype=0"><span>不限</span></a><a href="/bluelighting/user/Chaxun.action?fytype=1">一室</a><a href="/bluelighting/user/Chaxun.action?fytype=2">二室</a><a href="/bluelighting/user/Chaxun.action?fytype=3">三室</a><a href="/bluelighting/user/Chaxun.action?fytype=4">四室</a></p>
					<img src="img/images/fangyuan1_03.jpg" />
					<p><b>区域：</b>
						<select>
							<option>---请选择---</option>
						</select>
						<input type="text"  style="height:20px"/>
						<input type="submit" value="查询" style="background-color:#00FFCC;border:solid #00CCCC"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<%if(iden == 2 ){ %><a href="fabu.jsp"><input type="button" style="background:url(img/landb-now.png);width:80px;color:#fff;font-weight: bold;border:1px #CC9900;cursor:pointer;padding:7px;" value="发布房源"/></a><%} %>
					</p>
				</div>
				<div class="areaimg">
					<img src="img/images/fangyuan_03.jpg" />
					<img src="img/images/fangyuan_06.jpg" />
				</div>
			</div>
		</div>
		<div class="chaxun_b">
			<div class="cb_aa">
				<div class="cbaa_a">
					<span class="choose"><%=request.getAttribute("message") %>
					</span>
				</div>
				<div class="cbaa_b">
				<%Object obj = request.getAttribute("fangList");
				String pp;
				String ss;
				int pp2;
				int ss2;

    			if (obj !=null) {
    				List list = (List)obj; 
    				Iterator itm = list.iterator();
    				Chaxun fang = null; 
    				while(itm.hasNext()) {
    					fang = (Chaxun)itm.next(); 
    					pp = fang.getFyprice();
    					ss = fang.getFysquare();
    					pp2 = Integer.parseInt(pp);
    					ss2 = Integer.parseInt(ss);
    					ss2 = pp2*10000/ss2;
  				%>
					<div class="chaxuncon">
						<div class="ccimg">
							<img src="img/images/fangyuan_29.jpg" />
						</div>
						<div class="ccxinxi">
							<p>标&nbsp;&nbsp;&nbsp;&nbsp;题：<span style="color:#CC3300"><a href = "/bluelighting/user/SendFangMsg.action?fyid = <%=fang.getFyid()%>"><%=fang.getFytitle()%></a></span></p>
							<p>楼盘信息：<span style="color:#00CCFF"><%=fang.getQuyu() %></span></p>
							<p>房屋信息：<span ><%=fang.getFytype()%></span></p>
							<p>经&nbsp;纪&nbsp;人：<b><%=fang.getJjrname() %></b><img src="img/images/fangyuan_16.jpg" /><img src="img/images/fangyuan_22.jpg" /><img src="img/images/fangyuan_24.jpg" /></p>
						</div>
						<div class="ccs">
							<b style="color:#CC3300"><%=fang.getFysquare() %></b>平方米
						</div>
						<div class="ccprice">
							<p><b style="color:#CC3300"><%=fang.getFyprice() %>万</b></p>
							<p>单价：<%out.println(ss2); %>元/平米</p>
						</div>
					</div>
					<div style="clear:both"></div>
					<%}} %>
					
				</div>
			</div>
			
			<%@ include file="dongtail.jsp"%>
<%@ include file="footer.jsp"%> 

