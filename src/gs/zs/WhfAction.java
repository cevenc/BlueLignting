package gs.zs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class WhfAction extends ActionSupport {
	private String  editwhfSql = "update qiye_jieshao set js_content=? where js_id = ?";
	private String whfid = "2";
	
	private String whfcontent;
	private List  whfList = new ArrayList();
	Connection con = dbconn.getConnection();
	
	public String execute() throws  Exception {
		PreparedStatement  stmt = con.prepareStatement(editwhfSql);
		
		stmt.setString(1,whfcontent);
		stmt.setInt(2,Integer.parseInt(whfid));
		stmt.executeUpdate();
		return "asdfgh";
	}

	
	
	public String getWhfid() {
		return whfid;
	}
	public void setWhfid(String whfid) {
		this.whfid = whfid;
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