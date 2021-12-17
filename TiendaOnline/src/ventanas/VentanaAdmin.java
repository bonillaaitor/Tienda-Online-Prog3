package ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.Bd;
import models.Administrador;
import models.Cliente;

public class VentanaAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentAdmin;
	private final Action actionCerrarSesion = new botonCerrarSesion();
	private final Action anyadirStock = new botonAnyadirStock();
	private final Action importarClientes = new botonImportarClientes();
	private final Action exportarClientes = new botonExportarClientes();
	private final Action verPedidos = new botonVerPedidos();
	protected Administrador ad;
	
	public VentanaAdmin(Administrador a) {
		ad = a;
		setTitle("ventana Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentAdmin = new JPanel();
		contentAdmin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentAdmin);
		contentAdmin.setLayout(null);

		JButton botonCerrarSesion = new JButton("Cerrar Sesion");
		botonCerrarSesion.setAction(actionCerrarSesion);
		botonCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonCerrarSesion.setBounds(800, 459, 125, 23);
		contentAdmin.add(botonCerrarSesion);

		JButton botonVerPedidos = new JButton("Ver Pedidos");
		botonVerPedidos.setAction(verPedidos);
		botonVerPedidos.setBounds(428, 151, 151, 23);
		contentAdmin.add(botonVerPedidos);

		JButton botonImportarClientes = new JButton("Importar Clientes");
		botonImportarClientes.setAction(importarClientes);
		botonImportarClientes.setBounds(428, 202, 151, 23);
		contentAdmin.add(botonImportarClientes);

		JButton botonAnyadirStock = new JButton("Añadir Stock");
		botonAnyadirStock.setAction(anyadirStock);
		botonAnyadirStock.setBounds(428, 253, 151, 23);
		contentAdmin.add(botonAnyadirStock);

		JButton botonExportarClientes = new JButton("Exportar Clientes");
		botonExportarClientes.setBounds(428, 304, 151, 23);
		botonExportarClientes.setAction(exportarClientes);
		contentAdmin.add(botonExportarClientes);

		JLabel labelTitulo = new JLabel("Menu Administrador");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelTitulo.setBounds(384, 38, 281, 35);
		contentAdmin.add(labelTitulo);
		
		JButton botonNuevoCliente = new JButton("Añadir Cliente");
		botonNuevoCliente.setBounds(428, 354, 151, 23);
		contentAdmin.add(botonNuevoCliente);
		
		botonNuevoCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro ventanaRegistro = new VentanaRegistro(a);
				ventanaRegistro.setVisible(true);
				dispose();

			}
		});
	}

	
	private class botonCerrarSesion extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public botonCerrarSesion() {
			putValue(NAME, "Cerrar Sesion");
			putValue(SHORT_DESCRIPTION, "volver al menu de inicio");

		}

		public void actionPerformed(ActionEvent e) {
			VentanaInicio ventanaInicio = new VentanaInicio();
			ventanaInicio.setVisible(true);
			dispose();
		}
	}

	private class botonAnyadirStock extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public botonAnyadirStock() {
			putValue(NAME, "Añadir Stock");
			putValue(SHORT_DESCRIPTION, "Añadir stock de uno o varios productos");
		}

		public void actionPerformed(ActionEvent e) {
			VentanaAnyadirStock ventanaAnyadirStock = new VentanaAnyadirStock(ad);
			ventanaAnyadirStock.setVisible(true);
			dispose();
		}

	}

	private class botonImportarClientes extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public botonImportarClientes() {
			putValue(NAME, "Importar Clientes");
			putValue(SHORT_DESCRIPTION, "Importa los clientes al sistema");
		}

		public void actionPerformed(ActionEvent arg0) {
			importarCliente();
			JOptionPane.showMessageDialog(contentAdmin, "Clientes importados correctamente desde fichero csv en la carpeta files");
		}
	}

	private class botonExportarClientes extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public botonExportarClientes() {
			putValue(NAME, "Exportar Clientes");
			putValue(SHORT_DESCRIPTION, "Exporta los clientes al sistema");
		}

		public void actionPerformed(ActionEvent arg0) {
			exportarCliente();
			JOptionPane.showMessageDialog(contentAdmin, "Clientes exportados correctamente a csv en carpeta files");
		}
	}
	
	private class botonVerPedidos extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public botonVerPedidos() {
			putValue(NAME, "Ver Pedidos");
			putValue(SHORT_DESCRIPTION, "Mostrar los pedidos de todos los usuarios");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaVerPedidosAdmin VentanaVerPedidosAdmin = new VentanaVerPedidosAdmin(ad);
			VentanaVerPedidosAdmin.setVisible(true);
			dispose();
		}
	}

	public void exportarCliente() {

		Bd bd = new Bd();
		bd.cargarDriver();
		String csvFilePath = "TiendaOnline/files/Clientes.csv";

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");

			// se crea el statemnt a partir de la conexión establecida
			Statement stmt = conn.createStatement();
			// usando el statement se ejecuta la consulta y se obtiene el resultado
			ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente");

			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
			fileWriter.write("nombre,usuario,password,email,direccion,telefono,num_tarjeta");
			// se recorre el resulset fila a fila
			while (rs.next()) {
				// se obtienen las columnas
				String gmail = rs.getString("email");
				String password = rs.getString("password");
				String nombre = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				String telefono = rs.getString("telefono");
				String tarjeta = rs.getString("num_tarjeta");
				String usuario = rs.getString("usuario");

				String line = String.format("%s,%s,%s,%s,%s,%s,%s", nombre, usuario, password, gmail, direccion,
						telefono, tarjeta);

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

	public void importarCliente() {

		List<Cliente> clientes = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("TiendaOnline/files/ClientesAnadir.csv"))) {
			// leemos la primera línea y la ignoramos
			reader.readLine();

			String linea = null;
			while ((linea = reader.readLine()) != null) {
				// partimos la línea en partes por el delimitador
				String[] campos = linea.split(",");

				// obtenemos cada campo del registro y lo convertimos
				// al formato en el que se va a almacenar en el usuario
				String nombre = campos[0]; 
				String usuario = campos[3]; 
				String password = campos[4]; 
				String gmail = campos[5]; 
				String direccion = campos[1]; 
				String telefono = campos[2]; 
				String tarjeta = campos[6]; 

				// creamos un usuario nuevo con los datos y
				// lo añadimos a la lista de usuarios
				Cliente c = new Cliente(nombre, usuario, password, gmail, direccion, telefono, tarjeta);
				System.out.println(c);
				clientes.add(c);
			}
		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero CSV.");
		}
		
		Bd bd = new Bd();
		bd.cargarDriver();

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
			try (Scanner scanner = new Scanner(System.in)) {
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO Cliente (nombre, usuario, password, email, direccion, telefono, num_tarjeta) VALUES (?, ?, ?, ?, ?, ?, ?)");
				for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
					Cliente cliente = (Cliente) iterator.next();
					stmt.setString(1, cliente.getNombre());
					stmt.setString(2, cliente.getUsuario());
					stmt.setString(3, cliente.getPassword());
					stmt.setString(4, cliente.getGmail());
					stmt.setString(5, cliente.getDireccion());
					stmt.setString(6, cliente.getTelefono());
					stmt.setString(7, cliente.getTarjeta());

					stmt.executeUpdate();
				}

				stmt.close();
			}

			conn.close();

		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos.");
			System.out.println(e.getMessage());
		}

	}
	
}
