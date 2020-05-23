package home.pages.member;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayInformation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DisplayInformation(final int id_utilizator) {
		setBackground(UIManager.getColor("ToolTip.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 288);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ToolTip.background"));
		contentPane.setForeground(UIManager.getColor("ToolTip.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informatii client");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(118, 13, 196, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNume.setBounds(36, 75, 148, 16);
		contentPane.add(lblNume);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdresa.setBounds(36, 104, 148, 16);
		contentPane.add(lblAdresa);
		
		JLabel lblNumarDeTelefon = new JLabel("Numar de telefon");
		lblNumarDeTelefon.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNumarDeTelefon.setBounds(36, 133, 148, 16);
		contentPane.add(lblNumarDeTelefon);
		
		JLabel nume = new JLabel("");
		nume.setBounds(249, 76, 158, 16);
		contentPane.add(nume);
		
		JLabel adresa = new JLabel("");
		adresa.setBounds(249, 105, 158, 16);
		contentPane.add(adresa);
		
		JLabel numar = new JLabel("");
		numar.setBounds(249, 133, 158, 16);
		contentPane.add(numar);
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AllReservations().setVisible(true);
				dispose();
			}
		});
		btnInapoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInapoi.setBounds(170, 191, 97, 25);
		contentPane.add(btnInapoi);
	
	Connection conn=null;
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
		String sql = "SELECT * FROM utilizatori  WHERE id_utilizator =" + id_utilizator;
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			nume.setText(rs.getString("nume"));
			adresa.setText(rs.getString("adresa"));
			numar.setText(rs.getString("telefon"));
			
		}
		
		
		
		}catch (Exception e) {
		System.err.println(e);
	} finally {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {}
	}
}}

