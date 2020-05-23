/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableDB {
	private Connection conn=null;
	public TableDB() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
	}
	public void updateFlights(int id_zbor,int nr_bilete) {
		String sql="SELECT * FROM zboruri  WHERE id_zbor =" + id_zbor;
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
	}
}*/
