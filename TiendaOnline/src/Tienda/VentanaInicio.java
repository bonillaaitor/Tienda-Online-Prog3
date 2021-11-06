package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class VentanaInicio extends JFrame {

	private JPanel contentPanel;
	private JTextField textoUsuario;
	private JPasswordField textoContra;
	private final Action actionBotonRegistroUno = new SwingAction();
	

	public VentanaInicio() {
		
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 350);
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(117, 86, 62, 20);
		contentPanel.add(labelUsuario);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(216, 86, 150, 20);
		contentPanel.add(textoUsuario);
		textoUsuario.setColumns(10);
		
		textoContra = new JPasswordField();
		textoContra.setBounds(216, 136, 150, 20);
		contentPanel.add(textoContra);
		
		JLabel labelContra = new JLabel("Password");
		labelContra.setBounds(117, 138, 62, 17);
		contentPanel.add(labelContra);
		
		JButton botonLogin = new JButton("Login");
		botonLogin.setBounds(131, 202, 89, 23);
		contentPanel.add(botonLogin);
		
		JButton botonRegistroUno = new JButton("Registro");
		botonRegistroUno.setAction(actionBotonRegistroUno);
		botonRegistroUno.setBounds(265, 202, 89, 23);
		contentPanel.add(botonRegistroUno);
		
		JLabel labelBienvenida = new JLabel("BIENVENIDO A NUESTRA TIENDA ONLINE!");
		labelBienvenida.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
		labelBienvenida.setBounds(59, 28, 387, 20);
		contentPanel.add(labelBienvenida);
	}
	
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Registro");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaRegistro ventanaRegistro = new VentanaRegistro();
			ventanaRegistro.setVisible(true);
			dispose();
			
		}
	}
}
