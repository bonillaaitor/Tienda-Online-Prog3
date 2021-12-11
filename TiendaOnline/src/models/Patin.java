package models;

public class Patin extends Vehiculo{

	protected String base;



	public Patin(String modelo, String marca, int precio, int cv, String ruedas, String manillar,
			String base) {
		super(modelo, marca, precio, cv, ruedas, manillar);
		this.base = base;
	}

	public Patin() {
		super();
		this.base = "";
	}
	
	
	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	@Override
	public String toString() {
		return "Patin [base=" + base + ", modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", cv=" + cv + ", ruedas=" + ruedas + ", manillar=" + manillar + "]";
	}

	
	
	
}
