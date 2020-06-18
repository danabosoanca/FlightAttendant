package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import home.RegisterForm;

public class TestRegister {

	   @Test
	    public void existaUser() {
	        RegisterForm test = new RegisterForm();
	        boolean result = test.verifyUser("valentin_popescu");
	        assertTrue(result);
	    }

	    @Test
	    public void nuExistaUser() {
	        RegisterForm test = new RegisterForm();
	        boolean result = test.verifyUser("user_random");
	        assertFalse(result);
	    }

}
