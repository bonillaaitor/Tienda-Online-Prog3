package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestParte {
	Parte parte;

	@Before
	public void setUp() {
		parte = new Parte("Rueda", 22, 40);
	}
	@Test
	public void testGetNombre() {
		assertEquals("Rueda", parte.getNombre());
	}
	@Test
	public void testGetPrecio() {
		assertEquals(22, parte.getPrecio());
	}
	@Test
	public void testGetStock() {
		assertEquals(40, parte.getStock());
	}
	
}
