import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField utilizator;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 225));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Utilizator:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(54, 174, 93, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Parola:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(54, 228, 93, 16);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
					String user=utilizator.getText();
					String pass=new String(password.getPassword());
					String sql="SELECT * FROM utilizatori WHERE username=?";
					PreparedStatement pts= conn.prepareStatement(sql);
					pts.setString(1, user);
					ResultSet rs = pts.executeQuery();
					if(rs.next()) {
						if(user.equals(rs.getString("username")) && pass.equals(rs.getString("password"))) {
							if(rs.getInt("membru")==1) {
								System.out.println("e membru");
							}
							else {
								System.out.println("e client");
							}
						}else {
							throw new Exceptii.MismatchData(user,pass);
						}
					}
					else {
						throw new Exceptii.UtilizatorInexistent(user);
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
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(100, 288, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Inapoi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new home().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(266, 288, 97, 25);
		panel.add(btnNewButton_1);
		
		utilizator = new JTextField();
		utilizator.setBounds(192, 171, 216, 22);
		panel.add(utilizator);
		utilizator.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(192, 225, 216, 22);
		panel.add(password);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/glob.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(54, 43, 138, 111);
		panel.add(label);
		
	}
}
