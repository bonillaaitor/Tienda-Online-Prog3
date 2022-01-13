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
		botonCerrarSesion.setBounds(800, 459, 125, 23);
		contentAdmin.add(botonCerrarSesion);

		JButton botonVerPedidos = new JButton("Ver Pedidos");
		botonVerPedidos.setAction(verPedidos);
		botonVerPedidos.setBounds(428, 151, 151, 23);
		contentAdmin.add(botonVerPedidos);

		JButton botonImportarClientes = new JButton("Importar Clientes");
		botonImportarClientes.setAction(importarClientes);
		botonImportarClientes.setBounds(428, 227, 151, 23);
		contentAdmin.add(botonImportarClientes);

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
			Bd bd = new Bd();
			bd.importarCliente();
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
			Bd bd = new Bd();
			bd.exportarCliente();
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

	


	
}
