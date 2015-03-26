package fc.yy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class SendFangMsg extends ActionSupport {
	private String fyid;
	private String fytitle;
	private String fyprice;
	private String fysquare;
	private String fyxq;
	private String jjrid;
	private String jjrphone;
	private String fang;
	private String ting;
	
	public String execute(){
		Connection con = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Statement stmt2 = null;
		ResultSet rs2 = null;
		String sql = "select * from fangyuan where fy_id= '" + fyid + "'";
		
		try {
	    	stmt=con.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	if(rs.next()){
	    		System.out.println("load fang message");
	    		this.setFytitle(rs.getString("fy_title"));
	    		this.setFyprice(rs.getString("fy_money"));
	    		this.setFysquare(rs.getString("fy_square"));
	    		this.setFyid(rs.getString("fy_id"));
	    		this.setFyxq(rs.getString("fy_xq"));
	    		this.setJjrid(rs.getString("jjr_id"));
	    		this.setFang(rs.getString("fy_fang"));
	    		this.setTing(rs.getString("fy_ting"));
	    	}
	    	
	    	String sql2 = "select jjr_phone from jingjiren where jjr_id= '" + jjrid + "'";
	    	rs = stmt.executeQuery(sql2);
	    	if(rs.next()){
	    		System.out.println("load jjr message");
	    		this.setJjrphone(rs.getString("jjr_phone"));
	    	}
	    	stmt.close();
		    rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbconn.closeConn(con);
		return "sendsuc";
	}
	
	
	
	public String getFang() {
		return fang;
	}



	public void setFang(String fang) {
		this.fang = fang;
	}



	public String getTing() {
		return ting;
	}



	public void setTing(String ting) {
		this.ting = ting;
	}



	public String getFytitle() {
		return fytitle;
	}

	public void setFytitle(String fytitle) {
		this.fytitle = fytitle;
	}


	public String getFyid() {
		return fyid;
	}

	public void setFyid(String fyid) {
		this.fyid = fyid;
	}

	public String getFyprice() {
		return fyprice;
	}

	public void setFyprice(String fyprice) {
		this.fyprice = fyprice;
	}

	public String getFysquare() {
		return fysquare;
	}

	public void setFysquare(String fysquare) {
		this.fysquare = fysquare;
	}

	public String getJjrid() {
		return jjrid;
	}

	public void setJjrid(String jjrid) {
		this.jjrid = jjrid;
	}


	public String getJjrphone() {
		return jjrphone;
	}


	public void setJjrphone(String jjrphone) {
		this.jjrphone = jjrphone;
	}


	public String getFyxq() {
		return fyxq;
	}


	public void setFyxq(String fyxq) {
		this.fyxq = fyxq;
	}
	
	
}
