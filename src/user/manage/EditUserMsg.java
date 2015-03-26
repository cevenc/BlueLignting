package user.manage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class EditUserMsg extends ActionSupport {
	private String userid;
	private String username;
	private String account;
	private String password;
	private String phone;
	private String mail;
	Connection con;
	
	public String execute(){
		int flag = 0;
		flag = this.registin(username, account, password, phone, mail);
		System.out.println("executeing...");
		if(flag == 1){
			System.out.println("±à¼­³É¹¦!!!");
			dbconn.closeConn(con);
			return "editsuc";
		}
		System.out.println("±à¼­Ê§°Ü!!!");
		dbconn.closeConn(con);
		return "editfal";
	}
	
	public int registin(String username, String account, String password, String phonem, String mail){
		int flag = 0;
		Statement stmt = null;
		con = dbconn.getConnection();
		String sql = "UPDATE kehu SET `kh_name`='"+username+"', `kh_account`='"+account+"', `kh_pwd`='"+password+"', `kh_phone`='"+phone+"', `kh_mail`='"+mail+"' WHERE `kh_id`='"+userid+"';";
		//String sql = "DELETE FROM customers WHERE `kh_id`='8'";
	    try {
	    	stmt=con.createStatement();
	    	stmt.executeUpdate(sql);
	    	flag = 1;			    
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return flag;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}
