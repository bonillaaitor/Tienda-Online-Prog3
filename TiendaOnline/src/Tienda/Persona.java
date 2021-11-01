package Tienda;

public class Persona {

	protected String nombre;
	protected String gmail;
	protected String direccion;
	protected int telefono;
	
	public Persona(String nombre, String gmail, String direccion, int telefono) {
		super();
		this.nombre = nombre;
		this.gmail = gmail;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public Persona() {
		super();
		this.nombre = "";
		this.gmail = "";
		this.direccion = "";
		this.telefono = 0;
	}
	
	public Persona(Persona p) {
		super();
		this.nombre = p.nombre;
		this.gmail = p.gmail;
		this.direccion = p.direccion;
		this.telefono = p.telefono;
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", gmail=" + gmail + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}
	
	
}
