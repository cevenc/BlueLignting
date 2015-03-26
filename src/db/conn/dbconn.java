package db.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconn {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection  getConnection(){
	  try {
		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bluelighting?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true", "root", "123456");
		  System.out.println("connect success!!!");
		  return conn;
	  } catch (SQLException e) {
		  e.printStackTrace();
	  }
	  return null;
	}

	
	public static void closeConn(Connection con){
		try{
			if(con!=null&&!con.isClosed()){
				System.out.println("close success!!!");
				con.close();	 
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
