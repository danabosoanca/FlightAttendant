import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddFlight extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtHhmm;
	private JTextField txtXxxx;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlight frame = new AddFlight();
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
	public AddFlight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Oras de plecare :");
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label.setBounds(23, 40, 132, 23);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Destinatie :");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_1.setBounds(23, 74, 132, 23);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Ora de imbarcare :");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_2.setBounds(23, 108, 132, 23);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Data zborului :");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_3.setBounds(23, 142, 132, 23);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Durata zborului :");
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_4.setBounds(23, 176, 132, 23);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Locuri disponibile :");
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_5.setBounds(23, 210, 132, 23);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Pret bilet :");
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_6.setBounds(23, 244, 132, 23);
		contentPane.add(label_6);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(190, 43, 140, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 77, 140, 20);
		contentPane.add(textField_1);
		
		txtHhmm = new JTextField();
		txtHhmm.setText("hh:mm");
		txtHhmm.setColumns(10);
		txtHhmm.setBounds(190, 111, 140, 20);
		contentPane.add(txtHhmm);
		
		txtXxxx = new JTextField();
		txtXxxx.setText("yyyy-mm-dd");
		txtXxxx.setColumns(10);
		txtXxxx.setBounds(190, 145, 140, 20);
		contentPane.add(txtXxxx);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(190, 179, 140, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(190, 213, 140, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(190, 247, 140, 20);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
					if(!conn.isClosed())
						System.out.println("Succesfully connected ...");
					String sql = "INSERT INTO zboruri (oras_de_plecare,destinatie,ora_imbarcare,data_imbarcare,durata,locuri_disp,pret_bilet) values (?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, txtHhmm.getText());
					pst.setString(4, txtXxxx.getText());
					pst.setString(5, textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7, textField_6.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Adaugare reusita");
					dispose();
				}catch(Exception x) {
					System.err.println(x);
				} finally {
					try {
						if(conn != null)
							conn.close();
					} catch (SQLException x) {}
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(190, 292, 106, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Anuleaza");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(48, 292, 107, 23);
		contentPane.add(btnNewButton_1);
	}
}
