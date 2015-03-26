package Xiaoxi.list;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import news.list.DongtaiList;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class Dtxx extends ActionSupport {
	private String dtid;
	private String dttitle;
	private String dtdate;
	private String dtly;
	private String dtcon;
	Connection con;
	
	public String execute(){
		con = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from market_dongtai where dt_id = '"+dtid+"'";
		System.out.println("dtid is" + dtid);
		
		try {
	    	stmt=con.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	if(rs.next()){
	    		System.out.println("copying...");
	    		this.setDtid(rs.getString("dt_id"));
	    		this.setDttitle(rs.getString("dt_title"));
	    		this.setDtdate(rs.getString("dt_date"));
	    		this.setDtly(rs.getString("dt_laiyuan"));
	    		this.setDtcon(rs.getString("dt_content"));
 		
	    	}
	    	stmt.close();
		    rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbconn.closeConn(con);
		return "dtsuc";
	}

	public String getDtid() {
		return dtid;
	}

	public void setDtid(String dtid) {
		this.dtid = dtid;
	}

	public String getDttitle() {
		return dttitle;
	}

	public void setDttitle(String dttitle) {
		this.dttitle = dttitle;
	}

	public String getDtdate() {
		return dtdate;
	}

	public void setDtdate(String dtdate) {
		this.dtdate = dtdate;
	}

	public String getDtly() {
		return dtly;
	}

	public void setDtly(String dtly) {
		this.dtly = dtly;
	}

	public String getDtcon() {
		return dtcon;
	}

	public void setDtcon(String dtcon) {
		this.dtcon = dtcon;
	}

	
}
