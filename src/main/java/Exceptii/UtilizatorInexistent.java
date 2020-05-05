package Exceptii;

import javax.swing.JOptionPane;

public class UtilizatorInexistent extends Exception {
	String user;
	public UtilizatorInexistent(String u) {
		super("Utilizatorul nu exista");
		JOptionPane.showMessageDialog(null, "Utilizatorul nu exista");
		user=u;
	}
	public String getUser() {
		return user;
	}
}
