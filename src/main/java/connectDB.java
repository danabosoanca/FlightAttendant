import java.sql.*;
public class connectDB {
	public static void main(String args[]) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
			if(!conn.isClosed())
				System.out.println("Succesfully connected ...");
		}catch(Exception e) {
			System.err.println(e);
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {}
		}
	}
}