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

public class AllFlightsMemb extends JFrame {
	private JTable table;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel lblSortareDupa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllFlightsMemb frame = new AllFlightsMemb();
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
	private void showData(String order) {
		Connection conn=null;
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Numar zbor");
		model.addColumn("Oras de plecare");
		model.addColumn("Destinatie");
		model.addColumn("Ora imbarcarii");
		model.addColumn("Data imbarcarii");
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
			String sql="SELECT * FROM zboruri ORDER BY "+order;
			PreparedStatement pts= conn.prepareStatement(sql);
			ResultSet rs = pts.executeQuery();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id_zbor"),
						rs.getString("oras_de_plecare"),
						rs.getString("destinatie"),
						rs.getString("ora_imbarcare"),
						rs.getString("data_imbarcare"),
						
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
	
	public AllFlightsMemb() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				showData("oras_de_plecare");
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 535);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ToolTip.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 603, 293);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				int id = Integer.parseInt(model.getValueAt(index, 0).toString());
				new EditFlight(id).setVisible(true);
				dispose();
			}
		});
		scrollPane.setViewportView(table);
		JLabel lblListaZborurilorDisponibile = new JLabel("Lista zborurilor disponibile");
		lblListaZborurilorDisponibile.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaZborurilorDisponibile.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblListaZborurilorDisponibile.setBounds(152, 44, 321, 27);
		contentPane.add(lblListaZborurilorDisponibile);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/glob.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(32, 13, 137, 108);
		contentPane.add(lblNewLabel);
		
		lblSortareDupa = new JLabel("Sortare dupa:");
		lblSortareDupa.setHorizontalAlignment(SwingConstants.CENTER);
		lblSortareDupa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSortareDupa.setBounds(328, 441, 95, 16);
		contentPane.add(lblSortareDupa);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aux=comboBox.getSelectedItem().toString();
				if(aux.equals("oras de plecare"))
					showData("oras_de_plecare");
				else if(aux.equals("destinatie"))
					showData("destinatie");
				else if(aux.equals("data imbarcarii"))
					showData("data_imbarcare");
				else if(aux.equals("ora imbarcarii"))
					showData("ora_imbarcare");
			}
		});
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"oras de plecare", "destinatie", "data imbarcarii", "ora imbarcarii"}));
		comboBox.setBounds(433, 438, 179, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Adauga zbor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddFlight().setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(32, 437, 115, 23);
		contentPane.add(btnNewButton);
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CompanysPage().setVisible(true);
				dispose();
			}
		});
		btnInapoi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnInapoi.setBounds(166, 437, 115, 23);
		contentPane.add(btnInapoi);
	}
}
