package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import home.pages.member.AddFlight;

public class AddFlightTest {
	private static Connection conn=null;

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
	public void addFlightTest() {
		try {
			AddFlight test=new AddFlight();
			int before=0,after=0;
			String sql = "SELECT * FROM zboruritest";
			PreparedStatement pst;
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
				before++;
			test.addFlight("zboruritest", "bla","bla", "06:06", "2020-12-24", "80", "80","80");
			rs = pst.executeQuery();
			while(rs.next())
				after++;
			assertNotEquals(before,after);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}


