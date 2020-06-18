package home;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.apache.commons.io.FileUtils;

import services.System_services;



public class home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		            if (!Files.exists(System_services.getPath1()))
		                FileUtils.copyURLToFile(home.class.getClassLoader().getResource("glob.png"), System_services.getPath1().toFile());
		            if (!Files.exists(System_services.getPath2()))
		                FileUtils.copyURLToFile(home.class.getClassLoader().getResource("login.png"), System_services.getPath2().toFile());
		            if (!Files.exists(System_services.getPath3()))
		                FileUtils.copyURLToFile(home.class.getClassLoader().getResource("register.png"), System_services.getPath3().toFile());
		           home frame=new home();
		           frame.setVisible(true);
		           

		        } catch (IOException e) {
		            e.printStackTrace();
		        }catch (Exception e) {
		            e.printStackTrace();
		        }
		}});
	}

	/**
	 * Create the frame.
	 */
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("ToolTip.background"));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new RegisterForm().setVisible(true);
				dispose();
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/register.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(243, 178, 130, 25);
		panel.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(home.class.getResource("/glob.png")));
		label.setBounds(-14, 13, 160, 115);
		panel.add(label);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginForm().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setIcon(new ImageIcon(home.class.getResource("/login.png")));
		btnNewButton.setBounds(66, 178, 116, 25);
		panel.add(btnNewButton);
		
		JLabel lblFlightAttendant = new JLabel("Flight Attendant");
		lblFlightAttendant.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightAttendant.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblFlightAttendant.setBounds(66, 80, 308, 25);
		panel.add(lblFlightAttendant);
	}
}
