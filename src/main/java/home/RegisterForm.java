package home;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.Color;

public class RegisterForm extends JFrame {
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
		contentPane.setBackground(UIManager.getColor("ToolTip.background"));
		contentPane.setForeground(new Color(0, 0, 0));
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
		Image img = new ImageIcon(this.getClass().getResource("/glob.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 29, 207, 120);
		contentPane.add(lblNewLabel_1);
		
		JButton btnInregistrare = new JButton("Inregistrare");
		btnInregistrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
					String sql = "INSERT INTO utilizatori (nume, adresa, telefon, membru, username, password) VALUES (?, ?, ?, ?, ?, ?)" ;
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1,nume.getText());
					pst.setString(2, adresa.getText());
					pst.setString(3,tel.getText());
					int memb;
					if(checkMembru.isSelected()) {
						String cod = codMembru.getText();
						if(cod.equals("fis123")) 
							memb = 1;
						else
							throw new Exceptii.CodGresit(cod);
					}
					else
						memb = 0;
					pst.setInt(4, memb);
					
					String username = user.getText();					
					if(verifyUser(username))
						throw new Exceptii.UserAlreadyExists(username);
					
					pst.setString(5, username);
					String pass = new String (password.getPassword());
					if(pass.equals(""))
						throw new Exceptii.BlankPassword();
					pst.setString(6,EncryptPassword.encryptPassword(pass));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Adaugare reusita");
					new LoginForm().setVisible(true);
					dispose();
				}catch (Exceptii.BlankPassword e) {
					System.err.println(e);
				}catch (Exception e) {
					System.err.println(e);
				} finally {
					try {
						if(conn != null)
							conn.close();
					} catch (SQLException e) {}
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

	public boolean verifyUser(String u){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
			
			String sql = "SELECT * FROM utilizatori WHERE username = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,u);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				conn.close();
				return true;
			}
			
			conn.close();
		} catch(Exception e) {
			System.err.println(e);
		}
		return false;
	}
}
