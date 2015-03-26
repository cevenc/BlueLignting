package gs.zs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class RenlifAction extends ActionSupport {
	private String  editrenlifSql = "update qiye_jieshao set js_content=? where js_id = ?";
	private String renlifid = "3";
	
	private String renlifcontent;
	private List  renlifList = new ArrayList();
	Connection con = dbconn.getConnection();
	
	public String execute() throws  Exception {
		PreparedStatement  stmt = con.prepareStatement(editrenlifSql);
		
		stmt.setString(1,renlifcontent);
		stmt.setInt(2,Integer.parseInt(renlifid));
		stmt.executeUpdate();
		return "qazwsxedc";
	}

	
	
	public String getRenlifid() {
		return renlifid;
	}
	public void setRenlifid(String renlifid) {
		this.renlifid = renlifid;
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
