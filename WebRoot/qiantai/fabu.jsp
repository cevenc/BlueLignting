<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header_jiaoyi.jsp"%> 
<div class="ywz">
			<span>您的位置：首页</span><span>-></span><span style="color:#FF9900">房源信息发布</span>
		</div>
		<div style="clear:both"></div>

		<div class="fabucon">
			<table>
				<tr>
					<td>
						房源类型：
					</td>
					<td>
						<select>
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
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>所属楼盘</td>
					<td><input type="text"/></td>
				</tr>
				<tr class="xiaot">
					<td>房屋信息</td>
					<td><input type="text"/>房<input type="text">厅</td>
					<td><input type="text"/>楼</td>
					<td>/共<input type="text"/>层</td>
				</tr>
				<tr class="midt">
					<td>房屋面积</td>
					<td><input type="text"/>平方米</td>

				</tr>
				<tr class="midt">
					<td>价格</td>
					<td><input type="text"/>万</td>
				</tr>
			</table>
			<p>详细介绍</p>
			<p><textarea cols="58" rows="10" style="overflow:auto"></textarea></p>

			<p><input type="submit" value="发布" style="cursor:pointer"/></p>
		</div>
<%@ include file="footer.jsp"%> 