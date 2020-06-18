package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptii.BlankPassword;
import home.EncryptPassword;

public class TestEncrypt {

	@Test
	public void test() {
		String encryption = "b957630948cfe1973842a5f97af4357a"; // luat de pe https://cryptii.com/pipes/md5-hash
		try {
			assertEquals(encryption,EncryptPassword.encryptPassword("buna"));
		} catch (BlankPassword e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() {
		String encryption = "b957630948cfe1973842a5f97af4357a"; // luat de pe https://cryptii.com/pipes/md5-hash
		try {
			assertNotEquals(encryption,EncryptPassword.encryptPassword("Buna"));
		} catch (BlankPassword e) {
			e.printStackTrace();
		}
	}

}
