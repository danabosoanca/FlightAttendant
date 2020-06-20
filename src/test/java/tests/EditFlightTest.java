package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import home.ConnectToDB;
import home.pages.member.AddFlight;
import home.pages.member.EditFlight;

public class EditFlightTest {
	private static Connection conn = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn = ConnectToDB.getConn();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conn.close();
	}

	@Test
	public void testEditFlightTrue() throws Exception{
		EditFlight test = new EditFlight(1);
		boolean value = test.editFlight("zboruritest", "test", "test", "00:00:00", "2020-06-20", "100", "100000", "10", 1);
		assertTrue(value);
	}
	
	@Test
	public void testEditFlightFalse() throws Exception{
		EditFlight test = new EditFlight(1);
		boolean value = test.editFlight("zboruritest", "test", "test", "00:00:00", "2020-06-20", "100", "100000", "10", -2);
		assertFalse(value);
	}
	
	@Test
	public void testDeleteFlightTrue() throws Exception{
		EditFlight test=new EditFlight(1);
		int before=0,after=0;
		String sql = "SELECT * FROM zboruritest";
		PreparedStatement pst;
		pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
			before++;
		test.deleteFlight("zboruritest", 8);
		rs = pst.executeQuery();
		while(rs.next())
			after++;
		assertEquals(before,after);
	}

	@Test
	public void testDeleteFlightFalse() throws Exception{
		EditFlight test=new EditFlight(1);
		int before=0,after=0;
		String sql = "SELECT * FROM zboruritest";
		PreparedStatement pst;
		pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
			before++;
		test.deleteFlight("zboruritest", -1);
		rs = pst.executeQuery();
		while(rs.next())
			after++;
		assertEquals(before,after);
	}
}
