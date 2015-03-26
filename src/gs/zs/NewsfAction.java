package gs.zs;

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

public class NewsfAction extends ActionSupport {
	

	private String newsftitle;
	private String newsfcontent;
	
	private String newsdate;
	private String newsstate="1";
	
	private List  newsfList = new ArrayList();
	Connection con = dbconn.getConnection();
	
	public String execute() throws  Exception {
		Date d = new Date(); 
		//String str = d.toString(); 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=(String)sdf.format(d); 
		this.newsdate=str;
		System.out.println("The date is : " + str); 
		int flag = 0;
		flag = this.newsf(newsfcontent,newsftitle,newsdate,newsstate);
		System.out.println("executeing...");
		if(flag == 1){
			System.out.println("发表成功");
			dbconn.closeConn(con);
			return "fabiaos";
		}
		System.out.println("发表失败!!!");
		dbconn.closeConn(con);
		return "fabiaos";
	}
	public int newsf(String newsfcontent, String newsftitle, String newsdate,String newsstate ){
		int flag = 0;
		Statement stmt = null;
		con = dbconn.getConnection(); 		
		String sql = "INSERT INTO gongsi_news( `News_title`, `News_date`,  `News_content`, `News_state`)" +
				" VALUES ( '"+newsftitle+"', '"+newsdate+"', '"+newsfcontent+"', '"+newsstate+"')";
		
	    try {
	    	stmt=con.createStatement();
	    	stmt.executeUpdate(sql);
	    	flag = 1;			    
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return flag;
	}
	
	
	
	public String getNewsftitle() {
		return newsftitle;
	}
	public void setNewsftitle(String newsftitle) {
		this.newsftitle = newsftitle;
	}
	public String getNewsfcontent() {
		return newsfcontent;
	}
	public void setNewsfcontent(String newsfcontent) {
		this.newsfcontent = newsfcontent;
	}



	public List getNewsfList() {
		return newsfList;
	}



	public void setNewsfList(List newsfList) {
		this.newsfList = newsfList;
	}
	
	
	
	public String getNewsstate() {
		return newsstate;
	}
	public void setNewsstate(String newsstate) {
		this.newsstate = newsstate;
	}
	public String getNewsdate() {
		return newsdate;
	}
	public void setNewsdate(String newsdate) {
		this.newsdate = newsdate;
	}
	
	
	
}
