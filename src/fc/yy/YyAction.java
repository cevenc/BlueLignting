package fc.yy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class YyAction extends ActionSupport{
	private String fyid;
	private String userid;
	private String jjrid;	
	private String message;
	Connection con;	
	
	public String execute(){
		
		Date d = new Date(); 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=(String)sdf.format(d); 
		
		Statement stmt = null;
		con = dbconn.getConnection(); 		
		String sql = "INSERT INTO yuyue(`kh_id`, `jjr_id`, `fy_id`, `yy_date`, `yy_read`,`yy_agree`)" +
				" VALUES ('"+userid+"', '"+jjrid+"', '"+fyid+"', '"+str+"', '0','0')";
		
	    try {
	    	stmt=con.createStatement();
	    	stmt.executeUpdate(sql);
	    	System.out.println("预约成功！！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
		dbconn.closeConn(con);
		message = "预约成功！！";
		return "yysuc";
	}
	
	public String getFyid() {
		return fyid;
	}

	public void setFyid(String fyid) {
		this.fyid = fyid;
	}

	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getJjrid() {
		return jjrid;
	}

	public void setJjrid(String jjrid) {
		this.jjrid = jjrid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
