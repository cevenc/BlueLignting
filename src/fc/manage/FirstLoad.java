package fc.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class FirstLoad extends ActionSupport {
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> session = actionContext.getSession();
	private String quyu = (String)session.get("quyu");
	private String fytype = (String)session.get("fytype");
	private String fyprice = (String)session.get("fyprice");
	private String fysquare = (String)session.get("fysquare");
	private String fytitle;
	private String jjrname;
	private String fyid;
	private String jjrid;
	private String message;
	String sql = "select * from fangyuan";
	Connection con;
	private List<Chaxun>  fangList = new ArrayList<Chaxun>();
	
	public String execute(){
		ActionContext actionContext = ActionContext.getContext(); 
	    Map<String, Object> session = actionContext.getSession(); 
	    session.put("quyu", quyu); 
	    session.put("fytype", fytype);
	    session.put("fyprice", fyprice);
	    session.put("fysquare", fysquare);
	    if(quyu == null && fytype == null && fyprice == null && fysquare == null){
	    	System.out.println("init session...");
	    }
	    
	    int sizetmp = this.getFang();
		String size = sizetmp + "";
		message = "共搜索到 " + size + " 条信息";
		System.out.println(message);
		
		dbconn.closeConn(con);
		return "flsuc";
	}
	
	public int getFang(){
		int size = 0;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Chaxun resul = null;
		con = dbconn.getConnection(); 
		System.out.println(sql);
		String sql2;
		System.out.println("searching...");
		
	    try {
	    	stmt=con.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while(rs.next()){
	    		sql2 = "select jjr_name from jingjiren where jjr_id = ";
	    		System.out.println("copying...");
	    		resul = new Chaxun();
	    		this.setFyid(rs.getString("fy_id"));
	    		this.setQuyu(rs.getString("chengqu"));
	    		this.setFytitle(rs.getString("fy_title"));
	    		this.setFytype(rs.getString("fy_type"));
	    		this.setFyprice(rs.getString("fy_money"));
	    		this.setFysquare(rs.getString("fy_square"));
	    		this.setJjrid(rs.getString("jjr_id"));
	    		
	    		sql2 += "'"+this.getJjrid()+"'";
	    		System.out.println(sql2);
	    		stmt = con.createStatement();
	    		rs2 = stmt.executeQuery(sql2);
	    		rs2.next();
	    		this.setJjrname(rs2.getString("jjr_name"));	
	    		System.out.println(rs2.getString("jjr_name"));
	    		
	    		resul.setFyid(rs.getString("fy_id"));
	    		resul.setQuyu(rs.getString("chengqu"));
	    		resul.setFytitle(rs.getString("fy_title"));
	    		resul.setFytype(rs.getString("fy_type"));
	    		resul.setFyprice(rs.getString("fy_money"));
	    		resul.setFysquare(rs.getString("fy_square"));
	    		resul.setJjrid(rs.getString("jjr_id"));
	    		resul.setJjrname(rs2.getString("jjr_name"));
	    		System.out.println("fyid is " + resul.getFyid());
	    		fangList.add(resul);
	    	}
	    	size = fangList.size();
	    	stmt.close();
	    	rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    System.out.println("end search");
		return size;
	}
	
	public String getQuyu() {
		return quyu;
	}
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	public String getFytype() {
		return fytype;
	}
	public void setFytype(String fytype) {
		this.fytype = fytype;
	}
	public String getFyprice() {
		return fyprice;
	}
	public void setFyprice(String fyprice) {
		this.fyprice = fyprice;
	}
	public String getFysquare() {
		return fysquare;
	}
	public void setFysquare(String fysquare) {
		this.fysquare = fysquare;
	}

	public String getFytitle() {
		return fytitle;
	}

	public void setFytitle(String fytitle) {
		this.fytitle = fytitle;
	}

	public String getJjrname() {
		return jjrname;
	}

	public void setJjrname(String jjrname) {
		this.jjrname = jjrname;
	}

	public String getFyid() {
		return fyid;
	}

	public void setFyid(String fyid) {
		this.fyid = fyid;
	}

	public String getJjrid() {
		return jjrid;
	}

	public void setJjrid(String jjrid) {
		this.jjrid = jjrid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Chaxun> getFangList() {
		return fangList;
	}

	public void setFangList(List<Chaxun> fangList) {
		this.fangList = fangList;
	}
	
}
