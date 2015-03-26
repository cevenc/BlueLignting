package gs.zs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class Renlifbiao extends ActionSupport {
	private String  getrenlifbyid = " select js_id,js_title,js_content from qiye_jieshao where js_id = ?";
	private String renlifid = "4";
	private String renliftitle;
	private String renlifcontent;
	private List  renlifList = new ArrayList();
	Connection con=dbconn.getConnection();
	
	public String execute()throws Exception{
		PreparedStatement  stmt = con.prepareStatement(this.getrenlifbyid);
		stmt.setInt(1,Integer.parseInt(renlifid));
		ResultSet rs = stmt.executeQuery();
		
		Renlifbiao user = null;
		while (rs.next()) {
			System.out.println("sdfadsfsdsafdsfasgasdfdsf");
			user = new Renlifbiao();
			user.setRenlifid(String.valueOf(rs.getInt("js_id")));
			//user.setGkfid(String.valueOf(rs.getInt("js_id")));//NewsID数据库中的键，把
			user.setRenliftitle(rs.getString("js_title"));
			user.setRenlifcontent(rs.getString("js_content"));

			renlifList.add(user);
		}
		
		con.close();
		return "biaorenlisuc";
	}

	public String getRenlifid() {
		return renlifid;
	}
	public void setRenlifid(String renlifid) {
		this.renlifid = renlifid;
	}
	public String getRenliftitle() {
		return renliftitle;
	}
	public void setRenliftitle(String renliftitle) {
		this.renliftitle = renliftitle;
	}
	public String getRenlifcontent() {
		return renlifcontent;
	}
	public void setRenlifcontent(String renlifcontent) {
		this.renlifcontent = renlifcontent;
	}
	public List getRenlifList() {
		return renlifList;
	}
	public void setRenlifList(List renlifList) {
		this.renlifList = renlifList;
	}
	
	
	
}
