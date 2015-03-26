package gs.zs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;



import com.opensymphony.xwork2.ActionSupport;


public class NewsAction  extends ActionSupport{
	private String  getnewsById ="select News_title,News_date,News_laiyuan,News_content from gongsi_news where NewsID=?";
	private String newsLy;
	private String newsTitle; 
	private String newsDate;
	private String newsContent;
	
	private String newsId;
	private List  newsList = new ArrayList();
	Connection con = dbconn.getConnection();
	public String execute()throws Exception{
		PreparedStatement  stmt = con.prepareStatement(this.getnewsById);
		stmt.setInt(1,Integer.parseInt(newsId));
		ResultSet rs = stmt.executeQuery();
		
		NewsAction news = null;
		while (rs.next()) {
			System.out.println("sdfadsdsdsffsdsafdsfasgasdfdsf");
			news = new NewsAction();
			
			this.setNewsTitle(rs.getString("News_title"));
			this.setNewsContent(rs.getString("News_content"));
			this.setNewsDate(rs.getString("News_date"));
			
			this.setNewsLy(rs.getString("News_laiyuan"));
			
			newsList.add(news);
		}
		
		con.close();
		return "news";
	}
	public String getGetnewsById() {
		return getnewsById;
	}
	public void setGetnewsById(String getnewsById) {
		this.getnewsById = getnewsById;
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
	public String getNewsId() {
		return newsId;
	}
	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	public List getNewsList() {
		return newsList;
	}
	public void setNewsList(List newsList) {
		this.newsList = newsList;
	}
	
}
