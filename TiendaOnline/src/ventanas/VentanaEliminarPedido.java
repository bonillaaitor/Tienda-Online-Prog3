package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.Bd;
import models.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.Action;

public class VentanaEliminarPedido extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textId;
	private final Action action = new BotonAtras();
	protected Cliente cl;


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
		
		JLabel lblNewLabel = new JLabel("\u00BFN\u00FAmero de pedido que desea eliminar?");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(253, 46, 514, 32);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(40, 124, 935, 168);
		contentPane.add(table);
		
		textId = new JTextField();
		textId.setBounds(383, 395, 217, 32);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setAction(action);
		btnAtras.setBounds(851, 489, 89, 23);
		contentPane.add(btnAtras);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(452, 489, 89, 23);
		contentPane.add(btnEliminar);
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
	public void eliminarPedido(){
		Bd bd =  new Bd();
		bd.cargarDriver();
		
		String id = new String (textId.getText());
	
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
            try (Scanner scanner = new Scanner(System.in)) {
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE FROM Pedido WHERE id =?  ");
                		//"DELETE nombre, usuario, password, email,direccion, telefono,num_tarjeta FROM Cliente WHERE nombre ='?' AND password ='?'");
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
}
