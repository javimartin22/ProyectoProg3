import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource.CompoundBorderUIResource;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Font;


public class VentanaInicio extends JFrame {

	public JPanel contentPane;
	public JTextField txtCiudad;
	public JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
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
	public VentanaInicio() {
		setTitle("NUEVA BUSQUEDA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(23, 24, 123, 31);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final");
		lblFechaFinal.setBounds(23, 79, 76, 23);
		contentPane.add(lblFechaFinal);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(24, 123, 64, 23);
		contentPane.add(lblCiudad);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(23, 167, 65, 23);
		contentPane.add(lblCodigo);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(147, 124, 98, 20);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(147, 168, 98, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		
		
		JComboBox comboInicioAno = new JComboBox();
		comboInicioAno.setModel(new DefaultComboBoxModel(new String[] {"2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007"}));
		comboInicioAno.setToolTipText("");
		comboInicioAno.setBounds(301, 29, 88, 20);
		contentPane.add(comboInicioAno);
		
		JComboBox comboInicioMes = new JComboBox();
		comboInicioMes.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboInicioMes.setBounds(205, 29, 88, 20);
		contentPane.add(comboInicioMes);
		
		JComboBox comboInicioDia = new JComboBox();
		comboInicioDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboInicioDia.setBounds(112, 29, 69, 20);
		contentPane.add(comboInicioDia);
		
		JComboBox comboFinalDia = new JComboBox();
		comboFinalDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboFinalDia.setBounds(112, 80, 69, 20);
		contentPane.add(comboFinalDia);
		
		JComboBox comboFinalMes = new JComboBox();
		comboFinalMes.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboFinalMes.setBounds(205, 80, 88, 20);
		contentPane.add(comboFinalMes);
		
		JComboBox comboFinalAno = new JComboBox();
		comboFinalAno.setModel(new DefaultComboBoxModel(new String[] {"2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007"}));
		comboFinalAno.setToolTipText("");
		comboFinalAno.setBounds(303, 80, 88, 20);
		contentPane.add(comboFinalAno);
		
		JButton btnBusqueda = new JButton("Realizar busqueda");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Idia=String.valueOf(comboInicioDia.getSelectedItem());
				String Imes=String.valueOf(comboInicioMes.getSelectedItem());
				String Ianyo=String.valueOf(comboInicioAno.getSelectedItem());
				String Fdia=String.valueOf(comboFinalDia.getSelectedItem());
				String Fmes=String.valueOf(comboFinalMes.getSelectedItem());
				String Fanyo=String.valueOf(comboFinalAno.getSelectedItem());
				String ciudad=txtCiudad.getText();
				String codigo=txtCodigo.getText();
				
				int Iday=Integer.parseInt(Idia);
				int Imonth= Integer.parseInt(Imes);
				Imonth= Imonth-1;
				int Iyear= Integer.parseInt(Ianyo);
				methods met= new methods();
				met.Webscrape(Idia, Imes, Ianyo, Fdia, Fmes, Fanyo,ciudad,codigo,Iday,Imonth,Iyear);
				
				dispose();
				VentanaTable v2= new VentanaTable();
				v2.setVisible(true);
			}
		});
		btnBusqueda.setBounds(280, 211, 144, 23);
		contentPane.add(btnBusqueda);
		
		JButton btnReiniciar = new JButton("Reiniciar BD");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bdatos bd= new Bdatos();
				bd.reiniciarBD();
			}
		});
		btnReiniciar.setBackground(new Color(255, 0, 0));
		btnReiniciar.setBounds(10, 211, 123, 23);
		contentPane.add(btnReiniciar);
		
		JButton btnVerCodigos = new JButton("Ver Codigos");
		btnVerCodigos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				VentanaCodigos vc= new VentanaCodigos();
				vc.setVisible(true);
			}
		});
		btnVerCodigos.setBounds(283, 167, 115, 23);
		contentPane.add(btnVerCodigos);
		
		JButton btnNewButton = new JButton("PREDICCION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  System.out.println(LocalDateTime.now().getDayOfMonth());
				String mesdd=Integer.toString(LocalDateTime.now().getMonthValue());
				
				methods mett=new methods();
				mett.Prediccion("1",mesdd,"2018", "LEBB");
				//dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(64, 224, 208));
		btnNewButton.setBounds(147, 211, 109, 23);
		contentPane.add(btnNewButton);
	}
}
