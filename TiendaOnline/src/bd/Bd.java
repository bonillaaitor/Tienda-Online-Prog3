package bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import models.Cliente;
import ventanas.VentanaInicio;

public class Bd {

	private static final Logger LOG = Logger.getLogger(Bd.class.getName());
	private static final int Pr = 0;

	public void cargarDriver() {
		try {
			Class.forName("org.sqlite.JDBC");
			LOG.log(Level.INFO, "Driver cargado correctamente");
		} catch (ClassNotFoundException e) {
			LOG.log(Level.WARNING, e.getMessage());

		}

	}

	public void establecerConexion() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
			LOG.log(Level.INFO, "Conexion establecida correctamente");

		} catch (SQLException e) {
			LOG.log(Level.WARNING, e.getMessage());
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
			LOG.log(Level.INFO, "Exportacion de clientes realizada con exito");

		} catch (SQLException e) {
			LOG.log(Level.INFO, "Exportacion de clientes fallida");
			LOG.log(Level.WARNING, e.getMessage());
		} catch (IOException e) {
			LOG.log(Level.WARNING, e.getMessage());
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
			LOG.log(Level.INFO, "Exportacion de clientes realizada con exito");
		} catch (IOException e) {
			LOG.log(Level.WARNING, e.getMessage());
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
			LOG.log(Level.INFO, "Importacion de clientes realizada con exito");

		} catch (SQLException e) {
			LOG.log(Level.INFO, "Importacion de clientes fallida");
			LOG.log(Level.WARNING, e.getMessage());

		}

	}

	public static int comprobarUsuario(String usuario, String password) throws SQLException {
		Bd bd = new Bd();
		int resul = 0;
		String s = "SELECT * FROM Cliente WHERE usuario = '" + usuario + "'";

		bd.cargarDriver();
		Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
		try {
			Statement st = conn.createStatement();
			// Una select SIEMPRE devuelve un ResultSet
			ResultSet rs = st.executeQuery(s);
			if (rs.next()) { // Si hemos encontrado el usuario cuyo email coincide con el recibido por
								// parametro
				String contrasenia = rs.getString("password");
				if (contrasenia.equals(password))
					resul = 2;
				else
					resul = 1;
			}
			st.close();
			conn.close();
			LOG.log(Level.INFO, "Query ejecutada correctamente");
		} catch (SQLException e) {
			LOG.log(Level.WARNING, e.getMessage());
		}

		return resul;

	}

	public void cargarModeloB(JComboBox<String> cb) {
		Bd bd = new Bd();
		bd.cargarDriver();

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
			String usuario = new String(VentanaInicio.textoUsuario.getText());

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn.prepareStatement("SELECT Nombre FROM Parte WHERE Tipo = 'Modelo'");

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					String Nombre = rs.getString("Nombre");
					cb.addItem(Nombre);
				}
			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}

	}

	public void cargarMarcaB(JComboBox<String> cb) {
		Bd bd = new Bd();
		bd.cargarDriver();

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
			String usuario = new String(VentanaInicio.textoUsuario.getText());

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn.prepareStatement("SELECT Nombre FROM Parte WHERE Tipo = 'Marca'");

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					String Nombre = rs.getString("Nombre");
					cb.addItem(Nombre);
				}
			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}

	}

	public void cargarCvB(JComboBox<String> cb) {
		Bd bd = new Bd();
		bd.cargarDriver();

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
			String usuario = new String(VentanaInicio.textoUsuario.getText());

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn.prepareStatement("SELECT Nombre FROM Parte WHERE Tipo = 'Cv'");

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					String Nombre = rs.getString("Nombre");
					cb.addItem(Nombre);
				}
			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}

	}

	public void cargarRuedasB(JComboBox<String> cb) {
		Bd bd = new Bd();
		bd.cargarDriver();

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
			String usuario = new String(VentanaInicio.textoUsuario.getText());

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn.prepareStatement("SELECT Nombre FROM Parte WHERE Tipo = 'Rueda'");

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					String Nombre = rs.getString("Nombre");
					cb.addItem(Nombre);
				}
			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}

	}

	public void cargarManillarB(JComboBox<String> cb) {
		Bd bd = new Bd();
		bd.cargarDriver();

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
			String usuario = new String(VentanaInicio.textoUsuario.getText());

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn.prepareStatement("SELECT Nombre FROM Parte WHERE Tipo = 'Manillar'");

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					String Nombre = rs.getString("Nombre");
					cb.addItem(Nombre);
				}
			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}

	}

	public void cargarSillinB(JComboBox<String> cb) {
		Bd bd = new Bd();
		bd.cargarDriver();

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
			String usuario = new String(VentanaInicio.textoUsuario.getText());

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn.prepareStatement("SELECT Nombre FROM Parte WHERE Tipo = 'Sillin'");

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					String Nombre = rs.getString("Nombre");
					cb.addItem(Nombre);
				}
			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}

	}

	public int precioModeloB(String p) {
		Bd bd = new Bd();
		bd.cargarDriver();
		int Precio = 0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn
						.prepareStatement("SELECT Precio FROM Parte WHERE Nombre = ? AND Tipo = 'Modelo'");
				stmt.setString(1, p);
				ResultSet rs = stmt.executeQuery();

				Precio = rs.getInt("Precio");

			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}
		return Precio;
	}

	public int precioMarcaB(String p) {
		Bd bd = new Bd();
		bd.cargarDriver();
		int Precio = 0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn
						.prepareStatement("SELECT Precio FROM Parte WHERE Nombre = ? AND Tipo = 'Marca'");
				stmt.setString(1, p);
				ResultSet rs = stmt.executeQuery();

				Precio = rs.getInt("Precio");

			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}
		return Precio;
	}

	public int precioCvB(String p) {
		Bd bd = new Bd();
		bd.cargarDriver();
		int Precio = 0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn
						.prepareStatement("SELECT Precio FROM Parte WHERE Nombre = ? AND Tipo = 'Cv'");
				stmt.setString(1, p);
				ResultSet rs = stmt.executeQuery();

				
				Precio = rs.getInt("Precio");
				

			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}
		return Precio;
	}

	public int precioRuedasB(String p) {
		Bd bd = new Bd();
		bd.cargarDriver();
		int Precio = 0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn
						.prepareStatement("SELECT Precio FROM Parte WHERE Nombre = ? AND Tipo = 'Rueda'");
				stmt.setString(1, p);
				ResultSet rs = stmt.executeQuery();

				
				Precio =rs.getInt("Precio");
				

			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}
		return Precio;
	}

	public int precioManillarB(String p) {
		Bd bd = new Bd();
		bd.cargarDriver();
		int Precio = 0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn
						.prepareStatement("SELECT Precio FROM Parte WHERE Nombre = ? AND Tipo = 'Manillar'");
				stmt.setString(1, p);
				ResultSet rs = stmt.executeQuery();

				
				Precio = Precio + rs.getInt("Precio");
				

			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}
		return Precio;
	}

	public int precioSillinB(String p) {
		Bd bd = new Bd();
		bd.cargarDriver();
		int Precio = 0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");

			try (Scanner scanner = new Scanner(System.in)) {

				PreparedStatement stmt = conn
						.prepareStatement("SELECT Precio FROM Parte WHERE Nombre = ? AND Tipo = 'Sillin'");
				stmt.setString(1, p);
				ResultSet rs = stmt.executeQuery();

				
				Precio =rs.getInt("Precio");
				

			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido conectar a la base de datos.");
			System.exit(0);
		}
		return Precio;
	}

}
