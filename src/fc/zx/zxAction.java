package fc.zx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import com.opensymphony.xwork2.ActionSupport;

import db.conn.dbconn;


import com.opensymphony.xwork2.ActionSupport;

public class zxAction extends ActionSupport {
	private String  getzxById ="select zx_type,zx_title,zx_date,zx_content,zx_state from fangchan_msg where zx_ID=?";
	private String zxType;
	private String zxTitle; 
	private String zxDate;
	private String zxContent;
	private String zxState;
	private String zxId;
		
	public String getZxType() {
		return zxType;
	}
	public void setZxType(String zxType) {
		this.zxType = zxType;
	}
	public String getZxTitle() {
		return zxTitle;
	}
	public void setZxTitle(String zxTitle) {
		this.zxTitle = zxTitle;
	}
	public String getZxDate() {
		return zxDate;
	}
	public void setZxDate(String zxDate) {
		this.zxDate = zxDate;
	}
	public String getZxContent() {
		return zxContent;
	}
	public void setZxContent(String zxContent) {
		this.zxContent = zxContent;
	}
	public String getZxState() {
		return zxState;
	}
	public void setZxState(String zxState) {
		this.zxState = zxState;
	}
	public List getZxList() {
		return zxList;
	}
	public void setZxList(List zxList) {
		this.zxList = zxList;
	}
	
	public String getZxId() {
		return zxId;
	}
	public void setZxId(String zxId) {
		this.zxId = zxId;
	}

	private List  zxList = new ArrayList();
	Connection con = dbconn.getConnection();
	public String execute()throws Exception{
		PreparedStatement  stmt = con.prepareStatement(this.getzxById);
		stmt.setInt(1,Integer.parseInt(zxId));
		ResultSet rs = stmt.executeQuery();
		
		zxAction zx = null;
		while (rs.next()) {
			System.out.println("sdfadsdsdsffsdsafdsfasgasdfdsf");
			zx = new zxAction();
			
			this.setZxTitle(rs.getString("zx_title"));
			this.setZxContent(rs.getString("zx_content"));
			this.setZxDate(rs.getString("zx_date"));
			this.setZxState(rs.getString("zx_state"));
			this.setZxType(rs.getString("zx_type"));
			
			zxList.add(zx);
		}
		
		con.close();
		return "zixun";
	}

}
