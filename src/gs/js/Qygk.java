package gs.js;

import com.opensymphony.xwork2.ActionSupport;

public class Qygk extends ActionSupport {
	private String gaikuang;
	String sql = "update qiye_jieshao set js_content=? where js_id = '1'";
	
	public String execute(){
		System.out.println("gaikuang is " + gaikuang);
		return "gaikuang";
	}

	public String getGaikuang() {
		return gaikuang;
	}

	public void setGaikuang(String gaikuang) {
		this.gaikuang = gaikuang;
	}
	
	
}
