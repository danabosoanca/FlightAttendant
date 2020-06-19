package home.pages.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import home.*;

public class Reservation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public Reservation(final int nr_bilete, final int id_zbor) {
		Connection conn=null;
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 273);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ToolTip.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAccepta = new JButton("Accepta");
		btnAccepta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int utilizator = LoginForm.getUtilizator();
				String zbor = String.valueOf(id_zbor);
				String bilete = String.valueOf(nr_bilete);
				addReservation("rezervari",utilizator,zbor,bilete);
				ClientsPage.updateFlight("zboruri",nr_bilete, id_zbor);
				JOptionPane.showMessageDialog(null, "Rezervare reusita");
				new ClientsPage().setVisible(true);
				dispose();
				
			}	
			
		});
		btnAccepta.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAccepta.setForeground(new Color(153, 0, 0));
		btnAccepta.setBounds(12, 159, 97, 25);
		contentPane.add(btnAccepta);
		
		JButton btnNewButton = new JButton("Renunta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClientsPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(153, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(146, 159, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblPretulRezervariiEste = new JLabel("Pretul rezervarii este :");
		lblPretulRezervariiEste.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPretulRezervariiEste.setForeground(new Color(0, 0, 0));
		lblPretulRezervariiEste.setBounds(25, 62, 156, 25);
		contentPane.add(lblPretulRezervariiEste);
		
		JLabel total = new JLabel("");
		total.setBounds(76, 100, 122, 16);
		contentPane.add(total);
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
			String sql="SELECT * FROM zboruri where id_zbor = "+id_zbor;
			PreparedStatement pts= conn.prepareStatement(sql);
			ResultSet rs = pts.executeQuery();
			if(rs.next()) {
				int pret=nr_bilete*(Integer.parseInt(rs.getString("pret_bilet")));
				total.setText(String.valueOf(pret));
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void addReservation(String tabel,int utilizator,String zbor, String bilete) {
		Connection conn = ConnectToDB.getConn();
		try {
			String sql = "INSERT INTO "+ tabel +" (id_utilizator, id_zbor, nr_bilete) VALUES (?, ?, ?)" ;
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,utilizator);
			pst.setString(2, zbor);
			pst.setString(3,bilete);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {}
		}
	}
}
