package fc.zx;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class ZhuanjiaAction extends ActionSupport {
	private String Zjtitle;
	private String type;//ר������
	private String zym;//��ҳ��content
	private String message;
	Connection con;

	public String execute(){//ֻ�õ��������֣�һ�������Ӧһ��TodayfAction
		Date d = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=(String)sdf.format(d); 
		System.out.println("The date is : " + str); 
		int flag = this.daoru(Zjtitle,type,zym,str);
		if(flag == 0){
			System.out.println("Ŀǰ" + Zjtitle + "������!!!");
			dbconn.closeConn(con);
			return "addfal";
		}
		message = "����ɹ�";
		System.out.println("����" + Zjtitle + "���Ժ�����!!!");
		dbconn.closeConn(con);
		return "addsuc";
	}
	
	public int daoru(String Zjtitle, String type, String zym, String str){		
		int flag = 0;
		Statement stmt = null;
		con = dbconn.getConnection(); 		
		String sql = "INSERT INTO fangchan_msg (`zx_type`, `zx_title`, `zx_date`, `zx_content`, `zx_state`) VALUES ('"+type+"', '"+Zjtitle+"', '"+str+"', '"+zym+"', '1');";
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
	
	public String getZjtitle() {
		return Zjtitle;
	}
	public void setZjtitle(String zjtitle) {
		Zjtitle = zjtitle;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getZym() {
		return zym;
	}
	public void setZym(String zym) {
		this.zym = zym;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
