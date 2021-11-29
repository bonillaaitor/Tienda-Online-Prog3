package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bd.Bd;
import models.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class VentanaInicio extends JFrame {

	private JPanel contentPanel;
	private JTextField textoUsuario;
	private JPasswordField textoContra;
	private final Action actionBotonRegistro = new botonRegistro();
	private final Action actionBotonLogin = new botonLogin();

	public VentanaInicio() {

		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(338, 222, 62, 20);
		contentPanel.add(labelUsuario);

		textoUsuario = new JTextField();
		textoUsuario.setBounds(433, 222, 150, 20);
		contentPanel.add(textoUsuario);
		textoUsuario.setColumns(10);

		textoContra = new JPasswordField();
		textoContra.setBounds(433, 283, 150, 20);
		contentPanel.add(textoContra);

		JLabel labelContra = new JLabel("Password");
		labelContra.setBounds(338, 285, 62, 17);
		contentPanel.add(labelContra);

		JButton botonLogin = new JButton("Login");
		botonLogin.setAction(actionBotonLogin);
		botonLogin.setBounds(357, 413, 89, 23);
		contentPanel.add(botonLogin);

		JButton botonRegistro = new JButton("Registro");
		botonRegistro.setAction(actionBotonRegistro);
		botonRegistro.setBounds(554, 413, 89, 23);
		contentPanel.add(botonRegistro);

		JLabel labelBienvenida = new JLabel("BIENVENIDO A NUESTRA TIENDA ONLINE!");
		labelBienvenida.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelBienvenida.setBounds(187, 31, 637, 35);
		contentPanel.add(labelBienvenida);
	}

	// Funcionalidad del boton para avanzar a la ventana de registro
	private class botonRegistro extends AbstractAction {
		public botonRegistro() {
			putValue(NAME, "Registro");
			putValue(SHORT_DESCRIPTION, "Abrir la ventana del registro");
		}

		public void actionPerformed(ActionEvent e) {
			VentanaRegistro ventanaRegistro = new VentanaRegistro();
			ventanaRegistro.setVisible(true);
			dispose();

		}
	}

	// Funcionalidad del boton para avanzar a la ventana de cliente o admin
	private class botonLogin extends AbstractAction {
		public botonLogin() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Abrir la ventana del usuario");
		}

		public void actionPerformed(ActionEvent e) {
			
					loginTiendaOnline();
				

			};
			

	public void loginTiendaOnline() {
		Bd bd = new Bd();
		bd.cargarDriver();

		String usuario = new String(textoUsuario.getText());
		String pass = new String(textoContra.getPassword());
		String usuarioAdmin = "admin";
		String passAdmin = "admin";
		System.out.println(usuario);
		System.out.println(pass);
		ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT usuario, password FROM Cliente");

			while (rs.next()) {

				Cliente c = new Cliente();
				c.setUsuario(rs.getString("usuario"));
				c.setPassword(rs.getString("password"));
				listaCliente.add(c);
			}

			for (Iterator iterator = listaCliente.iterator(); iterator.hasNext();) {
				Cliente cliente = (Cliente) iterator.next();
				String usuario2 = cliente.getUsuario();
				String password2 = cliente.getPassword();

				if (usuario2.equals(usuario) && password2.equals(pass)) {
					VentanaCliente ventanaCliente = new VentanaCliente();
					ventanaCliente.setVisible(true);
					dispose();
					break;

				} else if (usuarioAdmin.equals(usuario) && passAdmin.equals(pass)) {
					VentanaAdmin ventanaAdmin = new VentanaAdmin();
					ventanaAdmin.setVisible(true);
					dispose();
					break;
				}
				
				rs.close();
				stmt.close();
				conn.close();
			}

		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos.");
			System.out.println(e.getMessage());
		}
	}

}
}