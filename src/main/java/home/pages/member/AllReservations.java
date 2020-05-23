package home.pages.member;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;

public class AllReservations extends JFrame {
	private JTable table;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllReservations frame = new AllReservations();
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
	private void showData() {
		Connection conn=null;
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("ID_REZERVARE");
		model.addColumn("ID_ZBOR");
		model.addColumn("ID_UTILIZATOR");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
			String sql="SELECT * FROM rezervari";
			PreparedStatement pts= conn.prepareStatement(sql);
			ResultSet rs = pts.executeQuery();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id_rezervare"),
						rs.getString("id_zbor"),
						rs.getString("id_utilizator"),
						
						
				});
				
			}
			rs.close();
			pts.close();
			conn.close();
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(120);
			table.getColumnModel().getColumn(1).setPreferredWidth(120);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
			table.getColumnModel().getColumn(3).setPreferredWidth(120);
			table.getColumnModel().getColumn(4).setPreferredWidth(120);
			
			
		}
		catch(Exception e) {
			System.out.println("eroare"+e);
		}
		
	}
	
	public AllReservations() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				showData();
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 535);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ToolTip.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 379, 293);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				int id = Integer.parseInt(model.getValueAt(index, 2).toString());
				new DisplayInformation(id).setVisible(true);
				dispose();
			}
			
		});
		scrollPane.setViewportView(table);
		JLabel lblListaRezervari = new JLabel("Lista rezervari");
		lblListaRezervari.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaRezervari.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblListaRezervari.setBounds(138, 49, 228, 27);
		contentPane.add(lblListaRezervari);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/glob.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(32, 13, 137, 108);
		contentPane.add(lblNewLabel);
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CompanysPage().setVisible(true);
				dispose();
			}
		});
		btnInapoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInapoi.setBounds(154, 438, 97, 25);
		contentPane.add(btnInapoi);

	}
}
