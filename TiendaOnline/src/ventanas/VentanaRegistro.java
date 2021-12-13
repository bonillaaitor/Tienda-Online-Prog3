package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import bd.Bd;
import models.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPanel;
	private JTextField textoNombre;
	private JTextField textoUsuario;
	private JTextField textoPassword;
	private JTextField textoCorreo;
	private JTextField textoDireccion;
	private JTextField textoTelefono;
	private JTextField textoTarjeta;
	private final Action actionBotonAtras = new botonAtras();
	private final Action actionBotonRegistro = new botonRegistro();

	public VentanaRegistro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(369, 135, 46, 14);
		contentPanel.add(labelNombre);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(370, 176, 46, 14);
		contentPanel.add(labelUsuario);

		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setBounds(350, 217, 80, 14);
		contentPanel.add(labelPassword);

		JLabel labelCorreo = new JLabel("Correo");
		labelCorreo.setBounds(373, 257, 46, 14);
		contentPanel.add(labelCorreo);

		JLabel labelDireccion = new JLabel("Direccion");
		labelDireccion.setBounds(363, 298, 80, 14);
		contentPanel.add(labelDireccion);

		JLabel labelTelefono = new JLabel("Telefono");
		labelTelefono.setBounds(364, 339, 80, 14);
		contentPanel.add(labelTelefono);

		JLabel labelTarjeta = new JLabel("Tarjeta\r\n");
		labelTarjeta.setBounds(371, 380, 46, 14);
		contentPanel.add(labelTarjeta);

		JButton botonRegistroDos = new JButton("Registrarme");
		botonRegistroDos.setAction(actionBotonRegistro);
		botonRegistroDos.setBounds(605, 488, 101, 23);
		contentPanel.add(botonRegistroDos);

		JButton botonAtras = new JButton("Atras");
		botonAtras.setAction(actionBotonAtras);
		botonAtras.setBounds(319, 488, 101, 23);
		contentPanel.add(botonAtras);

		textoNombre = new JTextField();
		textoNombre.setBounds(458, 132, 164, 20);
		contentPanel.add(textoNombre);
		textoNombre.setColumns(10);

		textoUsuario = new JTextField();
		textoUsuario.setBounds(458, 173, 164, 20);
		contentPanel.add(textoUsuario);
		textoUsuario.setColumns(10);

		textoPassword = new JPasswordField();
		textoPassword.setBounds(458, 214, 164, 20);
		contentPanel.add(textoPassword);
		textoPassword.setColumns(10);

		textoCorreo = new JTextField();
		textoCorreo.setBounds(458, 254, 164, 20);
		contentPanel.add(textoCorreo);
		textoCorreo.setColumns(10);

		textoDireccion = new JTextField();
		textoDireccion.setBounds(458, 295, 164, 20);
		contentPanel.add(textoDireccion);
		textoDireccion.setColumns(10);

		textoTelefono = new JTextField();
		textoTelefono.setBounds(458, 336, 164, 20);
		contentPanel.add(textoTelefono);
		textoTelefono.setColumns(10);

		textoTarjeta = new JTextField();
		textoTarjeta.setBounds(458, 377, 164, 20);
		contentPanel.add(textoTarjeta);
		textoTarjeta.setColumns(10);

		JLabel labelRegistro = new JLabel("Registrate en nuestra tienda online");
		labelRegistro.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelRegistro.setBounds(296, 40, 563, 41);
		contentPanel.add(labelRegistro);

	}
	//Funcionalidad del boton para ir a la ventana de inicio
	private class botonAtras extends AbstractAction {
		public botonAtras() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "Ir a la ventana de inicio");
		}

		public void actionPerformed(ActionEvent e) {
			VentanaInicio ventanaInicio = new VentanaInicio();
			ventanaInicio.setVisible(true);
			dispose();
		}
	}
	//Funcionalidad del boton para registrar un cliente en la base de datos
	private class botonRegistro extends AbstractAction {
		public botonRegistro() {
			putValue(NAME, "Registro");
			putValue(SHORT_DESCRIPTION, "Registro de cliente en la tienda");
		}

		public void actionPerformed(ActionEvent e) {
			comprobarVacios();
			registroCliente();			
		}
	}
	//Metodo para comprobar que todos los campos del registro se han rellenado correctamente
	private void comprobarVacios() {
	
		String nombre = textoNombre.getText().toString();
		String usuario = textoUsuario.getText().toString();
		String telefono = textoTelefono.getText().toString();
		
		if (textoNombre.getText().equals("") || textoUsuario.getText().equals("") || textoPassword.toString().equals("")
				|| textoCorreo.getText().equals("") || textoDireccion.toString().equals("")
				|| textoTelefono.getText().equals("") || textoTarjeta.toString().equals("")) {

			JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos.", "Error",JOptionPane.INFORMATION_MESSAGE);
			VentanaRegistro.this.repaint();
		
		} else if (nombre.matches("^[0-9]+$")) {

			JOptionPane.showMessageDialog(null, "Nombre no válido.", "Error",JOptionPane.INFORMATION_MESSAGE);
			VentanaRegistro.this.repaint();

		} else if (usuario.matches("^[0-9]+$")) {

			JOptionPane.showMessageDialog(null, "Usuario no válido.", "Error",JOptionPane.INFORMATION_MESSAGE);
			VentanaRegistro.this.repaint();

		
		} else if (!textoCorreo.getText().contains("@") || !(textoCorreo.getText().contains(".es")
				|| textoCorreo.getText().contains(".com") || textoCorreo.getText().contains(".eus"))) {

			JOptionPane.showMessageDialog(null, "Email no válido.", "Error",JOptionPane.INFORMATION_MESSAGE);
			VentanaRegistro.this.repaint();
			
		} else if (telefono.matches("^[a-zA-Z]+$")) {

			JOptionPane.showMessageDialog(null, "Telefono no válido.", "Error",JOptionPane.INFORMATION_MESSAGE);
			VentanaRegistro.this.repaint();

		} else {
			
			JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.", "Nuevo cliente",JOptionPane.INFORMATION_MESSAGE);
			VentanaRegistro.this.dispose();
			VentanaInicio ventanaInicio = new VentanaInicio();
			ventanaInicio.setVisible(true);
		}		
	}

	// Prueba funcional de inserts en la base de datos
	public void registroCliente() {

		Bd bd = new Bd();
		bd.cargarDriver();

		String usuario = new String(textoUsuario.getText());
		String pass = new String(textoPassword.getText());
		String correo = textoCorreo.getText();
		String nombre = textoNombre.getText();
		String tarjeta = textoTarjeta.getText();
		String direccion = textoDireccion.getText();
		String telefono = textoTelefono.getText();

		Cliente c = new Cliente(nombre, correo, direccion, telefono, usuario, pass, tarjeta);

		// Crer metodo aparte para la creacion de los objetos
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
			try (Scanner scanner = new Scanner(System.in)) {
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO Cliente (nombre, usuario, password, email, direccion, telefono, num_tarjeta) VALUES (?, ?, ?, ?, ?, ?, ?)");

				stmt.setString(1, c.getNombre());
				stmt.setString(2, c.getUsuario());
				stmt.setString(3, c.getPassword());
				stmt.setString(4, c.getGmail());
				stmt.setString(5, c.getDireccion());
				stmt.setString(6, c.getTelefono()); 
				stmt.setString(7, c.getTarjeta()); 

				stmt.executeUpdate();
				stmt.close();
			}

			conn.close();

		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos.");
			System.out.println(e.getMessage());
		}
	}
	
	
}
