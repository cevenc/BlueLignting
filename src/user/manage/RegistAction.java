package user.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class RegistAction extends ActionSupport {
	private String username;
	private String account;
	private String password;
	private String phone;
	private String mail;
	private String message;
	Connection con;
	
	public String execute(){
		int flag = 0;
		flag = this.registin(username, account, password, phone, mail);
		System.out.println("executeing...");
		if(flag == 1){
			message = "注册成功!!!";
			System.out.println("注册成功!!!");
			dbconn.closeConn(con);
			return "regsuccess";
		}
		message = "该账号已存在!!!";
		System.out.println("该账号已存在!!!");
		dbconn.closeConn(con);
		return "regfalse";
	}
	
	public int registin(String username, String account, String password, String phonem, String mail){
		int flag = 0;
		Statement stmt = null;
		con = dbconn.getConnection();
		String sql = "INSERT INTO kehu(`kh_name`, `kh_account`, `kh_pwd`, `kh_phone`, `kh_mail`)" +
				" VALUES ('"+username+"', '"+account+"', '"+password+"', '"+phone+"', '"+mail+"');";
		//String sql = "DELETE FROM customers WHERE `kh_id`='8'";
		int flag2 = this.checkAccount(account, con);
		if(flag2 == 1){
			return flag;
		}
	    try {
	    	stmt=con.createStatement();
	    	stmt.executeUpdate(sql);
	    	flag = 1;			    
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return flag;
	}
	
	public int checkAccount(String account, Connection con){
		int flag = 0;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select kh_account from kehu where kh_account= '" + account + "'";
		
		 try {
		    	stmt=con.createStatement();
		    	rs = stmt.executeQuery(sql);
		    	if(rs.next()){
		    		flag = 1;
		    	}
		    	stmt.close();
			    rs.close();
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	
}
