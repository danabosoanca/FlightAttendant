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

import home.ConnectToDB;
import home.pages.member.AddFlight;

public class AddFlightTest {
	private static Connection conn=null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn=ConnectToDB.getConn();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conn.close();
	}

	@Test
	public void addFlightTest() throws Exception{
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
	}
}


