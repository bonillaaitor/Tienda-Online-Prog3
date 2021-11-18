package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import Bd.Bd;

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
	private final Action actionBotonAtras = new SwingAction();
	private final Action actionBotonDosRegistro = new SwingAction_1();

	public VentanaRegistro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 564);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(70, 80, 46, 14);
		contentPanel.add(labelNombre);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(70, 125, 46, 14);
		contentPanel.add(labelUsuario);

		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setBounds(70, 170, 80, 14);
		contentPanel.add(labelPassword);

		JLabel labelCorreo = new JLabel("Correo");
		labelCorreo.setBounds(70, 215, 46, 14);
		contentPanel.add(labelCorreo);

		JLabel labelDireccion = new JLabel("Direccion");
		labelDireccion.setBounds(70, 260, 80, 14);
		contentPanel.add(labelDireccion);

		JLabel labelTelefono = new JLabel("Telefono");
		labelTelefono.setBounds(70, 305, 80, 14);
		contentPanel.add(labelTelefono);

		JLabel labelTarjeta = new JLabel("Tarjeta\r\n");
		labelTarjeta.setBounds(70, 350, 46, 14);
		contentPanel.add(labelTarjeta);

		JButton botonRegistroDos = new JButton("Registrarme");
		botonRegistroDos.setAction(actionBotonDosRegistro);
		botonRegistroDos.setBounds(98, 409, 101, 23);
		contentPanel.add(botonRegistroDos);

		JButton botonAtras = new JButton("Atras");
		botonAtras.setAction(actionBotonAtras);
		botonAtras.setBounds(236, 409, 101, 23);
		contentPanel.add(botonAtras);

		textoNombre = new JTextField();
		textoNombre.setBounds(155, 78, 164, 20);
		contentPanel.add(textoNombre);
		textoNombre.setColumns(10);

		textoUsuario = new JTextField();
		textoUsuario.setBounds(155, 123, 164, 20);
		contentPanel.add(textoUsuario);
		textoUsuario.setColumns(10);

		textoPassword = new JTextField();
		textoPassword.setBounds(155, 168, 164, 20);
		contentPanel.add(textoPassword);
		textoPassword.setColumns(10);

		textoCorreo = new JTextField();
		textoCorreo.setBounds(155, 213, 164, 20);
		contentPanel.add(textoCorreo);
		textoCorreo.setColumns(10);

		textoDireccion = new JTextField();
		textoDireccion.setBounds(155, 258, 164, 20);
		contentPanel.add(textoDireccion);
		textoDireccion.setColumns(10);

		textoTelefono = new JTextField();
		textoTelefono.setBounds(155, 303, 164, 20);
		contentPanel.add(textoTelefono);
		textoTelefono.setColumns(10);

		textoTarjeta = new JTextField();
		textoTarjeta.setBounds(155, 348, 164, 20);
		contentPanel.add(textoTarjeta);
		textoTarjeta.setColumns(10);

		JLabel labelRegistro = new JLabel("Registrate en nuestra tienda online");
		labelRegistro.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
		labelRegistro.setBounds(59, 10, 387, 30);
		contentPanel.add(labelRegistro);

	}

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

	

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "Ir a la ventana de atras");
		}

		public void actionPerformed(ActionEvent e) {
			VentanaInicio ventanaInicio = new VentanaInicio();
			ventanaInicio.setVisible(true);
			dispose();
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Registro");
			putValue(SHORT_DESCRIPTION, "Registrar cliente");
		}

		public void actionPerformed(ActionEvent e) {
			comprobarVacios();
			pruebaExportarCsv();
			
		}
	}

	// Prueba funcional de inserts en la base de datos
	public void pruebaBD() {

		Bd bd = new Bd();
		bd.cargarDriver();

		String usuario = textoUsuario.getText();
		String pass = new String(textoPassword.getText());
		;
		String correo = textoCorreo.getText();
		String nombre = textoNombre.getText();
		String tarjeta = textoTarjeta.getText();
		String direccion = textoDireccion.getText();
		String telefono = textoTelefono.getText();

		Cliente c = new Cliente(nombre, usuario, pass, correo, direccion, telefono, tarjeta);

		// Crer metodo aparte para la creacion de los objetos
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/bd/tiendaonline.db");
			try (Scanner scanner = new Scanner(System.in)) {
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO Cliente (email, password, nombre, direccion, telefono, num_tarjeta) VALUES (?, ?, ?, ?, ?, ?)");

				stmt.setString(1, c.getGmail());
				stmt.setString(2, c.getPassword());
				stmt.setString(3, c.getNombre());
				stmt.setString(4, c.getDireccion());
				stmt.setString(5, c.getTelefono());
				stmt.setString(6, c.getTarjeta());

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
	public void pruebaExportarCsv() {

		Bd bd = new Bd();
		bd.cargarDriver();
		String csvFilePath = "TiendaOnline/bd/Clientes.csv";

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/bd/tiendaonline.db");

			// se crea el statemnt a partir de la conexión establecida
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
			conn.close(); // es importante desconectar la conexión al terminar

		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos.");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("File IO error:");
			e.printStackTrace();
		}

	}
}
