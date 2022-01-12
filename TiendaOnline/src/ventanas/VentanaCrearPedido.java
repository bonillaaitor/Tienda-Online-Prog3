package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class VentanaCrearPedido extends JFrame {

	private JPanel contentPanelCrearPedido;
	private JTable tablaCrearPedidoBici;

	private DefaultTableModel mDatosBici;
	private ArrayList<Bicicleta> pedidoBicis = new ArrayList();

	String valorModeloB;
	String valorMarcaB;
	String valorPrecioB;
	String valorCvB;
	String valorRuedasB;
	String valorManillarB;
	String valorSillinB;

	private final Action actionBotonAtras = new btnAtras();
	protected Cliente cl;

	public VentanaCrearPedido(Cliente c) {
		Bd bd = new Bd();
		cl = c;
		setTitle("Crear Bici");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelCrearPedido = new JPanel();
		contentPanelCrearPedido.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelCrearPedido);
		contentPanelCrearPedido.setLayout(null);

		tablaCrearPedidoBici = new JTable();
		tablaCrearPedidoBici.setFont(new Font("Arial", Font.PLAIN, 14));
		tablaCrearPedidoBici.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tablaCrearPedidoBici.setBounds(10, 40, 1014, 277);
		contentPanelCrearPedido.add(tablaCrearPedidoBici);

		JLabel labelBicicleta = new JLabel("Crea tu bicicleta");
		labelBicicleta.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		labelBicicleta.setBounds(458, 344, 118, 26);
		contentPanelCrearPedido.add(labelBicicleta);

		JLabel labelModeloB = new JLabel("Modelo");
		labelModeloB.setBounds(308, 385, 46, 14);
		contentPanelCrearPedido.add(labelModeloB);

		JLabel labelMarcaB = new JLabel("Marca");
		labelMarcaB.setBounds(308, 418, 46, 14);
		contentPanelCrearPedido.add(labelMarcaB);

		JLabel labelCvB = new JLabel("Cv");
		labelCvB.setBounds(308, 458, 46, 14);
		contentPanelCrearPedido.add(labelCvB);

		JLabel labelRuedasB = new JLabel("Ruedas");
		labelRuedasB.setBounds(575, 458, 46, 14);
		contentPanelCrearPedido.add(labelRuedasB);

		JLabel labelManillarB = new JLabel("Manillar");
		labelManillarB.setBounds(575, 385, 46, 14);
		contentPanelCrearPedido.add(labelManillarB);

		JLabel labelSillinB = new JLabel("Sillin");
		labelSillinB.setBounds(575, 418, 46, 14);
		contentPanelCrearPedido.add(labelSillinB);

		JComboBox comboBoxModeloB = new JComboBox();
		bd.cargarModeloB(comboBoxModeloB);
		comboBoxModeloB.setBounds(375, 381, 94, 22);
		contentPanelCrearPedido.add(comboBoxModeloB);

		JComboBox comboBoxMarcaB = new JComboBox();
		bd.cargarMarcaB(comboBoxMarcaB);
		comboBoxMarcaB.setBounds(375, 414, 94, 22);
		contentPanelCrearPedido.add(comboBoxMarcaB);

		JComboBox comboBoxCvB = new JComboBox();
		bd.cargarCvB(comboBoxCvB);
		comboBoxCvB.setBounds(375, 454, 94, 22);
		contentPanelCrearPedido.add(comboBoxCvB);

		JComboBox comboBoxManillarB = new JComboBox();
		bd.cargarManillarB(comboBoxManillarB);
		comboBoxManillarB.setBounds(631, 381, 93, 22);
		contentPanelCrearPedido.add(comboBoxManillarB);

		JComboBox comboBoxSillinB = new JComboBox();
		bd.cargarSillinB(comboBoxSillinB);
		comboBoxSillinB.setBounds(631, 414, 94, 22);
		contentPanelCrearPedido.add(comboBoxSillinB);

		JComboBox comboBoxRuedasB = new JComboBox();
		bd.cargarRuedasB(comboBoxRuedasB);
		comboBoxRuedasB.setBounds(632, 454, 92, 22);
		contentPanelCrearPedido.add(comboBoxRuedasB);

		cargarBicicletas();

		JButton btnAnadirBici = new JButton("A\u00F1adir Bici");
		btnAnadirBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bicicleta o = new Bicicleta();
				valorModeloB = comboBoxModeloB.getSelectedItem().toString();
				valorMarcaB = comboBoxMarcaB.getSelectedItem().toString();
				valorCvB = comboBoxCvB.getSelectedItem().toString();
				valorRuedasB = comboBoxRuedasB.getSelectedItem().toString();
				valorManillarB = comboBoxManillarB.getSelectedItem().toString();
				valorSillinB = comboBoxSillinB.getSelectedItem().toString();

				int valorCvBInt = Integer.parseInt(valorCvB);
				int precioBicicleta = bd.precioModeloB(valorModeloB) + bd.precioMarcaB(valorMarcaB)
						+ bd.precioCvB(valorCvB) + bd.precioRuedasB(valorRuedasB) + bd.precioManillarB(valorManillarB)
						+ bd.precioSillinB(valorSillinB);

				o.setModelo(valorModeloB);
				o.setMarca(valorMarcaB);
				o.setCv(valorCvBInt);
				o.setRueda(valorRuedasB);
				o.setManillar(valorManillarB);
				o.setSillin(valorSillinB);
				o.setPrecio(precioBicicleta);

				pedidoBicis.add(o);
				cargarBicicletas();
			}
		});
		btnAnadirBici.setBounds(474, 512, 129, 23);
		contentPanelCrearPedido.add(btnAnadirBici);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setAction(actionBotonAtras);
		btnAtras.setBounds(873, 512, 118, 23);
		contentPanelCrearPedido.add(btnAtras);

		JButton btnCrearPedido = new JButton("Crear pedido");
		btnCrearPedido.setBounds(86, 512, 118, 23);
		contentPanelCrearPedido.add(btnCrearPedido);
		btnCrearPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido p = new Pedido();
				
				String usuarioPedido = VentanaInicio.textoUsuario.getText();
				int precioBicicleta = bd.precioModeloB(valorModeloB) + bd.precioMarcaB(valorMarcaB)
				+ bd.precioCvB(valorCvB) + bd.precioRuedasB(valorRuedasB) + bd.precioManillarB(valorManillarB)
				+ bd.precioSillinB(valorSillinB);
				
				LocalDate hoy = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd");
				String fechaP = hoy.format(formatter);
				
				LocalDate hoyMasTres = LocalDate.now();
				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MMMM-dd");
				String fechaE = hoyMasTres.format(formatter2);
				
				int idPedido = 0;
				
				p.setIdP(bd.gestionIdPedido(idPedido));
				
				p.setClienteUsuario(usuarioPedido);
				p.setFechaP(fechaP);
				p.setFechaE(fechaE);
				p.setPrecioTotal(precioBicicleta);
				bd.crearPedido(p);
			}
		});

	}

	private class btnAtras extends AbstractAction {
		public btnAtras() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "ir a la ventana pedido");
		}

		public void actionPerformed(ActionEvent e) {
			VentanaCrearPedidoIntermedia VentanaCrearPedidoIntermedia = new VentanaCrearPedidoIntermedia(cl);
			VentanaCrearPedidoIntermedia.setVisible(true);
			dispose();
		}
	}

	public void cargarBicicletas() {

		Vector<String> cabecerasBici = new Vector<String>(
				Arrays.asList("Modelo", "Marca", "Precio", "Cv", "Ruedas", "Manillar", "Sillin"));
		mDatosBici = new DefaultTableModel(new Vector<Vector<Object>>(), cabecerasBici);
		tablaCrearPedidoBici.setModel(mDatosBici);

		for (Bicicleta b : pedidoBicis) {
			mDatosBici.addRow(new Object[] { b.getModelo(), b.getMarca(), b.getPrecio(), b.getCv(), b.getRueda(),
					b.getManillar(), b.getSillin() });

		}
		tablaCrearPedidoBici.getColumnModel().getColumn(0).setMaxWidth(100);
		tablaCrearPedidoBici.getColumnModel().getColumn(1).setMaxWidth(100);
		tablaCrearPedidoBici.getColumnModel().getColumn(2).setMaxWidth(50);
		tablaCrearPedidoBici.getColumnModel().getColumn(3).setMaxWidth(50);
		tablaCrearPedidoBici.getColumnModel().getColumn(4).setMaxWidth(100);
		tablaCrearPedidoBici.getColumnModel().getColumn(5).setMaxWidth(100);
		tablaCrearPedidoBici.getColumnModel().getColumn(6).setMaxWidth(100);

	}
	
	}
