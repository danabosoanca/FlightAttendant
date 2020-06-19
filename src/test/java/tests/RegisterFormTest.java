package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import home.RegisterForm;

public class RegisterFormTest {
	private static Connection conn = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conn.close();
	}

	@Test
	public void addUserTest() {
			try {
				RegisterForm test=new RegisterForm();
				int before=0,after=0;
				String sql = "SELECT * FROM utilizatoritest";
				PreparedStatement pst;
				pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while(rs.next())
					before++;
				test.addUser("utilizatoritest", "test","test", "000000000", 1, "test", "test");
				rs = pst.executeQuery();
				while(rs.next())
					after++;
				assertNotEquals(before,after);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
