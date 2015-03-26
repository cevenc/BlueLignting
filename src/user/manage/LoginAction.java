package user.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class LoginAction extends ActionSupport {
	private String account;
	private String password;
	private String message;
	private String userid;
	private String username;
	private String identity;
	Connection con;
	
	public String execute(){
		//�ж��˺Ż������Ƿ�Ϊ��
		if(account.equals("")){
			message = "�˺Ų���Ϊ�գ���";
			return "logfalse";
		}else if(password.equals("")){
			message = "���벻��Ϊ�գ���";
			return "logfalse";
		}
		
		int flag = 0;
		flag = this.Login(account, password);//��֤�˺�������
		System.out.println("executeing...");
		if(flag == 1){
			identity = "1";
			ActionContext actionContext = ActionContext.getContext(); 
		    Map<String, Object> session = actionContext.getSession(); 
		    session.put("username", username); 
		    session.put("userid", userid);
		    session.put("identity", identity);
		    
			System.out.println("��½�ɹ�������");
			dbconn.closeConn(con);
			return "logsuccess";
		}
		if(message.equals("���û������ڣ���")){
			System.out.println("��½ʧ�ܣ�����");
			dbconn.closeConn(con);
			return "logfalse";
		}
		System.out.println("��½ʧ�ܣ�����");
		dbconn.closeConn(con);
		return "logfalse";
	}
	
	public int Login(String account, String password){
		int flag = 0;
		int flag2 = 0;
		Statement stmt = null;
		ResultSet rs = null;
		con = dbconn.getConnection();
		String sql = "select kh_id,kh_name from kehu where kh_account= '" + account + "' and kh_pwd= '" + password + "'";
		flag2 = checkAccount(account, con);
		if(flag2 == 0){
			message = "���û������ڣ���";
			return flag;
		}
		
	    try {
	    	stmt=con.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	if(rs.next()){
	    		userid = rs.getString("kh_id");
	    		username = rs.getString("kh_name");
	    		flag = 1;
	    	}
	    	stmt.close();
		    rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    message = "������󣡣�";
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

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
}
