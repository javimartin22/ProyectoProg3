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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCodigos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCodigos frame = new VentanaCodigos();
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
	public VentanaCodigos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		
		JLabel lblCodigosDeAeropuertos = new JLabel("Codigos de Estaciones");
		lblCodigosDeAeropuertos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigosDeAeropuertos.setBounds(73, 11, 218, 33);
		contentPane.add(lblCodigosDeAeropuertos);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(266, 11, 62, 33);
		contentPane.add(lblNewLabel);
		
		ImageIcon imag=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("14122.png")));
		Image img1=imag.getImage();
		Image img2=img1.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon im=new ImageIcon(img2);
		lblNewLabel.setIcon(im);
		
		JLabel lblNewLabel_1 = new JLabel("Bilbao");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(36, 65, 74, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblBarcelona = new JLabel("Barcelona");
		lblBarcelona.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBarcelona.setBounds(36, 103, 74, 23);
		contentPane.add(lblBarcelona);
		
		JLabel lblMadrid = new JLabel("Madrid");
		lblMadrid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMadrid.setBounds(36, 138, 74, 23);
		contentPane.add(lblMadrid);
		
		JLabel lblSevilla = new JLabel("Sevilla");
		lblSevilla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSevilla.setBounds(36, 172, 74, 23);
		contentPane.add(lblSevilla);
		
		JLabel lblValencia = new JLabel("Valencia");
		lblValencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValencia.setBounds(36, 206, 74, 23);
		contentPane.add(lblValencia);
		
		JLabel lblLebb = new JLabel("LEBB");
		lblLebb.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLebb.setBounds(142, 65, 74, 23);
		contentPane.add(lblLebb);
		
		JLabel lblLebl = new JLabel("LEBL");
		lblLebl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLebl.setBounds(142, 103, 74, 23);
		contentPane.add(lblLebl);
		
		JLabel lblLemd = new JLabel("LEMD");
		lblLemd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLemd.setBounds(142, 138, 74, 23);
		contentPane.add(lblLemd);
		
		JLabel lblLezl = new JLabel("LEZL");
		lblLezl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLezl.setBounds(142, 172, 74, 23);
		contentPane.add(lblLezl);
		
		JLabel lblLevc = new JLabel("LEVC");
		lblLevc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLevc.setBounds(142, 206, 74, 23);
		contentPane.add(lblLevc);
		
		JLabel lblWunder = new JLabel("New label");
		lblWunder.setBounds(275, 76, 124, 50);
		contentPane.add(lblWunder);
		

		ImageIcon imag2=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("wundergroundLogo_4c_rev.jpg")));
		Image img12=imag2.getImage();
		Image img22=img12.getScaledInstance(lblWunder.getWidth(), lblWunder.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon im2=new ImageIcon(img22);
		lblWunder.setIcon(im2);
		
		JLabel lblNewLabel_2 = new JLabel("Mas codigos en Wunderground");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(243, 135, 181, 33);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Menu Principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaInicio vi= new VentanaInicio();
				vi.setVisible(true);
			}
		});
		btnNewButton.setBounds(266, 191, 133, 33);
		contentPane.add(btnNewButton);
	}
}
