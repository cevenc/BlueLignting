package news.list;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class gsnewsAction  extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection conn;
	private String newsTitle;
	private String newsDate;
	private String newsLy;
	private String newsContent;
	private Boolean newsState=true;
	private String newsId;
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
	public String getNewsLy() {
		return newsLy;
	}
	public void setNewsLy(String newsLy) {
		this.newsLy = newsLy;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	
	public Boolean getNewsState() {
		return newsState;
	}
	public void setNewsState(Boolean newsState) {
		this.newsState = newsState;
	}
	public ArrayList<gsnewsAction> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<gsnewsAction> userList) {
		this.userList = userList;
	}
	public String getNewsId() {
		return newsId;
	}
	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	private ArrayList<gsnewsAction>  userList = new ArrayList<gsnewsAction>();
	public String execute(){
		
		System.out.println("execute...");
		int size = this.Search_data(newsState);
		if(size == 0){
			dbconn.closeConn(conn);
			return "newslist";
		}
		dbconn.closeConn(conn);
		return "newslist";
	}
public int Search_data(Boolean newsState){
	int size = 0;
	Statement stmt = null;
	ResultSet rs = null;
	gsnewsAction user = null;
	conn = dbconn.getConnection(); 	
	String sql = "SELECT  NewsID,News_title, News_date, News_laiyuan, News_content, News_state from gongsi_news where News_state=true;";
	//String sqlkehu = "SELECT kh_phone, kh_mail,kh_name FROM kehu where kh_id = '"+khId+"' ;";
	//String sqljjr = "SELECT jjr_phone, jjr_mail,jjr_name FROM jingjiren where jjr_id = '"+getJjrId()+"' ;";
	System.out.println("searching...");
	
    try {
    	stmt=conn.createStatement();
    	rs = stmt.executeQuery(sql);
    	while(rs.next()){
    		System.out.println("copying...");
    		user = new gsnewsAction();
    		user.setNewsTitle(rs.getString("News_title"));
    		user.setNewsDate(rs.getString("News_date"));
    		user.setNewsLy(rs.getString("News_laiyuan"));
    		user.setNewsContent(rs.getString("News_content"));
	    	user.setNewsId(rs.getString(String.valueOf("NewsID")));
	    	
    		System.out.println("agree"+user.getNewsId());
    		
    		userList.add(user);
    	}
    	stmt.close();
    	rs.close();
    	size = userList.size();
	} catch (SQLException e) {
		e.printStackTrace();
	}
    	 
    System.out.println("end search");
    return size;
    }

}
