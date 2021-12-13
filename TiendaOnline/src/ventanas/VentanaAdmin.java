package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.Bd;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class VentanaAdmin extends JFrame {

	private JPanel contentAdmin;
	private final Action actionCerrarSesion = new botonCerrarSesion();
	private final Action anyadirStock = new botonAnyadirStock();
	private final Action importarClientes = new botonImportarClientes();
	private final Action exportarClientes = new botonExportarClientes();

	public VentanaAdmin() {
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
	}

	private class botonCerrarSesion extends AbstractAction {
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
		public botonAnyadirStock() {
			putValue(NAME, "Añadir Stock");
			putValue(SHORT_DESCRIPTION, "Añadir stock de uno o varios productos");
		}

		public void actionPerformed(ActionEvent e) {
			VentanaAnyadirStock ventanaAnyadirStock = new VentanaAnyadirStock();
			ventanaAnyadirStock.setVisible(true);
			dispose();
		}

	}

	private class botonImportarClientes extends AbstractAction {
		public botonImportarClientes() {
			putValue(NAME, "Importar Clientes");
			putValue(SHORT_DESCRIPTION, "Importa los clientes al sistema");
		}

		public void actionPerformed(ActionEvent arg0) {
			VentanaImportarClientes ventanaImportarClientes = new VentanaImportarClientes();
			ventanaImportarClientes.setVisible(true);
			dispose();
		}
	}

	private class botonExportarClientes extends AbstractAction {
		public botonExportarClientes() {
			putValue(NAME, "Exportar Clientes");
			putValue(SHORT_DESCRIPTION, "Exporta los clientes al sistema");
		}

		public void actionPerformed(ActionEvent arg0) {
			exportarCliente();
			JOptionPane.showMessageDialog(contentAdmin, "Clientes exportados correctamente a csv en carpeta files");
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
}
