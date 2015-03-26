package news.list;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class NewsList extends ActionSupport {
	private String newsid;
	private String newstitle;
	private String newsdate;
	private List<NewsList>  newsList = new ArrayList<NewsList>();
	Connection con;
	static String sql2 = "select newsid, news_title, news_date from gongsi_news where news_state = '1'";
	
	public String execute(){		
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
	    		news.setNewsid(rs.getString("newsid"));
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
		
		return "newssuc";
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

	public String getNewsid() {
		return newsid;
	}

	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}	
	
}
