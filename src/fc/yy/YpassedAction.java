package fc.yy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class YpassedAction extends ActionSupport {
	private static final long serialVersionUID = 100000070000000L;
	private String  edityySql = "update yuyue set yy_agree = ? where yy_id = ?";
	private String yyId;
	private String jjrId;
	private String yyAgree; 
	
	Connection con = dbconn.getConnection();
	private List  userList = new ArrayList();

	public String execute() throws  Exception {
		PreparedStatement  stmt = con.prepareStatement(edityySql);
		stmt.setString(1,String.valueOf(1));
		stmt.setString(2,yyId);
		
		stmt.executeUpdate();
		return "passeds";
	}

	public String getYyId() {
		return yyId;
	}

	public void setYyId(String yyId) {
		this.yyId = yyId;
	}

	public String getYyAgree() {
		return yyAgree;
	}

	public void setYyAgree(String yyAgree) {
		this.yyAgree = yyAgree;
	}

	public void setJjrId(String jjrId) {
		this.jjrId = jjrId;
	}

	public String getJjrId() {
		return jjrId;
	}

	


	
	
}