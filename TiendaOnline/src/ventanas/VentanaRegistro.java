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
		labelNombre.setBounds(297, 122, 46, 14);
		contentPanel.add(labelNombre);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(297, 163, 46, 14);
		contentPanel.add(labelUsuario);

		JLabel labelPassword = new JLabel("Contrase�a");
		labelPassword.setBounds(297, 196, 80, 14);
		contentPanel.add(labelPassword);

		JLabel labelCorreo = new JLabel("Correo");
		labelCorreo.setBounds(297, 241, 46, 14);
		contentPanel.add(labelCorreo);

		JLabel labelDireccion = new JLabel("Direccion");
		labelDireccion.setBounds(297, 286, 80, 14);
		contentPanel.add(labelDireccion);

		JLabel labelTelefono = new JLabel("Telefono");
		labelTelefono.setBounds(297, 332, 80, 14);
		contentPanel.add(labelTelefono);

		JLabel labelTarjeta = new JLabel("Tarjeta\r\n");
		labelTarjeta.setBounds(297, 372, 46, 14);
		contentPanel.add(labelTarjeta);

		JButton botonRegistroDos = new JButton("Registrarme");
		botonRegistroDos.setAction(actionBotonRegistro);
		botonRegistroDos.setBounds(335, 455, 101, 23);
		contentPanel.add(botonRegistroDos);

		JButton botonAtras = new JButton("Atras");
		botonAtras.setAction(actionBotonAtras);
		botonAtras.setBounds(570, 455, 101, 23);
		contentPanel.add(botonAtras);

		textoNombre = new JTextField();
		textoNombre.setBounds(422, 119, 164, 20);
		contentPanel.add(textoNombre);
		textoNombre.setColumns(10);

		textoUsuario = new JTextField();
		textoUsuario.setBounds(422, 160, 164, 20);
		contentPanel.add(textoUsuario);
		textoUsuario.setColumns(10);

		textoPassword = new JPasswordField();
		textoPassword.setBounds(422, 196, 164, 20);
		contentPanel.add(textoPassword);
		textoPassword.setColumns(10);

		textoCorreo = new JTextField();
		textoCorreo.setBounds(422, 238, 164, 20);
		contentPanel.add(textoCorreo);
		textoCorreo.setColumns(10);

		textoDireccion = new JTextField();
		textoDireccion.setBounds(422, 283, 164, 20);
		contentPanel.add(textoDireccion);
		textoDireccion.setColumns(10);

		textoTelefono = new JTextField();
		textoTelefono.setBounds(422, 329, 164, 20);
		contentPanel.add(textoTelefono);
		textoTelefono.setColumns(10);

		textoTarjeta = new JTextField();
		textoTarjeta.setBounds(422, 369, 164, 20);
		contentPanel.add(textoTarjeta);
		textoTarjeta.setColumns(10);

		JLabel labelRegistro = new JLabel("Registrate en nuestra tienda online");
		labelRegistro.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelRegistro.setBounds(264, 11, 563, 41);
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
			VentanaInicio ventanaInicio = new VentanaInicio();
			ventanaInicio.setVisible(true);
			dispose();
			
		}
	}
	//Metodo para comprobar los vacios de los campos de texto
	private boolean comprobarVacios() {
		if (textoUsuario.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca un nombre de usuario");
			return true;
		}

		if (new String(textoPassword.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca una password");
			return true;
		}

		if (new String(textoCorreo.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca un email de contacto");
			return true;
		}

		if (new String(textoNombre.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca su nombre");
			return true;
		}

		if (new String(textoTarjeta.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca su nombre");
			return true;
		}

		if (new String(textoDireccion.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca su nombre");
			return true;
		}

		return false;
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
	
	//Prueba funcional de exportar datos de la bd a un csv
	public void exportarCliente() {

		Bd bd = new Bd();
		bd.cargarDriver();
		String csvFilePath = "TiendaOnline/bd/Clientes.csv";

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");

			// se crea el statemnt a partir de la conexi�n establecida
			Statement stmt = conn.createStatement();
			// usando el statement se ejecuta la consulta y se obtiene el resultado
			ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente");

			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
			fileWriter.write("email,password,nombre,direccion,telefono,num_tarjeta");
			// se recorre el resulset fila a fila
			while (rs.next()) {
				// se obtienen las columnas
				String gmail = rs.getString("email");
				String password = rs.getString("password");
				String nombre = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				String telefono = rs.getString("telefono");
				String tarjeta = rs.getString("num_tarjeta");

				String line = String.format("%s,%s,%s,%s,%s,%s", gmail, password, nombre, direccion, telefono, tarjeta);

				fileWriter.newLine();
				fileWriter.write(line);

			}

			rs.close();
			stmt.close();
			fileWriter.close();
			conn.close(); // es importante desconectar la conexi�n al terminar

		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos.");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("File IO error:");
			e.printStackTrace();
		}
		

	}
	
	
}
