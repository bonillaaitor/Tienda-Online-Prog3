package Tienda;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;




public class Bienvenida extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private Fondo fondo;
	private JLabel bienvenido;
	private JButton aceptarBoton;
	
	
	public Bienvenida() {
		this.setTitle("Bienvenido");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		try {
												//poner el .png
			 fondo = new Fondo(ImageIO.read(new File("")));
			 panel = (JPanel) this.getContentPane();
			 
			 bienvenido = new  JLabel("Bienvido a la tienda");
			 bienvenido.setVerticalAlignment(SwingConstants.CENTER);
			 bienvenido.setHorizontalAlignment(SwingConstants.CENTER);
			 
			 aceptarBoton = new JButton ("Aceptar");
			 aceptarBoton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Inicio.abrirInicio();
					dispose();
					
				}
			 });
			 
				getContentPane().add(bienvenido, BorderLayout.CENTER);
				getContentPane().add(aceptarBoton, BorderLayout.SOUTH);
				panel.setBorder((fondo));
		
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		this.setVisible(true);
		
		
	}
	
	public static void  abrirBienvenida() {
		Bienvenida bienvenida = new Bienvenida();
		bienvenida.setVisible(true);
		bienvenida.setSize(500,300);
		bienvenida.setLocationRelativeTo(null);
		bienvenida.setVisible(true);
	}
	
	
}
