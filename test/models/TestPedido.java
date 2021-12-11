package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPedido {

	private Pedido pedido;
	
	@Before
	public void setUp() {
		pedido = new Pedido(1, "pedro34", "18.03.2021", "22.03.2021", 500);
	}
	@Test
	public void testGetIdP() {
		assertEquals(1, pedido.getIdP());
	}
	@Test
	public void testGetClienteUsuario() {
		assertEquals("pedro34", pedido.getClienteUsuario());
	}
	@Test
	public void testGetFechaP() {
		assertEquals("18.03.2021", pedido.getFechaP());
	}
	@Test
	public void testGetFechaE() {
		assertEquals("22.03.2021", pedido.getFechaE());
	}
	@Test
	public void testGetPrecioTotal() {
		assertEquals(500, pedido.getPrecioTotal());
	}
	@Test
	public void testSetIdP() {
		pedido.setIdP(2);
		assertEquals(2, pedido.getIdP());
	}
	@Test
	public void testSetClienteusuario() {
		pedido.setClienteUsuario("juan34");
		assertEquals("juan34", pedido.getClienteUsuario());
	}
	@Test
	public void testSetFechaP() {
		pedido.setFechaP("25.04.2021");
		assertEquals("25.04.2021", pedido.getFechaP());
	}
	@Test
	public void testSetFechaE() {
		pedido.setFechaE("28.04.2021");
		assertEquals("28.04.2021", pedido.getFechaE());
	}
	@Test
	public void testSetPrecioTotal() {
		pedido.setPrecioTotal(600);
		assertEquals(600, pedido.getPrecioTotal());
	}
	@Test
	public void testPedido() {
		pedido = new Pedido();
		assertEquals(0, pedido.getIdP());
		assertEquals("", pedido.getClienteUsuario());
		assertEquals("", pedido.getFechaP());
		assertEquals("", pedido.getFechaE());
		assertEquals(0, pedido.getPrecioTotal());
	}
	
	@Test
	public void testToString() {
		assertEquals("Pedido [idP=1, clienteUsuario=pedro34, fechaP=18.03.2021, fechaE=22.03.2021, precioTotal=500]", pedido.toString());
	}

}
