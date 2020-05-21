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

public class EditFlight extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public EditFlight(final int id_zbor) {
		setTitle("Reservation Form");
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
		
		JButton btnEditeaza = new JButton("Editeaza");
		btnEditeaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
					if(!conn.isClosed())
						System.out.println("Succesfully connected ...");
					String sql = "update zboruri set oras_de_plecare = ?, destinatie = ?, ora_imbarcare = ?, data_imbarcare = ?, durata = ?, locuri_disp = ?, pret_bilet = ? where id_zbor = " + id_zbor;
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1,textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7, textField_6.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Modificare reusita!");
				}catch(Exception e) {
					System.err.println(e);
				} finally {
					try {
						if(conn != null)
							conn.close();
					} catch (SQLException e) {}
				}
				
			}
		});
		btnEditeaza.setForeground(new Color(153, 0, 0));
		btnEditeaza.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnEditeaza.setBounds(69, 333, 100, 23);
		contentPane.add(btnEditeaza);
		
		JButton btnSterge = new JButton("Inapoi");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AllFlightsMemb().setVisible(true);
				dispose();
			}
		});
		btnSterge.setForeground(new Color(153, 0, 0));
		btnSterge.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSterge.setBounds(151, 367, 100, 23);
		contentPane.add(btnSterge);
		
		textField = new JTextField();
		textField.setBounds(220, 45, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(220, 79, 140, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(220, 113, 140, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(220, 147, 140, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(220, 181, 140, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(220, 215, 140, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(220, 249, 140, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSterge_1 = new JButton("Sterge");
		btnSterge_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
					if(!conn.isClosed())
						System.out.println("Succesfully connected ...");
					String sql = "delete from zboruri where id_zbor=" + id_zbor;
					JOptionPane.showMessageDialog(null, "Stergere reusita");
				}catch(Exception e) {
					System.err.println(e);
				} finally {
					try {
						if(conn != null)
							conn.close();
					} catch (SQLException e) {}
				}
			}
		});
		btnSterge_1.setForeground(new Color(153, 0, 0));
		btnSterge_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSterge_1.setBounds(220, 333, 100, 23);
		contentPane.add(btnSterge_1);
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
			String sql = "SELECT * FROM zboruri  WHERE id_zbor =" + id_zbor;
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				textField.setText(rs.getString("oras_de_plecare"));
				textField_1.setText(rs.getString("destinatie"));
				textField_2.setText(rs.getString("ora_imbarcare"));
				textField_3.setText(rs.getString("data_imbarcare"));
				textField_4.setText(rs.getString("durata"));
				textField_5.setText(rs.getString("locuri_disp"));
				textField_6.setText(rs.getString("pret_bilet"));
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
