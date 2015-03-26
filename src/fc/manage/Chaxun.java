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

public class Chaxun extends ActionSupport {
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
	Connection con;
    
	private List<Chaxun>  fangList = new ArrayList<Chaxun>();
	String sql = "select * from fangyuan where fy_state = '1'";
	
	public String execute(){
		
		System.out.println(quyu);
		System.out.println(fyprice);		
		System.out.println(fytype);
		System.out.println(fysquare);
		System.out.println("right??");
		
		this.setsqlagain();
		int sizetmp = this.getFang();
		String size = sizetmp + "";
		message = "共搜索到 " + size + " 条信息";
		System.out.println(message);
	    
		dbconn.closeConn(con);
		return "ChaxunSuc";
	}
	
	public void setsqlagain(){
		System.out.println("here");
		if(!(quyu == null)){
			session.put("quyu", quyu);
			if(!sql.equals("select * from fangyuan where ")){
				if(quyu.equals("1")){
					sql += " and chengqu = '城东'";
				}else if(quyu.equals("2")){
					sql += " and chengqu = '城南'";
				}else if(quyu.equals("3")){
					sql += " and chengqu = '城西'";
				}else if(quyu.equals("4")){
					sql += " and chengqu = '城北'";
				}
			}else{
				if(quyu.equals("1")){
					sql += " chengqu = '城东'";
				}else if(quyu.equals("2")){
					sql += " chengqu = '城南'";
				}else if(quyu.equals("3")){
					sql += " chengqu = '城西'";
				}else if(quyu.equals("4")){
					sql += " chengqu = '城北'";
				}
			}
		}
		if(!(fytype == null)){
			session.put("fytype", fytype);
			if(!sql.equals("select * from fangyuan where ")){
				if(fytype.equals("1")){
					sql += " and fy_type = '一室'";
				}else if(fytype.equals("2")){
					sql += " and fy_type = '二室'";
				}else if(fytype.equals("3")){
					sql += " and fy_type = '三室'";
				}else if(fytype.equals("4")){
					sql += " and fy_type = '四室'";
				}
			}else{
				if(fytype.equals("1")){
					sql += " fy_type = '一室'";
				}else if(fytype.equals("2")){
					sql += " fy_type = '二室'";
				}else if(fytype.equals("3")){
					sql += " fy_type = '三室'";
				}else if(fytype.equals("4")){
					sql += " fy_type = '四室'";
				}
			}
		}
		if(!(fyprice == null)){
			session.put("fyprice", fyprice);
			if(!sql.equals("select * from fangyuan where ")){
				if(fyprice.equals("1")){
					sql += " and fy_money < 40";
				}else if(fyprice.equals("2")){
					sql += " and fy_money > 40 and fy_money < 80";
				}else if(fyprice.equals("3")){
					sql += " and fy_money > 80 and fy_money < 120";
				}else if(fyprice.equals("4")){
					sql += " and fy_money > 120";
				}
			}else{
				if(fyprice.equals("1")){
					sql += " fy_money < 40";
				}else if(fyprice.equals("2")){
					sql += " fy_money > 40 and fy_money < 80";
				}else if(fyprice.equals("3")){
					sql += " fy_money > 80 and fy_money < 120";
				}else if(fyprice.equals("4")){
					sql += " fy_money > 120";
				}
			}
		}
		if(!(fysquare == null)){
			session.put("fysquare", fysquare);
			if(!sql.equals("select * from fangyuan where ")){
				if(fysquare.equals("1")){
					sql += " and fy_square < 50";
				}else if(fysquare.equals("2")){
					sql += " and fy_square > 50 and fy_square < 70";
				}else if(fysquare.equals("3")){
					sql += " and fy_square > 70 and fy_square < 90";
				}else if(fysquare.equals("4")){
					sql += " and fy_square > 90";
				}
			}else{
				if(fysquare.equals("1")){
					sql += " fy_square < 50";
				}else if(fysquare.equals("2")){
					sql += " fy_square > 50 and fy_square < 70";
				}else if(fysquare.equals("3")){
					sql += " fy_square > 70 and fy_square < 90";
				}else if(fysquare.equals("4")){
					sql += " fy_square > 90";
				}
			}
		}
		return ;
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
	
	public void setsql2(){
		if(quyu.equals("0") && fyprice.equals("0") && fysquare.equals("0") && fytype.equals("0") ){
			session.put("quyu", "0");
			session.put("fyprice", "0");
			session.put("fysquare", "0");
			session.put("fytype", "0");
			sql = "select * from fangyuan";
		}
		if(quyu.equals("0")){
			session.put("quyu", "0");
			quyu = null;
		}
		if(fyprice.equals("0")){
			session.put("fyprice", "0");
			fyprice = null;
		}
		if(fysquare.equals("0")){
			session.put("fysquare", "0");
			fysquare = null;
		}
		if(fytype.equals("0")){
			session.put("fytype", "0");
			fytype = null;
		}
		if(!(quyu == null)){
			session.put("quyu", quyu);
			if(!sql.equals("select * from fangyuan where ")){
				if(quyu.equals("1")){
					sql += " and chengqu = '城东'";
				}else if(quyu.equals("2")){
					sql += " and chengqu = '城南'";
				}else if(quyu.equals("3")){
					sql += " and chengqu = '城西'";
				}else if(quyu.equals("4")){
					sql += " and chengqu = '城北'";
				}
			}else{
				if(quyu.equals("1")){
					sql += " chengqu = '城东'";
				}else if(quyu.equals("2")){
					sql += " chengqu = '城南'";
				}else if(quyu.equals("3")){
					sql += " chengqu = '城西'";
				}else if(quyu.equals("4")){
					sql += " chengqu = '城北'";
				}
			}
		}
		if(!(fytype == null)){
			session.put("fytype", fytype);
			if(!sql.equals("select * from fangyuan where ")){
				if(fytype.equals("1")){
					sql += " and fy_type = '一室'";
				}else if(fytype.equals("2")){
					sql += " and fy_type = '二室'";
				}else if(fytype.equals("3")){
					sql += " and fy_type = '三室'";
				}else if(fytype.equals("4")){
					sql += " and fy_type = '四室'";
				}
			}else{
				if(fytype.equals("1")){
					sql += " fy_type = '一室'";
				}else if(fytype.equals("2")){
					sql += " fy_type = '二室'";
				}else if(fytype.equals("3")){
					sql += " fy_type = '三室'";
				}else if(fytype.equals("4")){
					sql += " fy_type = '四室'";
				}
			}
		}
		if(!(fyprice == null)){
			session.put("fyprice", fyprice);
			if(!sql.equals("select * from fangyuan where ")){
				if(fyprice.equals("1")){
					sql += " and fy_money < 40";
				}else if(fyprice.equals("2")){
					sql += " and fy_money > 40 and fy_money < 80";
				}else if(fyprice.equals("3")){
					sql += " and fy_money > 80 and fy_money < 120";
				}else if(fyprice.equals("4")){
					sql += " and fy_money > 120";
				}
			}else{
				if(fyprice.equals("1")){
					sql += " fy_money < 40";
				}else if(fyprice.equals("2")){
					sql += " fy_money > 40 and fy_money < 80";
				}else if(fyprice.equals("3")){
					sql += " fy_money > 80 and fy_money < 120";
				}else if(fyprice.equals("4")){
					sql += " fy_money > 120";
				}
			}
		}
		if(!(fysquare == null)){
			session.put("fysquare", fysquare);
			if(!sql.equals("select * from fangyuan where ")){
				if(fysquare.equals("1")){
					sql += " and fy_square < 50";
				}else if(fysquare.equals("2")){
					sql += " and fy_square > 50 and fy_square < 70";
				}else if(fysquare.equals("3")){
					sql += " and fy_square > 70 and fy_square < 90";
				}else if(fysquare.equals("4")){
					sql += " and fy_square > 90";
				}
			}else{
				if(fysquare.equals("1")){
					sql += " fy_square < 50";
				}else if(fysquare.equals("2")){
					sql += " fy_square > 50 and fy_square < 70";
				}else if(fysquare.equals("3")){
					sql += " fy_square > 70 and fy_square < 90";
				}else if(fysquare.equals("4")){
					sql += " fy_square > 90";
				}
			}
		}
		
	}
	
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFytitle() {
		return fytitle;
	}
	public void setFytitle(String fytitle) {
		this.fytitle = fytitle;
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
	public String getQuyu() {
		return quyu;
	}
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	public List<Chaxun> getFangList() {
		return fangList;
	}
	public void setFangList(List<Chaxun> fangList) {
		this.fangList = fangList;
	}

}
