package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestParte {
	Parte parte;

	@Before
	public void setUp() {
		parte = new Parte("Monte",2, 35, 15);
	}
	@Test
	public void testGetNombre() {
		assertEquals("Monte", parte.getNombre());
	}
	@Test
	public void testGetTipo() {
		assertEquals(2, parte.getTipo());
	}
	@Test
	public void testGetPrecio() {
		assertEquals(35, parte.getPrecio());
	}
	@Test
	public void testGetStock() {
		assertEquals(15, parte.getStock());
	}
	@Test
	public void testSetNombre() {
		parte.setNombre("Nieve");
		assertEquals("Nieve", parte.getNombre());
	}
	@Test
	public void testSetTipo() {
		parte.setTipo(1);
		assertEquals(1, parte.getTipo());
	}
	@Test
	public void testSetPrecio() {
		parte.setPrecio(40);
		assertEquals(40, parte.getPrecio());
	}
	@Test
	public void testSetStock() {
		parte.setStock(5);
		assertEquals(5, parte.getStock());
	}
	@Test
	public void testParte() {
		parte = new Parte();
		assertEquals("", parte.getNombre());
		assertEquals(0, parte.getTipo());
		assertEquals(0, parte.getPrecio());
		assertEquals(0, parte.getStock());
	}
	
	@Test
	public void testToString() {
		assertEquals("Parte [nombre=Monte, tipo=2, precio=35, stock=15]", parte.toString());
	}
	
}
