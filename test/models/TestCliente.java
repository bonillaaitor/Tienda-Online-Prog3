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
	@Test
	public void testSetTarjeta() {
		cliente.setTarjeta("8432");
		assertEquals("8432", cliente.getTarjeta());
	}
	@Test
	public void testSetPassword() {
		cliente.setPassword("234");
		assertEquals("234", cliente.getPassword());
	}
	@Test
	public void testSetNombre() {
		cliente.setNombre("Juan");
		assertEquals("Juan", cliente.getNombre());
	}
	@Test
	public void testSetDireccion() {
		cliente.setDireccion("avenida piruleta");
		assertEquals("avenida piruleta", cliente.getDireccion());
	}
	@Test
	public void testSetGmail() {
		cliente.setGmail("Juan@gmail.com");
		assertEquals("Juan@gmail.com", cliente.getGmail());
	}
	@Test
	public void testSetTelefono() {
		cliente.setTelefono("645384329");
		assertEquals("645384329", cliente.getTelefono());
	}
	@Test
	public void testSetUsuario() {
		cliente.setUsuario("Juan34");
		assertEquals("Juan34", cliente.getUsuario());
	}
	
	@Test
	public void testCliente() {
		cliente = new Cliente();
		assertEquals("", cliente.getUsuario());
		assertEquals("", cliente.getPassword());
		assertEquals("", cliente.getTarjeta());
	}
	
	@Test
	public void testToString() {
		assertEquals("Cliente [usuario=Pedro34, password=123, tarjeta=9362]", cliente.toString());
	}
	

}
