package models;

public class Cliente extends Persona{

	private String usuario;
	private String password;
	private String tarjeta;
	
	public Cliente(String nombre, String gmail, String direccion, String telefono, String usuario, String password,
			String tarjeta) {
		super(nombre, gmail, direccion, telefono);
		this.usuario = usuario;
		this.password = password;
		this.tarjeta = tarjeta;
	}
	
	public Cliente() {
		super();
		this.usuario = "";
		this.password = "";
		this.tarjeta = "";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Override
	public String toString() {
		return "Cliente [usuario=" + usuario + ", password=" + password + ", tarjeta=" + tarjeta + "]";
	}
	
	
	
	
	
	
	
	
	

	
	
}
