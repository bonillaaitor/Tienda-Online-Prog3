package Tienda;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Inicio extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel opcionesPanel;
	private Box botonBox;
	private JButton iniciarSesionBoton;
	private JButton registrarCuentaBoton;
	
	public Inicio() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());

		botonBox = new Box(BoxLayout.Y_AXIS);
		iniciarSesionBoton = new JButton("Iniciar sesion");
		iniciarSesionBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Login.abrirLogin();
				dispose();
			}
			
		});
		registrarCuentaBoton  = new JButton("Registrarse");
		registrarCuentaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			//crear otro  paquete con empleado cliente persona bici patin... 
				Administrador ad =  null;
				RegistrarCliente.abrirRegistrarCliente(ad);
				dispose();
			}
			
		});
		
		botonBox.add(iniciarSesionBoton);
		botonBox.add(Box.createRigidArea(new Dimension(0,50)));
		botonBox.add(registrarCuentaBoton);
		
		GridBagConstraints g_buttonBox = new GridBagConstraints();
		g_buttonBox.gridx = 0;
		opcionesPanel.add(botonBox, g_buttonBox);
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);

		this.setVisible(true);
		
	}
	
	
	public static void abrirInicio() {
		Inicio inicio = new Inicio();
		inicio.setTitle("Inicio");
		inicio.setSize(500,300);
		inicio.setLocationRelativeTo(null);
		inicio.setVisible(true);
		
	}

}
