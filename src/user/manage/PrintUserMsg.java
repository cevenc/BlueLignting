package user.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class PrintUserMsg extends ActionSupport {
	private String userid;
	private String account;
	private String password;
	private String username;
	private String phone;
	private String mail;
	
	public String execute(){
		Connection con = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select kh_name, kh_account, kh_pwd, kh_phone, kh_mail from kehu where kh_id= '" + userid + "'";
		try {
	    	stmt=con.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	if(rs.next()){
	    		System.out.println("load user message");
	    		this.setUsername(rs.getString("kh_name"));
	    		this.setAccount(rs.getString("kh_account"));
	    		this.setPassword(rs.getString("kh_pwd"));
	    		this.setPhone(rs.getString("kh_phone"));
	    		this.setMail(rs.getString("kh_mail"));
	    	}
	    	stmt.close();
		    rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "printsuc";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
