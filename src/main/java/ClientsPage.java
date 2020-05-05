import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ClientsPage extends JFrame {
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
					ClientsPage frame = new ClientsPage();
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
		model.addColumn("Numarul zborului");
		model.addColumn("Oras de plecare");
		model.addColumn("Destinatie");
		model.addColumn("Ora de imbarcare");
		model.addColumn("Data imbarcarii");
		model.addColumn("Locuri disponibile");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate","root","");
			String sql="SELECT * FROM zboruri ";
			PreparedStatement pts= conn.prepareStatement(sql);
			ResultSet rs = pts.executeQuery();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id_zbor"),
						rs.getString("oras_de_plecare"),
						rs.getString("destinatie"),
						rs.getString("ora_imbarcare"),
						rs.getString("data_imbarcare"),
						rs.getString("locuri_disp")
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
			table.getColumnModel().getColumn(5).setPreferredWidth(120);
			table.getColumnModel().getColumn(6).setPreferredWidth(120);
			table.getColumnModel().getColumn(7).setPreferredWidth(120);
			
		}
		catch(Exception e) {
			System.out.println("eroare"+e);
		}
		
	}
	public ClientsPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				showData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 533);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ToolTip.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 134, 726, 293);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblListaZborurilorDisponibile = new JLabel("Lista zborurilor disponibile");
		lblListaZborurilorDisponibile.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaZborurilorDisponibile.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblListaZborurilorDisponibile.setBounds(217, 44, 321, 27);
		contentPane.add(lblListaZborurilorDisponibile);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/glob.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(32, 13, 137, 108);
		contentPane.add(lblNewLabel);
		
		lblSortareDupa = new JLabel("Sortare dupa:");
		lblSortareDupa.setHorizontalAlignment(SwingConstants.CENTER);
		lblSortareDupa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSortareDupa.setBounds(449, 443, 95, 16);
		contentPane.add(lblSortareDupa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"oras de plecare", "destinatie", "data imbarcarii", "ora imbarcarii"}));
		comboBox.setBounds(559, 440, 179, 22);
		contentPane.add(comboBox);
	}
}
