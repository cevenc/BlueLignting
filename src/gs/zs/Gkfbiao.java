package gs.zs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class Gkfbiao extends ActionSupport {
	private String  getjsbyid = " select js_id,js_title,js_content from qiye_jieshao where js_id = ?";
	private String jsid;
	private String jstitle;
	private String jscontent;
	private List  jsList = new ArrayList();
	Connection con=dbconn.getConnection();
	
	public String execute()throws Exception{
		PreparedStatement  stmt = con.prepareStatement(this.getjsbyid);
		stmt.setInt(1,Integer.parseInt(jsid));
		ResultSet rs = stmt.executeQuery();
		
		Gkfbiao user = null;
		while (rs.next()) {
			System.out.println("sdfadsfsdsafdsfasgasdfdsf");
			user = new Gkfbiao();
			user.setJsid(String.valueOf(rs.getInt("js_id")));
			//user.setGkfid(String.valueOf(rs.getInt("js_id")));//NewsID数据库中的键，把
			this.setJstitle(rs.getString("js_title"));
			this.setJscontent(rs.getString("js_content"));

			jsList.add(user);
		}
		
		con.close();
		return "zsjs";
	}

	public String getJsid() {
		return jsid;
	}

	public void setJsid(String jsid) {
		this.jsid = jsid;
	}

	public String getJstitle() {
		return jstitle;
	}

	public void setJstitle(String jstitle) {
		this.jstitle = jstitle;
	}

	public String getJscontent() {
		return jscontent;
	}

	public void setJscontent(String jscontent) {
		this.jscontent = jscontent;
	}

	public List getJsList() {
		return jsList;
	}

	public void setJsList(List jsList) {
		this.jsList = jsList;
	}

	
	
	
	
}
