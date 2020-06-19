package home;

import java.sql.Connection;
import java.sql.DriverManager;


 public class ConnectToDB {
	 
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
			 if(!conn.isClosed())
	                System.out.println("Succesfully connected ...");
		} catch (Exception e) {
			System.err.println(e);
		}
		return conn;
	}
}
