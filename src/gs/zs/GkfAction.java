package gs.zs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class GkfAction extends ActionSupport {
	private String  editgkfSql = "update qiye_jieshao set js_content=? where js_id = ?";
	private String gkfid = "1";
	
	private String gkfcontent;
	private List  gkfList = new ArrayList();
	Connection con = dbconn.getConnection();
	
	public String execute() throws  Exception {
		System.out.println("in here");
		PreparedStatement  stmt = con.prepareStatement(editgkfSql);
		
		stmt.setString(1,gkfcontent);
		stmt.setInt(2,Integer.parseInt(gkfid));
		stmt.executeUpdate();
		return "qwerty";
	}

	
	
	public String getGkfid() {
		return gkfid;
	}
	public void setGkfid(String gkfid) {
		this.gkfid = gkfid;
	}
	
	public String getGkfcontent() {
		return gkfcontent;
	}
	public void setGkfcontent(String gkfcontent) {
		this.gkfcontent = gkfcontent;
	}



	public List getGkfList() {
		return gkfList;
	}



	public void setGkfList(List gkfList) {
		this.gkfList = gkfList;
	}
	
	
}
