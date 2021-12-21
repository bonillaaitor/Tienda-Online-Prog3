package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import bd.Bd;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.Action;

public class VentanaEliminarCuenta extends JFrame {

	private JPanel contentPanelEliminarCuenta;
	private JTextField textoUsuario;
	private JPasswordField textoPassword;
	private final Action actionBotonAtras = new botonAtras();
	private final Action actionBotonEliminar = new botonEliminar();

	public VentanaEliminarCuenta() {
		setTitle("ventana Eliminar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelEliminarCuenta = new JPanel();
		contentPanelEliminarCuenta.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelEliminarCuenta);
		contentPanelEliminarCuenta.setLayout(null);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(445, 182, 142, 20);
		contentPanelEliminarCuenta.add(textoUsuario);
		textoUsuario.setColumns(10);
		
		textoPassword = new JPasswordField();
		textoPassword.setBounds(445, 236, 142, 20);
		contentPanelEliminarCuenta.add(textoPassword);
		textoPassword.setColumns(10);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(311, 185, 46, 14);
		contentPanelEliminarCuenta.add(labelUsuario);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setBounds(311, 239, 66, 14);
		contentPanelEliminarCuenta.add(labelPassword);
		
		JLabel labelTitulo = new JLabel("Introduce tu cuenta para eliminarla");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelTitulo.setBounds(276, 39, 422, 41);
		contentPanelEliminarCuenta.add(labelTitulo);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setAction(actionBotonAtras);
		botonAtras.setBounds(595, 443, 89, 23);
		contentPanelEliminarCuenta.add(botonAtras);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setAction(actionBotonEliminar);
		botonEliminar.setBounds(314, 443, 89, 23);
		contentPanelEliminarCuenta.add(botonEliminar);
	}

	private class botonAtras extends AbstractAction {
		public botonAtras() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "Volver a la ventana cliente");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaInicio ventanaInicio = new VentanaInicio();
			ventanaInicio.setVisible(true);
			dispose();
		}
	}
	public void eliminarCuenta() throws SQLException{
		Bd bd =  new Bd();
		bd.cargarDriver();
		
		String usuario = new String(textoUsuario.getText());
        String pass = new String(textoPassword.getPassword());
        int result = Bd.comprobarUsuario(usuario, pass);
        if(result == 0){
        	JOptionPane.showMessageDialog(null, "Usuario no encontrado en la base de datos");
 
        }else if(result == 1){
        	JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
        }else if(result == 2) {
        	
        	try {
                Connection conn = DriverManager.getConnection("jdbc:sqlite:TiendaOnline/files/tiendaonline.db");
                try (Scanner scanner = new Scanner(System.in)) {
                    PreparedStatement stmt = conn.prepareStatement(
                            "DELETE FROM Cliente WHERE usuario =? AND password =? ");
                    		//"DELETE nombre, usuario, password, email,direccion, telefono,num_tarjeta FROM Cliente WHERE nombre ='?' AND password ='?'");
                    stmt.setString(1, usuario);
                    stmt.setString(2, pass);
                   
                    stmt.executeUpdate();
                    stmt.close();
                }
                conn.close();
               

            } catch (SQLException e) {
                System.out.println("No se ha podido conectar a la base de datos.");
                System.out.println(e.getMessage());
            }
        	JOptionPane.showMessageDialog(null, "Cuenta eliminada con exito");
        	VentanaInicio ventanaInicio = new VentanaInicio();
 			ventanaInicio.setVisible(true);
 			dispose();
        }
        
    }

	private class botonEliminar extends AbstractAction {
		public botonEliminar() {
			putValue(NAME, "Eliminar");
			putValue(SHORT_DESCRIPTION, "Eliminar la cuenta");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				eliminarCuenta();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
			
		}
	}
	}

