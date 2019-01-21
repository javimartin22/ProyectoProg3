import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.Color;

public class VentanaPrediccion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_1;
	private JLabel lblTempMinima;
	private JLabel lblHumedad;
	private JLabel lblProbLluvia;
	private JLabel lblpic2;
	private JLabel lblpic1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrediccion frame = new VentanaPrediccion(0,0,0,0);
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
	public VentanaPrediccion(int tempmax,int templow,int humedadavg,int problluvia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prediccion ma\u00F1ana");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(86, 11, 205, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setForeground(Color.RED);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(170, 54, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		String max= Integer.toString(tempmax);
		textField.setText(max+"ºC");
		
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.CYAN);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setBounds(170, 102, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		String min=Integer.toString(templow);
		textField_1.setText(min+"ºC");
		
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.GRAY);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setBounds(170, 155, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		String humed= Integer.toString(humedadavg);
		textField_2.setText(humed+"%");
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.ORANGE);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setBounds(170, 203, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		String prob= Integer.toString(problluvia);
		textField_3.setText(prob+"%");
		
		lblNewLabel_1 = new JLabel("Temp Maxima");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 54, 110, 20);
		contentPane.add(lblNewLabel_1);
		
		lblTempMinima = new JLabel("Temp Minima");
		lblTempMinima.setForeground(Color.CYAN);
		lblTempMinima.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTempMinima.setBounds(22, 102, 110, 20);
		contentPane.add(lblTempMinima);
		
		lblHumedad = new JLabel("Humedad");
		lblHumedad.setForeground(Color.GRAY);
		lblHumedad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHumedad.setBounds(22, 155, 110, 20);
		contentPane.add(lblHumedad);
		
		lblProbLluvia = new JLabel("Prob Lluvia");
		lblProbLluvia.setForeground(Color.ORANGE);
		lblProbLluvia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProbLluvia.setBounds(22, 203, 110, 20);
		contentPane.add(lblProbLluvia);
		
		lblpic2 = new JLabel("oo");
		lblpic2.setBounds(287, 155, 137, 76);
		contentPane.add(lblpic2);
		
		lblpic1 = new JLabel("New label");
		lblpic1.setBounds(287, 48, 137, 82);
		contentPane.add(lblpic1);
		/*ImageIcon imag2=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("wundergroundLogo_4c_rev.jpg")));
		Image img12=imag2.getImage();
		Image img22=img12.getScaledInstance(lblWunder.getWidth(), lblWunder.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon im2=new ImageIcon(img22);
		lblWunder.setIcon(im2);
		*/
		ImageIcon imax2=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("clipart-thermometer-summer-heat-10.png")));
		Image imx1=imax2.getImage();
		Image imx22=imx1.getScaledInstance(lblpic1.getWidth(), lblpic1.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon ix3=new ImageIcon(imx22);
		lblpic1.setIcon(ix3);
		
		ImageIcon imax22=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("15_heavy_rain-512.png")));
		Image imx12=imax22.getImage();
		Image imx222=imx12.getScaledInstance(lblpic2.getWidth(), lblpic2.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon ix32=new ImageIcon(imx222);
		lblpic2.setIcon(ix32);
	}
}
