package models;

public class Patin extends Vehiculo{

	protected String base;



	public Patin(String modelo, String marca, int precio, int cv, int ruedas, String manillar,
			String base) {
		super(modelo, marca, precio, cv, ruedas, manillar);
		this.base = base;
	}

	public Patin() {
		super("", "", 0, 0, 0, "");
		this.base = "";
	}
	
	public Patin(Patin p) {
		super(p.modelo, p.marca, p.precio, p.cv, p.ruedas, p.manillar);
		this.base = p.base;
	}
	
	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	@Override
	public String toString() {
		return marca + " " + modelo + " " +precio +"€" + "tiene" + cv +ruedas + " " + manillar + " " + base+ " ";
	}
	
	
}
