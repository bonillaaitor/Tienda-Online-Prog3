package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class VentanaEliminarCuenta extends JFrame {

	private JPanel contentPanelEliminarCuenta;
	private JTextField textoUsuario;
	private JTextField textoPassword;
	private final Action actionBotonAtras = new botonAtras();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEliminarCuenta frame = new VentanaEliminarCuenta();
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
	public VentanaEliminarCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelEliminarCuenta = new JPanel();
		contentPanelEliminarCuenta.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelEliminarCuenta);
		contentPanelEliminarCuenta.setLayout(null);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(445, 182, 142, 20);
		contentPanelEliminarCuenta.add(textoUsuario);
		textoUsuario.setColumns(10);
		
		textoPassword = new JTextField();
		textoPassword.setBounds(445, 236, 142, 20);
		contentPanelEliminarCuenta.add(textoPassword);
		textoPassword.setColumns(10);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(311, 185, 46, 14);
		contentPanelEliminarCuenta.add(labelUsuario);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setBounds(311, 239, 66, 14);
		contentPanelEliminarCuenta.add(labelPassword);
		
		JLabel labelTitulo = new JLabel("Introduce tu cuenta para eliminarla");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelTitulo.setBounds(276, 39, 422, 41);
		contentPanelEliminarCuenta.add(labelTitulo);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setAction(actionBotonAtras);
		botonAtras.setBounds(595, 443, 89, 23);
		contentPanelEliminarCuenta.add(botonAtras);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(314, 443, 89, 23);
		contentPanelEliminarCuenta.add(botonEliminar);
	}
	private class botonAtras extends AbstractAction {
		public botonAtras() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "Volver a la ventana cliente");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaInicio ventanaInicio = new VentanaInicio();
			ventanaInicio.setVisible(true);
			dispose();
		}
	}
}
