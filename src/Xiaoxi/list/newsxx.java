package Xiaoxi.list;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class newsxx extends ActionSupport {
	private String newsid;
	private String newsLy;
	private String newsTitle; 
	private String newsDate;
	private String newsContent;
	Connection con;
	
	public String execute(){
		
		con = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from gongsi_news where newsid = '"+newsid+"'";
		
		try {
	    	stmt=con.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	if(rs.next()){
	    		System.out.println("copying...");
	    		this.setNewsid(rs.getString("newsid"));
	    		this.setNewsDate(rs.getString("news_date"));
	    		this.setNewsContent(rs.getString("news_content"));
	    		this.setNewsLy(rs.getString("news_content"));
	    		this.setNewsTitle(rs.getString("news_title"));
 		
	    	}
	    	stmt.close();
		    rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbconn.closeConn(con);
		return "newssuc";
	}

	
	
	public String getNewsid() {
		return newsid;
	}



	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}



	public String getNewsLy() {
		return newsLy;
	}

	public void setNewsLy(String newsLy) {
		this.newsLy = newsLy;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	
}

