package bd;

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
import models.Cliente;

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
	
	
	
	
}


