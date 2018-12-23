import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaTable extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTable frame = new VentanaTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con=null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the frame.
	 */
	public VentanaTable() {
		Bdatos bd= new Bdatos();
		con=bd.con;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JButton btnLoadTable = new JButton("Cargar Tabla");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement st= con.createStatement();
					String query="SELECT * FROM DiaRegistrado3";
					ResultSet rs=st.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		btnLoadTable.setBounds(208, 11, 161, 23);
		contentPane.add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 49, 821, 340);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNuevaBusqueda = new JButton("Nueva busqueda");
		btnNuevaBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				VentanaInicio v2= new VentanaInicio();
				v2.setVisible(true);
			}
		});
		btnNuevaBusqueda.setBounds(542, 11, 135, 23);
		contentPane.add(btnNuevaBusqueda);
		
		textField = new JTextField();
		textField.setBounds(40, 463, 117, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		/*String Idia=String.valueOf(comboInicioDia.getSelectedItem());
		String Imes=String.valueOf(comboInicioMes.getSelectedItem());
		String Ianyo=String.valueOf(comboInicioAno.getSelectedItem());
		String Fdia=String.valueOf(comboFinalDia.getSelectedItem());
		String Fmes=String.valueOf(comboFinalMes.getSelectedItem());
		String Fanyo=String.valueOf(comboFinalAno.getSelectedItem()); 
		*/
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"TempHigh", "TempAvg", "TempLow", "RocioHigh", "RocioAvg", "RocioLow", "HumedadHigh", "HumedadAvg", "HumedadLow", "Precip"}));
		comboBox.setBounds(181, 430, 99, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"TempHigh", "TempAvg", "TempLow", "RocioHigh", "RocioAvg", "RocioLow", "HumedadHigh", "HumedadAvg", "HumedadLow", "Precip"}));
		comboBox_1.setBounds(478, 432, 99, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"TempHigh", "TempAvg", "TempLow", "RocioHigh", "RocioAvg", "RocioLow", "HumedadHigh", "HumedadAvg", "HumedadLow", "Precip"}));
		comboBox_2.setBounds(750, 430, 99, 20);
		contentPane.add(comboBox_2);
	   
		
		JButton btnMedia = new JButton("Media");
		btnMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 String campoMedia= String.valueOf(comboBox.getSelectedItem());
					Statement st= con.createStatement();
					//cast (150.755555 as numeric (16,2))
					String query="SELECT AVG("+campoMedia+") as avg"+campoMedia+" FROM DiaRegistrado3";
					ResultSet rs=st.executeQuery(query);
					Double half= rs.getDouble("avg"+campoMedia);
					half=Math.round(half*100.0)/100.0;
					String halfeado= Double.toString(half);
					textField.setText(halfeado);
				st.close();
				rs.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnMedia.setBounds(42, 429, 115, 23);
		contentPane.add(btnMedia);
		
		textField_1 = new JTextField();
		textField_1.setBounds(353, 463, 115, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		
		JButton btnMaximo = new JButton("Maximo");
		btnMaximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String campoMaximo=String.valueOf(comboBox_1.getSelectedItem());
					Statement st= con.createStatement();
					String query="SELECT MAX("+campoMaximo+") as max"+campoMaximo+" FROM DiaRegistrado3";
					ResultSet rs=st.executeQuery(query);
					String max=rs.getString("max"+campoMaximo);
					textField_1.setText(max);
					st.close();
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnMaximo.setBounds(353, 431, 115, 23);
		contentPane.add(btnMaximo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(625, 465, 115, 29);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		JButton btnMinimo = new JButton("Minimo");
		btnMinimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String campoMin=String.valueOf(comboBox_2.getSelectedItem());
					Statement st= con.createStatement();
					String query="SELECT MIN("+campoMin+") as min"+campoMin+" FROM DiaRegistrado3";
					ResultSet rs=st.executeQuery(query);
					String min=rs.getString("min"+campoMin);
					textField_3.setText(min);
					st.close();
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnMinimo.setBounds(625, 429, 115, 23);
		contentPane.add(btnMinimo);
		
		
		
		
		
		
		
		
		
		
	}
}
