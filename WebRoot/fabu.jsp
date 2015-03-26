<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_jiaoyi.jsp"%> 
<div class="ywz">
			<span>您的位置：首页</span><span>-></span><span style="color:#FF9900">房源信息发布</span>
		</div>
		<div style="clear:both"></div>
		
		
		
<form action = "/bluelighting/user/fabu.action" method = "post">
	<input type = "hidden" name = "jjrid" value = "<%=session.getAttribute("userid")%>"/>
		<div class="fabucon">
		${message}<br>
			<table>
				<tr>
					<td>
						房源类型：
					</td>
					<td>
						<select style="border:solid #FF9900 2px;
border-radius:5px;
-moz-border-radius:5px;">
							<option>二手房</option>
							<option>出租房</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>图片上传</td>
					<td><input type="file"/></td>
				</tr>
				<tr>
					<td>标&nbsp;&nbsp;&nbsp;&nbsp;题</td>
					<td><input name = "fytitle" type="text"/></td>
				</tr>
				<tr class="xiaot">
					<td>地址</td>
					<td><select name = "chengqu" style="border:solid #FF9900 2px;
border-radius:5px;
-moz-border-radius:5px;">
							<option value = "0"></option>
							<option value = "城东">城东</option>
							<option value = "城南">城南</option>
							<option value = "城西">城西</option>
							<option value = "城北">城北</option>
							</select>
							</td>
							</tr>
				<tr class="xiaot">
					<td>房屋信息</td>
					<td><select name = "fang" style="border:solid #FF9900 2px;
border-radius:5px;
-moz-border-radius:5px;">
							<option value = "0"></option>
							<option value = "一室">一</option>
							<option value = "二室">二</option>
							<option value = "三室">三</option>
							<option value = "四室">四</option>
						</select>房<select name = "ting"style="border:solid #FF9900 2px;
border-radius:5px;
-moz-border-radius:5px;">   <option value = "0"></option>
							<option value = "一">一</option>
							<option value = "二">二</option>
							<option value = "三">三</option>
							<option value = "四">四</option>
							<option value = "五">五</option>
						</select>厅</td>
					<td><select name = "lou" style="border:solid #FF9900 2px;
border-radius:5px;
-moz-border-radius:5px;">	<option value = "0"></option>
							<option value = "1">1</option>
							<option value = "2">2</option>
							<option value = "3">3</option>
							<option value = "4">4</option>
							<option value = "5">5</option>
							<option value = "6">6</option>
							<option value = "7">7</option>
							<option value = "8">8</option>
							<option value = "9">9</option>
							<option value = "10">10</option>
							<option value = "11">11</option>
							<option value = "12">12</option>
							<option value = "13">13</option>
							<option value = "14">14</option>
							<option value = "15">15</option>
							<option value = "16">16</option>
							<option value = "17">17</option>
							<option value = "18">18</option>
							<option value = "19">19</option>
							<option value = "20">20</option>
							<option value = "21">21</option>
							<option value = "22">22</option>
							<option value = "23">23</option>
							<option value = "24">24</option>
							<option value = "25">25</option>
						</select>楼</td>
					<td>/共<select name = "ceng" style="border:solid #FF9900 2px;
border-radius:5px;
-moz-border-radius:5px;">
							<option value = "0"></option>
							<option value = "1">1</option>
							<option value = "2">2</option>
							<option value = "3">3</option>
							<option value = "4">4</option>
							<option value = "5">5</option>
							<option value = "6">6</option>
							<option value = "7">7</option>
							<option value = "8">8</option>
							<option value = "9">9</option>
							<option value = "10">10</option>
							<option value = "11">11</option>
							<option value = "12">12</option>
							<option value = "13">13</option>
							<option value = "14">14</option>
							<option value = "15">15</option>
							<option value = "16">16</option>
							<option value = "17">17</option>
							<option value = "18">18</option>
							<option value = "19">19</option>
							<option value = "20">20</option>
							<option value = "21">21</option>
							<option value = "22">22</option>
							<option value = "23">23</option>
							<option value = "24">24</option>
							<option value = "25">25</option>
						</select>层</td>
				</tr>
				<tr class="midt">
					<td>房屋面积</td>
					<td><input name = "fysquare" type="text"/>平方米</td>

				</tr>
				<tr class="midt">
					<td>价格</td>
					<td><input name = "fymoney" type="text"/>万</td>
				</tr>
			</table>
			<p>详细介绍</p>
			<p><textarea name = "fyxq" cols="58" rows="10" style="overflow:auto;border:solid #FF9900 2px;
border-radius:5px;
-moz-border-radius:5px;"></textarea></p>

			<p><input type="submit" value="发布" style="cursor:pointer"/></p>
		</div>
	</form>
	
	
<%@ include file="footer.jsp"%> 