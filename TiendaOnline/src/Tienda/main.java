package Tienda;

import java.awt.EventQueue;

import Bd.Bd;

public class main {

	public static void main(String[] args) {
		/*Bd conexion = new Bd();
		conexion.cargarDriver();
		conexion.establecerConexion();*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	}


