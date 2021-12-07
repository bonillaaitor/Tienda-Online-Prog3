package models;

public abstract class Vehiculo {

	protected String modelo;
	protected String marca;
	protected int precio;
	protected int cv;
	protected String ruedas;
	protected String manillar;
	
	
	public Vehiculo(String modelo, String marca, int precio,int cv,String ruedas, String manillar) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.cv= cv;
		this.ruedas = ruedas;
		this.manillar = manillar;
	}
	
	public Vehiculo() {
		super();
		this.modelo = "";
		this.marca = "";
		this.precio = 0;
		this.cv= 0;
		this.ruedas = "";
		this.manillar = "";
		
	}
	
	public Vehiculo(Vehiculo  v) {
		super();
		this.modelo = v.modelo;
		this.marca = v.marca;
		this.precio = v.precio;
		this.cv= v.cv;
		this.ruedas = v.ruedas;
		this.manillar = v.manillar;
		
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getCv() {
		return cv;
	}

	public void setCv(int cv) {
		this.cv = cv;
	}
	public String getRueda() {
		return ruedas;
	}

	public void setRueda(String rueda) {
		this.ruedas = rueda;
	}
	public String getManillar() {
		return manillar;
	}

	public void setManillar(String manillar) {
		this.manillar = manillar;
	}
	
	
	@Override
	public String toString() {
		return marca +" " + modelo + " " + precio + "€" + ",tiene" + cv + ruedas + " " + manillar + " ";
	}

	
	
	
}
