package Bd;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import Tienda.Cliente;

public class Bd {
	
	private Connection conn;
	private static Exception ultimoError = null; 
	private static Logger logger = null;
	
	public Bd() {
		conectar();
	}

	private void conectar() {
		try {
			Class.forName(" // (poner un nombre) ");					
			conn = DriverManager.getConnection("//poner un .db");
			log(Level.INFO,"conectado a la bd",null);
		} catch (ClassNotFoundException|SQLException e) {
			setUltimoError(e);
			log(Level.SEVERE,"error de conexion en la  bd",e);
			e.printStackTrace();
		}
	}
	
	private void desconectar() {
		try {
			conn.close();
			log(Level.INFO,"desconectado",null);
		} catch (Exception e) {
			log(Level.SEVERE,"error al desconectar",null);
			e.printStackTrace();
		}
	}
	
	private void borrar(String tabla) {
		String sqlEliminar = "delete from" + tabla;
		Statement stmtEliminar;
		try {
			stmtEliminar = conn.createStatement();
			stmtEliminar.executeUpdate(sqlEliminar);
			log(Level.INFO, " eliminando "+tabla+ "de la bd", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "error al eliminar" + tabla + "de la bd", e);
			e.printStackTrace();
		}
	}
	
	private void importarClientes() {
		List<Cliente>clientes = new ArrayList<Cliente>();
		File f = null;
		Scanner sc = null;
		
		try {
			f= new File("// .csv");
			sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				Cliente c =  new Cliente();
				String[] campos = linea.split(";");
				c.setNombre(campos[0]);
				c.setGmail(campos[1]);
				c.setDireccion(campos[2]);
				c.setTelefono(campos[3]);
				c.setUsuario(campos[4]);
				c.setPassword(campos[5]);
				c.setTarjeta(campos[6]);
				clientes.add(c);
			}
			sc.close();
			
		} catch (Exception e) {
		e.printStackTrace();
		log(Level.SEVERE,"Error",null);
		}finally {
			sc.close();
		}
	}
	
	private void exportarClientes() {
		FileWriter f  = null;
		List<Cliente> clientes = recibirCliente();
		
		try {
			f = new FileWriter("// .csv");
			// hacer con  foreach
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	private List<Cliente> recibirCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	private static void log(Level info, String msg, Object object) {
		
		
	}

	private void setUltimoError(Exception ultimoError) {
		Bd.ultimoError = ultimoError;
		
	}

	

	
}
