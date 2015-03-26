package news.list;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class AllList extends ActionSupport {
	private String ddid;
	private String dttitle;
	private String dtdate;
	static Connection con;
	static String sql = "select dt_id, dt_title, dt_date from market_dongtai where dt_state = '1'";
	private static List<DongtaiList>  dtList = new ArrayList<DongtaiList>();
	
	private String newsid;
	private String newstitle;
	private String newsdate;
	static String sql2 = "select newsid, news_title, news_date from gongsi_news where news_state = '1'";
	private static List<NewsList>  newsList = new ArrayList<NewsList>();
	
	public static List Dongtai(){
		con = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		DongtaiList dt = null;
		int size = 0;
		
		try {
			dt = new DongtaiList();
	    	stmt=con.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while(rs.next()){
	    		System.out.println("copying...");
	    		
	    		dt.setDtid(rs.getString("dt_id"));
	    		dt.setDttitle(rs.getString("dt_title"));
	    		dt.setDtdate(rs.getString("dt_date"));
	    		
	    		dtList.add(dt);	    		
	    	}
	    	size = dtList.size();
	    	stmt.close();
		    rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbconn.closeConn(con);
		System.out.println("dongtai size is " + size);
		return dtList;
	}
	
	public static List News(){
		con = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		NewsList news = null;
		int size = 0;
		
		try {
			news = new NewsList();
	    	stmt=con.createStatement();
	    	rs = stmt.executeQuery(sql2);
	    	while(rs.next()){
	    		System.out.println("copying...");
	    		
	    		news.setNewsid(rs.getString("newid"));
	    		news.setNewstitle(rs.getString("news_title"));
	    		news.setNewsdate(rs.getString("news_date"));
	    		
	    		newsList.add(news);
	    	}
	    	size = newsList.size();
	    	stmt.close();
		    rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbconn.closeConn(con);
		System.out.println("news size is " + size);
		return newsList;
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

	public List<DongtaiList> getDtList() {
		return dtList;
	}

	public void setDtList(List<DongtaiList> dtList) {
		this.dtList = dtList;
	}

	public String getNewstitle() {
		return newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public String getNewsdate() {
		return newsdate;
	}

	public void setNewsdate(String newsdate) {
		this.newsdate = newsdate;
	}

	public List<NewsList> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsList> newsList) {
		this.newsList = newsList;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getNewsid() {
		return newsid;
	}

	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}
	
	
}
