package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import home.ConnectToDB;
import home.pages.client.Reservation;

public class TestReservation {
	private static Connection conn;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn = ConnectToDB.getConn();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conn.close();
	}

	@Test
	public void testAddReservation() throws Exception{
		Reservation test=new Reservation(20,2);
		int before=0,after=0;
		String sql = "SELECT * FROM rezervaritest";
		PreparedStatement pst;
		pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
			before++;
		test.addReservation("rezervaritest", 1,"2","20");
		rs = pst.executeQuery();
		while(rs.next())
			after++;
		assertNotEquals(before,after);		
	}

}
