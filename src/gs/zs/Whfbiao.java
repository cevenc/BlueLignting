package gs.zs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class Whfbiao extends ActionSupport {
	private String  getwhfbyid = " select js_id,js_title,js_content from qiye_jieshao where js_id = ?";
	private String whfid = "2";
	private String whftitle;
	private String whfcontent;
	private List  whfList = new ArrayList();
	Connection con=dbconn.getConnection();
	
	public String execute()throws Exception{
		PreparedStatement  stmt = con.prepareStatement(this.getwhfbyid);
		stmt.setInt(1,Integer.parseInt(whfid));
		ResultSet rs = stmt.executeQuery();
		
		Whfbiao user = null;
		while (rs.next()) {
			System.out.println("sdfadsfsdsafdsasgasdfdsf");
			user = new Whfbiao();
			user.setWhfid(String.valueOf(rs.getInt("js_id")));
			//user.setGkfid(String.valueOf(rs.getInt("js_id")));//NewsID数据库中的键，把
			user.setWhftitle(rs.getString("js_title"));
			user.setWhfcontent(rs.getString("js_content"));

			whfList.add(user);
		}
		
		con.close();
		return "biaowhsuc";
	}

	public String getWhfid() {
		return whfid;
	}
	public void setWhfid(String whfid) {
		this.whfid = whfid;
	}
	public String getWhftitle() {
		return whftitle;
	}
	public void setWhftitle(String whftitle) {
		this.whftitle = whftitle;
	}
	public String getWhfcontent() {
		return whfcontent;
	}
	public void setWhfcontent(String whfcontent) {
		this.whfcontent = whfcontent;
	}
	public List getWhfList() {
		return whfList;
	}
	public void setWhfList(List whfList) {
		this.whfList = whfList;
	}
	
	
	
}
