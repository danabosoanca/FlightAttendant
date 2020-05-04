package Exceptii;

import javax.swing.JOptionPane;

public class UserAlreadyExists extends Exception{
	String user;
	public UserAlreadyExists(String u) {
		super("Exista un utilizator cu acest nume.");
		JOptionPane.showMessageDialog(null, "Exista deja un utilizator cu acest nume");
		user=u;
	}
	
	public String getUser() {
		return user;
	}
}
