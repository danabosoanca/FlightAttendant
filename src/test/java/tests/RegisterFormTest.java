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

import home.ConnectToDB;
import home.RegisterForm;

public class RegisterFormTest {
	private static Connection conn = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			conn=ConnectToDB.getConn();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conn.close();
	}

	@Test
	public void addUserTest() throws Exception{
				RegisterForm test=new RegisterForm();
				int before=0,after=0;
				String sql = "SELECT * FROM utilizatoritest";
				PreparedStatement pst;
				pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while(rs.next())
					before++;
				test.addUser("utilizatoritest", "client","client", "000000000", 0, "client", "client");
				rs = pst.executeQuery();
				while(rs.next())
					after++;
				assertNotEquals(before,after);
	}
}
