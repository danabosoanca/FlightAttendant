

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterForm extends JFrame {
	static int nr_utilizatori = 0;
	private JPanel contentPane;
	private JTextField adresa;
	private JTextField nume;
	private JTextField tel;
	private JTextField user;
	private JTextField codMembru;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nume:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(75, 177, 101, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAdresa.setBounds(75, 202, 101, 14);
		contentPane.add(lblAdresa);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTelefon.setBounds(75, 227, 101, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblSuntMembru = new JLabel("Sunt membru:");
		lblSuntMembru.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSuntMembru.setBounds(75, 252, 101, 14);
		contentPane.add(lblSuntMembru);
		
		JLabel lblUtilizator = new JLabel("Utilizator:");
		lblUtilizator.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUtilizator.setBounds(75, 277, 101, 14);
		contentPane.add(lblUtilizator);
		
		JLabel lblParola = new JLabel("Parola:");
		lblParola.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblParola.setBounds(75, 302, 101, 14);
		contentPane.add(lblParola);
		
		adresa = new JTextField();
		adresa.setBounds(213, 200, 160, 20);
		contentPane.add(adresa);
		adresa.setColumns(10);
		
		nume = new JTextField();
		nume.setBounds(213, 175, 160, 20);
		contentPane.add(nume);
		nume.setColumns(10);
		
		tel = new JTextField();
		tel.setBounds(213, 225, 160, 20);
		contentPane.add(tel);
		tel.setColumns(10);
		
		user = new JTextField();
		user.setBounds(213, 275, 160, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		final JCheckBox checkMembru = new JCheckBox("");
		checkMembru.setBounds(213, 249, 21, 23);
		contentPane.add(checkMembru);
		
		JLabel lblFormularDeInregistrare = new JLabel("Formular de inregistrare");
		lblFormularDeInregistrare.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblFormularDeInregistrare.setBounds(112, 121, 233, 28);
		contentPane.add(lblFormularDeInregistrare);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RegisterForm.class.getResource("/img/iconfinder_coronovirus_02_5826047.png")));
		lblNewLabel_1.setBounds(0, 29, 207, 120);
		contentPane.add(lblNewLabel_1);
		
		JButton btnInregistrare = new JButton("Inregistrare");
		btnInregistrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
					String sql = "INSERT INTO utilizatori (nume, adresa, telefon, membru, username, password, id_utilizator) VALUES (?, ?, ?, ?, ?, ?, ?)" ;
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1,nume.getText());
					pst.setString(2, adresa.getText());
					pst.setString(3,tel.getText());
					int memb;
					if(checkMembru.isSelected()) {
						memb= 1;
					}
					else
						memb = 0;
					pst.setInt(4, memb);
					pst.setString(5, user.getText());
					pst.setString(6,new String(password.getPassword()));
					pst.setInt(7, ++nr_utilizatori);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Bravo Tati");
				}catch (Exception e) {
					System.err.println(e);
				}
			}
		});
		btnInregistrare.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnInregistrare.setBounds(89, 357, 118, 23);
		contentPane.add(btnInregistrare);
		
		JButton btnCancel = new JButton("Inapoi");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new home().setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancel.setBounds(240, 357, 118, 23);
		contentPane.add(btnCancel);
		
		codMembru = new JTextField();
		codMembru.setText("Cod Membru");
		codMembru.setBounds(240, 250, 133, 20);
		contentPane.add(codMembru);
		codMembru.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 11));
		password.setBounds(213, 300, 160, 20);
		contentPane.add(password);
	}
}
