package models;

public class Vehiculo {

	protected String modelo;
	protected String marca;
	protected int precio;
	protected int cv;
	protected int ruedas;
	protected int manillar;
	protected boolean frenos;
	
	
	public Vehiculo(String modelo, String marca, int precio,int cv,int ruedas, int manillar
	, boolean frenos) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.cv= cv;
		this.ruedas = ruedas;
		this.manillar = manillar;
		this.frenos = frenos;
	}
	
	public Vehiculo() {
		super();
		this.modelo = "";
		this.marca = "";
		this.precio = 0;
		this.cv= 0;
		this.ruedas = 0;
		this.manillar = 0;
		this.frenos = false;
	}
	
	public Vehiculo(Vehiculo  v) {
		super();
		this.modelo = v.modelo;
		this.marca = v.marca;
		this.precio = v.precio;
		this.cv= v.cv;
		this.ruedas = v.ruedas;
		this.manillar = v.manillar;
		this.frenos = v.frenos;
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
		return precio;
	}

	public void setCv(int cv) {
		this.cv = cv;
	}
	public int getRueda() {
		return ruedas;
	}

	public void setRueda(int rueda) {
		this.ruedas = rueda;
	}
	public int getManillar() {
		return manillar;
	}

	public void setManillar(int manillar) {
		this.manillar = manillar;
	}
	public boolean getFreno() {
		return false;
	}

	public void setFreno(boolean freno) {
		this.frenos = freno;
	}
	
	@Override
	public String toString() {
		return marca +" " + modelo + " " + precio + "€" + ",tiene" + cv + ruedas + " " + manillar + " " + frenos +" ";
	}

	
	
	
}
