package fc.yy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fc.yy.YuserlAction;

import com.opensymphony.xwork2.ActionSupport;


import db.conn.dbconn;

public class YuserlAction  extends ActionSupport{
	Connection conn;
	private ArrayList<YuserlAction>  userList = new ArrayList<YuserlAction>();
	private String yyData;
	private String jingjiName;
	private String kehuName;
	private String kehuTel;
	private String kehuMail;
	private String jingjiTel;
	private String jingjiMail;
	private String fyTitle;
	private String khId;
	private String cuskhId;
	private String jjrId;
	private String busjjrId;
	private String fyId;
	private String yyState;
	private String yyAgree;
	private String yyId;
	private String message;
	
	
	public String execute(){
		
		System.out.println("execute...");
		int size = this.Search_data(khId);
		if(size == 0){
			message = "当前无信息！！";
			dbconn.closeConn(conn);
			return "userlist";
		}
		message = "hello";
		dbconn.closeConn(conn);
		return "userlist";
	}
	
	public int Search_data(String khId){
		int size = 0;
		Statement stmt = null;
		ResultSet rs = null;
		YuserlAction user = null;
		conn = dbconn.getConnection(); 	
		String sql = "SELECT  fangyuan.fy_title,yuyue.yy_date, yuyue.kh_id,yuyue.jjr_id,yuyue.yy_agree,jingjiren.jjr_phone, jingjiren.jjr_mail,jingjiren.jjr_name FROM yuyue left join jingjiren on jingjiren.jjr_id=yuyue.jjr_id left join fangyuan on fangyuan.fy_id=yuyue.fy_id where yuyue.kh_id = '"+khId+"' ;";
		//String sqlkehu = "SELECT kh_phone, kh_mail,kh_name FROM kehu where kh_id = '"+khId+"' ;";
		//String sqljjr = "SELECT jjr_phone, jjr_mail,jjr_name FROM jingjiren where jjr_id = '"+getJjrId()+"' ;";
		System.out.println("searching...");
		
	    try {
	    	stmt=conn.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while(rs.next()){
	    		System.out.println("copying...");
	    		user = new YuserlAction();
	    		user.setYyData(rs.getString("yuyue.yy_date"));
	    		this.setKhId(rs.getString(String.valueOf("yuyue.kh_id")));
	    		this.setJjrId(rs.getString(String.valueOf("yuyue.jjr_id")));
	    		user.setYyAgree(rs.getString("yuyue.yy_agree"));
	    		user.setJingjiName(rs.getString("jingjiren.jjr_name"));
 	    		user.setJingjiTel(rs.getString("jingjiren.jjr_phone"));
 	    		user.setJingjiMail(rs.getString("jingjiren.jjr_mail"));
 	    		user.setFyTitle(rs.getString("fangyuan.fy_title"));
	    		System.out.println("agree"+user.getYyAgree());
	    		System.out.println("asd"+user.getJingjiMail());
	    		System.out.println("asd"+user.getJingjiTel());
	    		System.out.println("asd"+user.getJingjiName());
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
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getYyData() {
		return yyData;
	}
	public void setYyData(String yyData) {
		this.yyData = yyData;
	}
	public String getJingjiName() {
		return jingjiName;
	}
	public void setJingjiName(String jingjiName) {
		this.jingjiName = jingjiName;
	}
	public String getKehuName() {
		return kehuName;
	}
	public void setKehuName(String kehuName) {
		this.kehuName = kehuName;
	}
	public String getKehuTel() {
		return kehuTel;
	}
	public void setKehuTel(String kehuTel) {
		this.kehuTel = kehuTel;
	}
	public String getKehuMail() {
		return kehuMail;
	}
	public void setKehuMail(String kehuMail) {
		this.kehuMail = kehuMail;
	}
	public String getJingjiTel() {
		return jingjiTel;
	}
	public void setJingjiTel(String jingjiTel) {
		this.jingjiTel = jingjiTel;
	}
	public String getJingjiMail() {
		return jingjiMail;
	}
	public void setJingjiMail(String jingjiMail) {
		this.jingjiMail = jingjiMail;
	}
	public String getFyTitle() {
		return fyTitle;
	}
	public void setFyTitle(String fyTitle) {
		this.fyTitle = fyTitle;
	}
	public String getKhId() {
		return khId;
	}
	public void setKhId(String khId) {
		this.khId = khId;
	}
	public String getCuskhId() {
		return cuskhId;
	}
	public void setCuskhId(String cuskhId) {
		this.cuskhId = cuskhId;
	}
	public String getJjrId() {
		return jjrId;
	}
	public void setJjrId(String jjrId) {
		this.jjrId = jjrId;
	}
	public String getBusjjrId() {
		return busjjrId;
	}
	public void setBusjjrId(String busjjrId) {
		this.busjjrId = busjjrId;
	}
	public String getFyId() {
		return fyId;
	}
	public void setFyId(String fyId) {
		this.fyId = fyId;
	}
	public String getYyState() {
		return yyState;
	}
	public void setYyState(String yyState) {
		this.yyState = yyState;
	}
	public String getYyAgree() {
		return yyAgree;
	}
	public void setYyAgree(String yyAgree) {
		this.yyAgree = yyAgree;
	}
	public void setYyId(String yyId) {
		this.yyId = yyId;
	}
	public String getYyId() {
		return yyId;
	}
	public List<YuserlAction> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<YuserlAction> userList) {
		this.userList = userList;
	}
	}


