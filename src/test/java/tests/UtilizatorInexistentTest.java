package tests;

import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import Exceptii.UtilizatorInexistent;
import home.ConnectToDB;
import home.EncryptPassword;
import home.LoginForm;

public class UtilizatorInexistentTest {

	public static Connection conn =null;
	UtilizatorInexistent md;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn = ConnectToDB.getConn();
	}
	
	@Before
	public void setUp() throws Exception {
        this.md = new UtilizatorInexistent("bla");
    }
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conn.close();
	}

	@Test(expected=UtilizatorInexistent.class)
	public void testUtilizatorInexistent() throws Exceptii.UtilizatorInexistent, Exception{
		LoginForm test=new LoginForm();
		test.verifyLogin("utilizatoritest", "bla", EncryptPassword.encryptPassword("parola"));
		Assume.assumeFalse(true);
		
		
	}

}
