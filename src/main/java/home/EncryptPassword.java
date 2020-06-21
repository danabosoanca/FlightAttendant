package home;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import Exceptii.*;

public class EncryptPassword{
	public static String encryptPassword (String data) throws BlankPassword {
		try {
			if(data.isEmpty())
				throw new BlankPassword();
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(data.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashText = no.toString(16);
			while(hashText.length() < 32) {
				hashText = "0" + hashText;
			}
			return hashText;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
