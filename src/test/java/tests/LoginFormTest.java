package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Exceptii.BlankPassword;
import Exceptii.MismatchData;
import Exceptii.UtilizatorInexistent;
import home.*;

public class LoginFormTest {


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
	
	@Test(expected = MismatchData.class)
	public void testMismatchData() throws Exception{
		LoginForm test=new LoginForm();
		test.verifyLogin("utilizatoritest", "client", "parola");
	}
	
	/*@Test(expected = UtilizatorInexistent.class)
	public void testUtilizatorInexistent() throws Exception{
		LoginForm test=new LoginForm();
		test.verifyLogin("utilizatoritest", "ana", "parola");
	}*/
}
