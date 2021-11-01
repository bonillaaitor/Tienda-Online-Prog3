package Tienda;

public class Cliente extends Persona{

	private String id;
	private int contrsenioa;
	private int tarjeta;

	public Cliente(String nombre, String gmail, String direccion, int telefono, String id, int contrsenioa,
			int tarjeta) {
		super(nombre, gmail, direccion, telefono);
		this.id = id;
		this.contrsenioa = contrsenioa;
		this.tarjeta = tarjeta;
	}
	
	public Cliente() {
		super("", "", "", 0);
		this.id = "";
		this.contrsenioa = 0;
		this.tarjeta = 0;
	}
	
	public Cliente(Cliente c) {
		super(c.nombre, c.gmail, c.direccion, c.telefono);
		this.id = c.id;
		this.contrsenioa = c.contrsenioa;
		this.tarjeta = c.tarjeta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getContrsenioa() {
		return contrsenioa;
	}

	public void setContrsenioa(int contrsenioa) {
		this.contrsenioa = contrsenioa;
	}

	public int getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", contrsenioa=" + contrsenioa + ", tarjeta=" + tarjeta + "]";
	}
	
	
	
}
