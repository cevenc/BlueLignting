package news.list;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class zxnewsAction  extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection conn;
	private String zxTitle;
	private String zxDate;
	private String zxType;
	private String zxContent;
	private Boolean zxState=true;
	private String zxId;
	
	private ArrayList<zxnewsAction>  userList = new ArrayList<zxnewsAction>();
	public String execute(){
		
		System.out.println("execute...");
		int size = this.Search_data(zxState);
		if(size == 0){
			dbconn.closeConn(conn);
			return "zxlist";
		}
		dbconn.closeConn(conn);
		return "zxlist";
	}
public int Search_data(Boolean zxState){
	int size = 0;
	Statement stmt = null;
	ResultSet rs = null;
	zxnewsAction user = null;
	conn = dbconn.getConnection(); 	
	String sql = "SELECT  zx_ID, zx_type, zx_title, zx_date, zx_content, zx_state from fangchan_msg where zx_state=true;";
	//String sqlkehu = "SELECT kh_phone, kh_mail,kh_name FROM kehu where kh_id = '"+khId+"' ;";
	//String sqljjr = "SELECT jjr_phone, jjr_mail,jjr_name FROM jingjiren where jjr_id = '"+getJjrId()+"' ;";
	System.out.println("searching...");
	
    try {
    	stmt=conn.createStatement();
    	rs = stmt.executeQuery(sql);
    	while(rs.next()){
    		System.out.println("copying...");
    		user = new zxnewsAction();
    		user.setZxTitle(rs.getString("zx_title"));
    		user.setZxDate(rs.getString("zx_date"));
    		user.setZxType(rs.getString("zx_type"));
    		
    		user.setZxContent(rs.getString("zx_content"));
	    	user.setZxId(rs.getString(String.valueOf("zx_ID")));
	    	
    		System.out.println("agree"+user.getZxId());
    		
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
public String getZxTitle() {
	return zxTitle;
}
public void setZxTitle(String zxTitle) {
	this.zxTitle = zxTitle;
}
public String getZxDate() {
	return zxDate;
}
public void setZxDate(String zxDate) {
	this.zxDate = zxDate;
}
public String getZxContent() {
	return zxContent;
}
public void setZxContent(String zxContent) {
	this.zxContent = zxContent;
}
public String getZxId() {
	return zxId;
}
public void setZxId(String zxId) {
	this.zxId = zxId;
}
public ArrayList<zxnewsAction> getUserList() {
	return userList;
}
public void setUserList(ArrayList<zxnewsAction> userList) {
	this.userList = userList;
}
public Boolean getZxState() {
	return zxState;
}
public void setZxState(Boolean zxState) {
	this.zxState = zxState;
}
public void setZxType(String zxType) {
	this.zxType = zxType;
}
public String getZxType() {
	return zxType;
}

}
