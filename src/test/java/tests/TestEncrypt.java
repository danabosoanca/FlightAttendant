package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptii.BlankPassword;
import home.EncryptPassword;

public class TestEncrypt {

	@Test
	public void testCorrectEncrypt() throws Exception {
		String encryption = "b957630948cfe1973842a5f97af4357a"; // luat de pe https://cryptii.com/pipes/md5-hash
		assertEquals(encryption,EncryptPassword.encryptPassword("buna"));
	}
	
	@Test
	public void testWrongEncrypt() throws Exception {
		String encryption = "b957630948cfe1973842a5f97af4357a"; // luat de pe https://cryptii.com/pipes/md5-hash
		assertNotEquals(encryption,EncryptPassword.encryptPassword("Buna"));
	}

	@Test(expected = BlankPassword.class)
	public void testBlankPass() throws Exception{
		EncryptPassword.encryptPassword("");
	}
}
