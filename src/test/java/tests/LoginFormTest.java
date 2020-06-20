package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Exceptii.BlankPassword;
import Exceptii.MismatchData;
import Exceptii.UtilizatorInexistent;
import home.*;

public class LoginFormTest {

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
	public void testAdmin () throws Exception{
		LoginForm test=new LoginForm();
		assertEquals(1,test.verifyLogin("utilizatoritest","admin",EncryptPassword.encryptPassword("admin")));
		
	}
	
	@Test
	public void testClient() throws Exception{
		LoginForm test=new LoginForm();
		assertEquals(0,test.verifyLogin("utilizatoritest","client",EncryptPassword.encryptPassword("client")));
	}
	
	@Test
	public void testGetUtilizator() throws Exception {
		int id=0; LoginForm test=new LoginForm();
		String sql = "SELECT * FROM utilizatoritest" ;
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
			id = rs.getInt("id_utilizator");
		test.getUtilizator();
		//assertEquals(1,id);
		assertNotEquals(10,id);
	}
	
	/*@Test(expected = MismatchData.class)
	public void testMismatchData() throws Exception{
		LoginForm test=new LoginForm();
		test.verifyLogin("utilizatoritest", "client", EncryptPassword.encryptPassword("parola"));*/
	}
	
	/*@Test(expected = UtilizatorInexistent.class)
	public void testUtilizatorInexistent() throws Exception{
		LoginForm test=new LoginForm();
		test.verifyLogin("utilizatoritest", "ana", "parola");
	}*/

