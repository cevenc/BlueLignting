package news.list;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class NewsAndDongtai extends ActionSupport {
	private String newstitle;
	private String newsdate;
	private List<NewsList>  newsList = new ArrayList<NewsList>();
	private List<DongtaiList>  dtList = new ArrayList<DongtaiList>();
	
	public String execute(){		
		dtList = AllList.Dongtai();
		newsList = AllList.News();
		
		return "listsuc";
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

	public List<DongtaiList> getDtList() {
		return dtList;
	}

	public void setDtList(List<DongtaiList> dtList) {
		this.dtList = dtList;
	}
}
