package fc.zx;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class Fabu extends ActionSupport {
	private String fytitle;
	private String jjrid;
	private String chengqu;
	private String pianqu = "3";
	private String fytype;
	private int fymoney;
	private int fysquare;
	private String fyzhuangxiu = "4";
	private String fychanquan = "5";
	private String fytupian= "6";
	private String fyxq;
	private String fystate;
	private String fang;
	private String ceng;
	private String ting;
	private String lou;
	private String message;
	Connection con;
	
	
	
	public String execute(){//只用到标题名字，一个标题对应一条TodayfAction
		System.out.println("fysquare is " + fysquare);
		if(chengqu.equals("0") || fang.equals("0") || ting.equals("0") || lou.equals("0") || ceng.equals("0") || fytitle.equals("0") || fysquare == 0 || fymoney == 0){
			message = "信息不能为空，添加失败，请重新添加!!";
			return "fbfal";
		}
		int flag = this.dedao(fytitle,jjrid,chengqu,pianqu,fang,fymoney,fysquare,fyzhuangxiu,fychanquan,fytupian,fyxq);
		if(flag == 0){
			//System.out.println("目前" + fyid + "无数据!!!");
			dbconn.closeConn(con);
			return "fbfal";
		}
		//System.out.println("创建" + fyid + "及以后数据!!!");
		message = "发布成功!!";
		dbconn.closeConn(con);
		return "fbsuc";
	}

	private int dedao(String fytitle, String jjrid,
			String chengqu, String pianqu, String fytype, int fymoney,
			int fysquare, String fyzhuangxiu, String fychanquan,
			String fytupian, String fyxq) {
		int flag = 0;
		Statement stmt = null;
		con = dbconn.getConnection(); 		
	//String sql = "DELETE FROM customers WHERE `kh_id`='8'";
	String sql = "INSERT INTO fangyuan (`fy_fang`, `fy_ting`, `fy_lou`, `fy_ceng`, `fy_title`,`jjr_id`,`chengqu`,`pianqu`,`fy_type`,`fy_money`,`fy_square`,`fy_zhaungxiu`,`fy_chanquan`,`fy_xq`,`fy_state`)" +
			" VALUES ('"+fang+"','"+ting+"','"+lou+"','"+ceng+"','"+fytitle+"','"+jjrid+"','"+chengqu+"','"+pianqu+"','"+fang+"','"+fymoney+"','"+fysquare+"','"+fyzhuangxiu+"','"+fychanquan+"','"+fyxq+"','1');";
	    try {
	    	stmt=con.createStatement();
	    	stmt.executeUpdate(sql);
	    	flag = 1;			    
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return flag;
	}





	
	public String getCeng() {
		return ceng;
	}

	public void setCeng(String ceng) {
		this.ceng = ceng;
	}

	public String getTing() {
		return ting;
	}

	public void setTing(String ting) {
		this.ting = ting;
	}

	public String getLou() {
		return lou;
	}

	public void setLou(String lou) {
		this.lou = lou;
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
	public String getJjrid() {
		return jjrid;
	}
	public void setJjrid(String jjrid) {
		this.jjrid = jjrid;
	}
	public String getChengqu() {
		return chengqu;
	}
	public void setChengqu(String chengqu) {
		this.chengqu = chengqu;
	}
	public String getPianqu() {
		return pianqu;
	}
	public void setPianqu(String pianqu) {
		this.pianqu = pianqu;
	}
	public String getFytype() {
		return fytype;
	}
	public void setFytype(String fytype) {
		this.fytype = fytype;
	}
	
	
	public int getFymoney() {
		return fymoney;
	}

	public void setFymoney(int fymoney) {
		this.fymoney = fymoney;
	}

	public int getFysquare() {
		return fysquare;
	}
	public void setFysquare(int fysquare) {
		this.fysquare = fysquare;
	}
	public String getFyzhuangxiu() {
		return fyzhuangxiu;
	}
	public void setFyzhuangxiu(String fyzhuangxiu) {
		this.fyzhuangxiu = fyzhuangxiu;
	}
	public String getFychanquan() {
		return fychanquan;
	}
	public void setFychanquan(String fychanquan) {
		this.fychanquan = fychanquan;
	}
	public String getFytupian() {
		return fytupian;
	}
	public void setFytupian(String fytupian) {
		this.fytupian = fytupian;
	}
	public String getFyxq() {
		return fyxq;
	}
	public void setFyxq(String fyxq) {
		this.fyxq = fyxq;
	}
	public String getFystate() {
		return fystate;
	}
	public void setFystate(String fystate) {
		this.fystate = fystate;
	}

	public String getFang() {
		return fang;
	}

	public void setFang(String fang) {
		this.fang = fang;
	}	
	
}
