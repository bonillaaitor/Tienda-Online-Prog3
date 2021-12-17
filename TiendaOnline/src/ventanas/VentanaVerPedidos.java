package ventanas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import bd.Bd;
import models.Bicicleta;
import models.Cliente;
import models.Pedido;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.JScrollPane;


public class VentanaVerPedidos extends JFrame {

	private JPanel contentPanelVerPedidos;
	private JTable tablaVerPedidos;
	private JButton botonAtras;
	private final Action action = new BotonAtras();
	protected Cliente cl;
	private final Action action_1 = new CargarPedidos();
	private DefaultTableModel mDatosPedido;
	private ArrayList<Pedido> pedidos = new ArrayList();

	public VentanaVerPedidos(Cliente c) {
		cl = c;
		setTitle("Ver Pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelVerPedidos = new JPanel();
		contentPanelVerPedidos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelVerPedidos);
		contentPanelVerPedidos.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Lista de pedidos");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelTitulo.setBounds(427, 30, 213, 43);
		contentPanelVerPedidos.add(labelTitulo);
		
		tablaVerPedidos = new JTable();
		tablaVerPedidos.setFont(new Font("Arial", Font.PLAIN, 14));
		tablaVerPedidos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tablaVerPedidos.setBounds(233, 147, 571, 286);
		contentPanelVerPedidos.add(tablaVerPedidos);
		
		botonAtras = new JButton("botonAtras");
		botonAtras.setAction(action);
		botonAtras.setBounds(463, 512, 118, 23);
		contentPanelVerPedidos.add(botonAtras);
		
		JButton botonCargarPedidos = new JButton("New button");
		botonCargarPedidos.setAction(action_1);
		botonCargarPedidos.setBounds(456, 105, 134, 23);
		contentPanelVerPedidos.add(botonCargarPedidos);
		
	}
		
		public void verPedidos() {
			Bd bd = new Bd();
			bd.cargarDriver();
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
															
				Statement stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery("SELECT idP, clienteUsuario, fechaP, fechaE, precioTotal FROM Pedido");
				
				while (rs.next()) {	
				int idP = rs.getInt("idP");	
				String clienteUsuario = rs.getString("clienteUsuario");
				String fechaP = rs.getString("fechaP");
				String fechaE = rs.getString("fechaE");
				int precioTotal = rs.getInt("precioTotal");
												
				Vector<String> cabeceras = new Vector<String>(Arrays.asList("idP", "clienteUsuario", "fechaP", "fechaE", "precioTotal"));
				mDatosPedido = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceras);
				tablaVerPedidos.setModel(mDatosPedido);
				
				pedidos.add(new Pedido(idP, clienteUsuario, fechaP, fechaE, precioTotal));
				for (Pedido b : pedidos) {					
					mDatosPedido.addRow(new Object[] { b.getIdP(), b.getClienteUsuario(), b.getFechaP(), b.getFechaE(),b.getPrecioTotal()});	
				}
												
				tablaVerPedidos.getColumnModel().getColumn(0).setMaxWidth(60);
				tablaVerPedidos.getColumnModel().getColumn(1).setMaxWidth(150);
				tablaVerPedidos.getColumnModel().getColumn(2).setMaxWidth(150);
				tablaVerPedidos.getColumnModel().getColumn(3).setMaxWidth(150);
				tablaVerPedidos.getColumnModel().getColumn(4).setMaxWidth(60);		
				
				DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
				Alinear.setHorizontalAlignment(SwingConstants.CENTER);
				tablaVerPedidos.getColumnModel().getColumn(0).setCellRenderer(Alinear);
				tablaVerPedidos.getColumnModel().getColumn(1).setCellRenderer(Alinear);
				tablaVerPedidos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
				tablaVerPedidos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
				tablaVerPedidos.getColumnModel().getColumn(4).setCellRenderer(Alinear);
				}			
				  
	        stmt.close(); 
	        conn.close();
	            
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.out.println("No se ha podido conectar a la base de datos.");
	        System.exit(0);
	      }
	}
	
	private class BotonAtras extends AbstractAction {
		public BotonAtras() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "Ir a la ventana anterior");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaCliente ventanaCliente = new VentanaCliente(cl);
			ventanaCliente.setVisible(true);
			dispose();
		}
	}
	private class CargarPedidos extends AbstractAction {
		public CargarPedidos() {
			putValue(NAME, "Cargar pedidos");
			putValue(SHORT_DESCRIPTION, "Visualizar los pedidos en la tabla");
		}
		public void actionPerformed(ActionEvent e) {
			verPedidos();
		}
	}
}
