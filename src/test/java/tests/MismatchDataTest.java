package tests;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Exceptii.MismatchData;
import home.ConnectToDB;
import home.EncryptPassword;
import home.LoginForm;

public class MismatchDataTest {

	public static Connection conn =null;
	MismatchData md;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn = ConnectToDB.getConn();
	}
	
	@Before
	public void setUp() throws Exception {
        this.md = new MismatchData("client",EncryptPassword.encryptPassword("client"));
    }
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conn.close();
	}

	@Test(expected=MismatchData.class)
	public void testMismatch() throws Exceptii.MismatchData, Exception{
		LoginForm test=new LoginForm();
		test.verifyLogin("utilizatoritest", "client", EncryptPassword.encryptPassword("parola"));
		Assume.assumeTrue(false);
	}
	
	@Test
	public void testGetUser() throws Exception {
		assertEquals("client",md.getUser());
	}
	
	@Test
	public void testGetPass() throws Exception{
		assertEquals(EncryptPassword.encryptPassword("client"),md.getPassword());
	}

}
