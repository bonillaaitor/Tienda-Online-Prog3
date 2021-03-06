package models;

public class Parte {
	
	String nombre;
	int tipo;
	int precio;
	int stock;
	
	public Parte(String nombre, int tipo, int precio, int stock) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Parte() {
		super();
		this.nombre = "";
		this.tipo = 0;
		this.precio = 0;
		this.stock = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Parte [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", stock=" + stock + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
