package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import home.ConnectToDB;
import home.pages.client.ClientsPage;

public class ClientsPageTest {
	public static Connection conn =null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn = ConnectToDB.getConn();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conn.close();
	}

	@Test
	public void testUpdateFlight() throws Exception{
		int before=0,after=0;
		String sql = "SELECT * FROM zboruritest WHERE id_zbor = 1" ;
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
			before = rs.getInt("locuri_disp");
		ClientsPage.updateFlight("zboruritest", 10, 1);
		rs = pst.executeQuery();
		if(rs.next())
			after=rs.getInt("locuri_disp");
		assertNotEquals(before,after);
	}

}
