package Exceptii;
import javax.swing.JOptionPane;
public class CodGresit extends Exception{
	String cod;
	public CodGresit(String e) {
		super("Codul introdus este gresit.");
		JOptionPane.showMessageDialog(null, "Cod Gresit");
		cod=e;
	}
	
	public String getCod() {
		return cod;
	}
}
