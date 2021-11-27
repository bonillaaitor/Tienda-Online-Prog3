package models;

public class Administrador extends Persona {

	private boolean admin;

	public Administrador(String nombre, String gmail, String direccion, String telefono, boolean admin) {
		super(nombre, gmail, direccion, telefono);
		this.admin = admin;
	}
	
	public Administrador() {
		super();
		this.admin = false;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Administrador [admin=" + admin + "]";
	}
	

	
	
	
}
