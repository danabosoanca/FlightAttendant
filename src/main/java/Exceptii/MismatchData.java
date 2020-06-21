package Exceptii;

import javax.swing.JOptionPane;

public class MismatchData extends Exception {
	private String user,pass;
	public MismatchData(String u, String p) {
		super("User-ul si parola nu se potrivesc");
	
		user=u;
		pass=p;
	}
	public String toString() {
		JOptionPane.showMessageDialog(null, "User-ul si parola nu se potrivesc");
		return "User-ul si parola nu se potrivesc";
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return pass;
	}
}
