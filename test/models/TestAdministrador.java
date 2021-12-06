package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAdministrador {
	
	 private Administrador administrador;

	@Before
	public void setUp() {
		administrador = new Administrador("Iker", "iker@gmail.com", "Itsasoko Ama kalea", "695220457", true);
	}
	@Test
	public void testGetNombre() {
		assertEquals("Iker", administrador.getNombre());
	}
	@Test
	public void testGetGmail() {
		assertEquals("iker@gmail.com", administrador.getGmail());
	}
	@Test
	public void testGetDireccion() {
		assertEquals("Itsasoko Ama kalea", administrador.getDireccion());
	}
	@Test
	public void testGetTelefono() {
		assertEquals("695220457", administrador.getTelefono());
	}
	@Test
	public void testGetBoolean() {
		assertEquals(true, administrador.isAdmin());
	}
	
}
