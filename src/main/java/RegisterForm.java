

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtCodMembru;

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
		
		textField = new JTextField();
		textField.setBounds(213, 200, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 175, 160, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(213, 225, 160, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(213, 275, 160, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(213, 300, 160, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(213, 249, 21, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblFormularDeInregistrare = new JLabel("Formular de inregistrare");
		lblFormularDeInregistrare.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblFormularDeInregistrare.setBounds(112, 121, 233, 28);
		contentPane.add(lblFormularDeInregistrare);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RegisterForm.class.getResource("/img/iconfinder_coronovirus_02_5826047.png")));
		lblNewLabel_1.setBounds(0, 29, 207, 120);
		contentPane.add(lblNewLabel_1);
		
		JButton btnInregistrare = new JButton("Inregistrare");
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
		
		txtCodMembru = new JTextField();
		txtCodMembru.setText("Cod Membru");
		txtCodMembru.setBounds(240, 250, 133, 20);
		contentPane.add(txtCodMembru);
		txtCodMembru.setColumns(10);
	}
}
