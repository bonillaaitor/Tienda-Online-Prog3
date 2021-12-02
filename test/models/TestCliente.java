package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCliente {
	
	 private Cliente cliente;

	@Before
	public void setUp() {
		cliente = new Cliente("Pedro", "pedro@gmail.com", "avenida marruecos", "643923823", "Pedro34", "123", "9362");
	}
	@Test
	public void testGetNombre() {
		assertEquals("Pedro", cliente.getNombre());
	}
	@Test
	public void testGetGmail() {
		assertEquals("pedro@gmail.com", cliente.getGmail());
	}
	@Test
	public void testGetDireccion() {
		assertEquals("avenida marruecos", cliente.getDireccion());
	}
	@Test
	public void testGetTelefono() {
		assertEquals("643923823", cliente.getTelefono());
	}
	@Test
	public void testGetUsuario() {
		assertEquals("Pedro34", cliente.getUsuario());
	}
	@Test
	public void testGetPassword() {
		assertEquals("123", cliente.getPassword());
	}
	@Test
	public void testGetTarjeta() {
		assertEquals("9362", cliente.getTarjeta());
	}

}
