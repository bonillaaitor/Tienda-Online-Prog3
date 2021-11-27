package models;

public abstract class Persona {

	
	protected String nombre;
	protected String gmail;
	protected String direccion;
	protected String telefono;
	
	public Persona(String nombre, String gmail, String direccion, String telefono) {
		this.nombre = nombre;
		this.gmail = gmail;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public Persona() {
		this.nombre = "";
		this.gmail = "";
		this.direccion = "";
		this.telefono = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", gmail=" + gmail + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}
	
	
	

	
	
}
