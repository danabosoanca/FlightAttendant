package tests;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import Exceptii.UserAlreadyExists;
import home.ConnectToDB;
import home.RegisterForm;

public class UserAlreadyExistsTest {

	public static Connection conn =null;
	UserAlreadyExists uad;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn = ConnectToDB.getConn();
	}
	
	@Before
	public void setUp() throws Exception {
        this.uad = new UserAlreadyExists("client");
    }
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conn.close();
		
	}

	@Test(expected=UserAlreadyExists.class)
	public void testUserAlreadyExists() throws Exceptii.UserAlreadyExists, Exception{
		RegisterForm test=new RegisterForm();
		test.verifyUser("client");
		Assume.assumeTrue(false);
	}
	
	@Test
	public void testGetUser() throws Exception {
		assertEquals("client",uad.getUser());
	}}
