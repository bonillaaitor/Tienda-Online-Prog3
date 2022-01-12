package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import bd.Bd;
import models.Cliente;
import models.Pedido;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.Action;

public class VentanaEliminarPedido extends JFrame {

	private JPanel contentPane;
	private JTable tablaVerPedidos;
	private JTextField textId;
	private final Action action = new BotonAtras();
	protected Cliente cl;
	private DefaultTableModel mDatosPedido;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private final Action actionEliminar = new EliminarPedido();


	/**
	 * Create the frame.
	 */
	public VentanaEliminarPedido(Cliente c) {
		cl = c;
		setTitle("Eliminar Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTitulo = new JLabel("\u00BFN\u00FAmero de pedido que desea eliminar?");
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTitulo.setBounds(253, 46, 514, 32);
		contentPane.add(lblTitulo);
		
		textId = new JTextField();
		textId.setBounds(382, 368, 217, 32);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setAction(action);
		btnAtras.setBounds(851, 489, 89, 23);
		contentPane.add(btnAtras);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setAction(actionEliminar);
		btnEliminar.setBounds(422, 421, 134, 23);
		contentPane.add(btnEliminar);
		
		verPedidos();
	}
	private class BotonAtras extends AbstractAction {
		public BotonAtras() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "ir atras");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaCliente VentanaCliente = new VentanaCliente(cl);
			VentanaCliente.setVisible(true);
			dispose();
		}
	}
	
	public void verPedidos() {
		
		tablaVerPedidos = new JTable();
		tablaVerPedidos.setFont(new Font("Arial", Font.PLAIN, 14));
		tablaVerPedidos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tablaVerPedidos.setBounds(204, 141, 571, 193);
		contentPane.add(tablaVerPedidos);
		
		Bd bd = new Bd();
		bd.cargarDriver();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
			String usuario = new String(VentanaInicio.textoUsuario.getText());										
			
			try (Scanner scanner = new Scanner(System.in)) {
				
				PreparedStatement stmt = conn.prepareStatement(
					"SELECT idP, clienteUsuario, fechaP, fechaE, precioTotal FROM Pedido where clienteUsuario = ? ");	
					
			stmt.setString(1, usuario);

			ResultSet rs = stmt.executeQuery();
			
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
			}

        conn.close();
            
      } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.out.println("No se ha podido conectar a la base de datos.");
        System.exit(0);
      }
	}
      
	public void eliminarPedido(){
		Bd bd =  new Bd();
		bd.cargarDriver();
		
		String id = new String (textId.getText());
	
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
            try (Scanner scanner = new Scanner(System.in)) {
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE FROM Pedido WHERE idP =? ");
                stmt.setString(1, id);
               
 
                stmt.executeUpdate();
                stmt.close();
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos.");
            System.out.println(e.getMessage());
        }
    }
	private class EliminarPedido extends AbstractAction {
		public EliminarPedido() {
			putValue(NAME, "Eliminar Pedido");
			putValue(SHORT_DESCRIPTION, "Eliminar pedidos de la base de datos");
		}
		public void actionPerformed(ActionEvent e) {
			eliminarPedido();
			dispose();
			VentanaEliminarPedido VentanaDeletePedido = new VentanaEliminarPedido(cl);
			VentanaDeletePedido.setVisible(true);
		}
	}
}
