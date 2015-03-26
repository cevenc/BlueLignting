package user.manage;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Quit extends ActionSupport {
	private String username;
	private String userid;
	private String identity;
	public String execute(){
		ActionContext actionContext = ActionContext.getContext(); 
	    Map<String, Object> session = actionContext.getSession(); 
	    session.put("username", username); 
	    session.put("userid", userid);
	    session.put("identity", identity);
	    System.out.println("ÍË³öµÇÂ½!!");
	    
		return "quitsuc";
	}
	
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}
