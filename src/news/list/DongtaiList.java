package news.list;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;

public class DongtaiList extends ActionSupport {
	private String dtid;
	private String dttitle;
	private String dtdate;
	Connection con;
	String sql = "select dt_id, dt_title, dt_date from market_dongtai where dt_state = '1'";
	private List<DongtaiList>  dtList = new ArrayList<DongtaiList>();
	
	public String execute(){
		con = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		DongtaiList dt = null;
		int size = 0;
		
		try {
			dt = new DongtaiList();
	    	stmt=con.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while(rs.next()){
	    		System.out.println("copying...");
	    		dt.setDtid(rs.getString("dt_id"));
	    		dt.setDttitle(rs.getString("dt_title"));
	    		dt.setDtdate(rs.getString("dt_date"));
	    		
	    		dtList.add(dt);	    		
	    	}
	    	size = dtList.size();
	    	stmt.close();
		    rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbconn.closeConn(con);
		System.out.println("size is " + size);
		return "dongtaisuc";
	}

	public String getDttitle() {
		return dttitle;
	}

	public void setDttitle(String dttitle) {
		this.dttitle = dttitle;
	}

	public String getDtdate() {
		return dtdate;
	}

	public void setDtdate(String dtdate) {
		this.dtdate = dtdate;
	}

	public List<DongtaiList> getDtList() {
		return dtList;
	}

	public void setDtList(List<DongtaiList> dtList) {
		this.dtList = dtList;
	}

	public String getDtid() {
		return dtid;
	}

	public void setDtid(String dtid) {
		this.dtid = dtid;
	}
	
	
}
