package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
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
		VentanaExportarClientes ventanaExportarClientes = new VentanaExportarClientes();
		ventanaExportarClientes.setVisible(true);
		dispose();
	}}}
