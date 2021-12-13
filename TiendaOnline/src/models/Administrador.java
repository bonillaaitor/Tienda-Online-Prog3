package models;

public class Administrador extends Persona{
	
	private int sueldo;

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public Administrador(String nombre, String gmail, String direccion, String telefono, int sueldo) {
		super(nombre, gmail, direccion, telefono);
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Administrador [sueldo=" + sueldo + "]";
	}
	
	
	
	

}
