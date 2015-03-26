package gs.zs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class Newsfbiao extends ActionSupport {
	private String  getnewsfbyid = " select js_id,js_title,js_content from qiye_jieshao where js_id = ?";
	private String newsfid = "3";
	private String newsftitle;
	private String newsfcontent;
	private List  newsfList = new ArrayList();
	Connection con=dbconn.getConnection();
	
	public String execute()throws Exception{
		PreparedStatement  stmt = con.prepareStatement(this.getnewsfbyid);
		stmt.setInt(1,Integer.parseInt(newsfid));
		ResultSet rs = stmt.executeQuery();
		
		Newsfbiao user = null;
		while (rs.next()) {
			System.out.println("sdfadsfsdsafdsfasgasdfdsf");
			user = new Newsfbiao();
			user.setNewsfid(String.valueOf(rs.getInt("js_id")));
			//user.setGkfid(String.valueOf(rs.getInt("js_id")));//NewsID数据库中的键，把
			user.setNewsftitle(rs.getString("js_title"));
			user.setNewsfcontent(rs.getString("js_content"));

			newsfList.add(user);
		}
		
		con.close();
		return "biaonewssuc";
	}

	public String getNewsfid() {
		return newsfid;
	}
	public void setNewsfid(String newsfid) {
		this.newsfid = newsfid;
	}
	public String getNewsftitle() {
		return newsftitle;
	}
	public void setNewsftitle(String newsftitle) {
		this.newsftitle = newsftitle;
	}
	public String getNewsfcontent() {
		return newsfcontent;
	}
	public void setNewsfcontent(String newsfcontent) {
		this.newsfcontent = newsfcontent;
	}
	public List getNewsfList() {
		return newsfList;
	}
	public void setNewsfList(List newsfList) {
		this.newsfList = newsfList;
	}
	
	
	
}
