package Tienda;

public class Administrador extends Persona {

	private boolean admin;

	public Administrador(String nombre, String gmail, String direccion, int telefono, boolean admin) {
		super(nombre, gmail, direccion, telefono);
		this.admin = admin;
	}
	
	public Administrador() {
		super("", "", "", 0);
		this.admin = false;
	}
	
	public Administrador(Administrador ad) {
		super(ad.nombre, ad.gmail, ad.direccion,ad.telefono );
		this.admin = ad.admin;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		String admin;
		if (this.admin) {
			admin = "es";
		} else {
			admin = "no es" ;
		}
		return  nombre + " " + gmail +"" + admin + "";
	}
	
	
}
