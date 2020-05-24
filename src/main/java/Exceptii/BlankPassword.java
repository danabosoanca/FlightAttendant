package Exceptii;

import javax.swing.JOptionPane;

public class BlankPassword extends Exception{
	public String toString() {
		JOptionPane.showMessageDialog(null, "Blank password not pemitted.");
		return "Blank Password";
	}
}
