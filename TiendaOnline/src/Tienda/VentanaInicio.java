package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bd.Bd;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class VentanaInicio extends JFrame {

	private JPanel contentPanel;
	private JTextField textoUsuario;
	private JPasswordField textoContra;
	private final Action actionBotonRegistroUno = new SwingAction();
	private final Action actionBotonLogin = new botonLogin();
	

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
		botonLogin.setAction(actionBotonLogin);
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
	
	
	public void pruebalogin() {
		Bd bd = new Bd();
		bd.cargarDriver();
		
		String usuario = textoUsuario.getText();
		String pass = new String(textoContra.getPassword());
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/bd/tiendaonline.db");

			// se crea el statemnt a partir de la conexión establecida
			Statement stmt = conn.createStatement();
			// usando el statement se ejecuta la consulta y se obtiene el resultado
			ResultSet rs = stmt.executeQuery("SELECT nombre, password FROM Cliente");

			// se recorre el resulset fila a fila
			while (rs.next()) {
				// se obtienen las columnas
				String password = rs.getString("password");
				String nombre = rs.getString("nombre");
				if (usuario.equals(nombre) && pass.equals(password)) {
					System.out.println("login exitoso");
					
				}else if(rs.next() == false){
					rs.close();
					System.out.println("usuario no encontrado");
				}

				
			}
			
			stmt.close();		
			conn.close(); // es importante desconectar la conexión al terminar

		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos.");
			System.out.println(e.getMessage());
		}
	}
	private class botonLogin extends AbstractAction {
		public botonLogin() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			pruebalogin();
		}
	}
}
