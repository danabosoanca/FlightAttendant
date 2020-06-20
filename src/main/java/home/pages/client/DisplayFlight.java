package home.pages.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayFlight extends JFrame {

	private JPanel contentPane;
	private JTextField nr_bilete;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public DisplayFlight(final int id_zbor) {
		setTitle("Display Flight");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 464);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ToolTip.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Oras de plecare :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(37, 42, 132, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblDestinatie = new JLabel("Destinatie :");
		lblDestinatie.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDestinatie.setBounds(37, 76, 132, 23);
		contentPane.add(lblDestinatie);
		
		JLabel lblOraDeImbarcare = new JLabel("Ora de imbarcare :");
		lblOraDeImbarcare.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblOraDeImbarcare.setBounds(37, 110, 132, 23);
		contentPane.add(lblOraDeImbarcare);
		
		JLabel lblDataZborului = new JLabel("Data zborului :");
		lblDataZborului.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDataZborului.setBounds(37, 144, 132, 23);
		contentPane.add(lblDataZborului);
		
		JLabel lblDurataZborului = new JLabel("Durata zborului :");
		lblDurataZborului.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDurataZborului.setBounds(37, 178, 132, 23);
		contentPane.add(lblDurataZborului);
		
		JLabel lblLocuriDisponibile = new JLabel("Locuri disponibile :");
		lblLocuriDisponibile.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblLocuriDisponibile.setBounds(37, 212, 132, 23);
		contentPane.add(lblLocuriDisponibile);
		
		JLabel lblPretBilet = new JLabel("Pret bilet :");
		lblPretBilet.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPretBilet.setBounds(37, 246, 132, 23);
		contentPane.add(lblPretBilet);
		
		JButton btnNewButton = new JButton("Rezerva");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numarBilete=Integer.parseInt((nr_bilete.getText()));
				new Reservation(numarBilete,id_zbor).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(UIManager.getColor("ToolTip.foreground"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(69, 333, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Inapoi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ClientsPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(UIManager.getColor("ToolTip.foreground"));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(220, 333, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(220, 48, 143, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(220, 82, 143, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(220, 116, 143, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(220, 150, 143, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(220, 184, 143, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(220, 218, 143, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(220, 252, 143, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNumarDeBilete = new JLabel("Numar de bilete :");
		lblNumarDeBilete.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNumarDeBilete.setBounds(37, 280, 132, 23);
		contentPane.add(lblNumarDeBilete);
		
		nr_bilete = new JTextField();
		nr_bilete.setText("1");
		nr_bilete.setBounds(220, 283, 27, 20);
		contentPane.add(nr_bilete);
		nr_bilete.setColumns(10);
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
			String sql = "SELECT * FROM zboruri  WHERE id_zbor =" + id_zbor;
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				lblNewLabel_1.setText(rs.getString("oras_de_plecare"));
				lblNewLabel_2.setText(rs.getString("destinatie"));
				lblNewLabel_3.setText(rs.getString("ora_imbarcare"));
				lblNewLabel_4.setText(rs.getString("data_imbarcare"));
				lblNewLabel_5.setText(rs.getString("durata"));
				lblNewLabel_6.setText(rs.getString("locuri_disp"));
				lblNewLabel_7.setText(rs.getString("pret_bilet"));
			}
			
			
			
			}catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {}
		}
	}
}
