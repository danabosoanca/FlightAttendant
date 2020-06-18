package home;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import Exceptii.*;

public class EncryptPassword{
	public static String encryptPassword (String data,String algorithm) throws BlankPassword {
		try {
			int i;
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			digest.update(data.getBytes());
			byte[] bytes = digest.digest();
			StringBuilder sb = new StringBuilder();
			for(i = 0; i<bytes.length;i++ ) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0100, 16).substring(1));
			}
			return sb.toString(); 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
