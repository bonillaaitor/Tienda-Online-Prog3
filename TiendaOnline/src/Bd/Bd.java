package Bd;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Tienda.Cliente;

public class Bd {

	public void cargarDriver() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println('a');
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha podido cargar el driver de la base de datos.");
		}

	}

	public void establecerConexion() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:basededatos.db");
			System.out.println('b');

		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos.");
		}

	}

	public void pruebaBD() {
		cargarDriver();
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:basededatos.db");
			try (Scanner scanner = new Scanner(System.in)) {
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO Cliente (email, password, nombre, direccion, telefono, num_tarjeta) VALUES (?, ?, ?, ?, ?, ?)");

				stmt.executeUpdate();
				stmt.close();
			}

			conn.close();

		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos.");
			System.out.println(e.getMessage());
		}

	}
	
	private void registrar() {
		try {

			if (comprobarVacios()) {
				return;
			}

			String usuario = textoUsuario.getText();
			String pass = new String(textoPassword.getText());;
			String correo = textoCorreo.getText();
			String nombre = textoNombre.getText();
			String tarjeta = textoTarjeta.getText();
			String direccion = textoDireccion.getText();
			String telefono = textoTelefono.getText();


			Cliente c = new Cliente(nombre,usuario, pass, correo,direccion,telefono, tarjeta);

			Bd bd = new Bd();
			anadirNuevoCliente(c);
			bd.desconectar();

		} 
		catch (NumberFormatException en) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca un numero de tarjeta");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}


