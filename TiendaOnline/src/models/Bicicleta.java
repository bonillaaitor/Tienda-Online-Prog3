package models;

public class Bicicleta extends Vehiculo{

	protected String sillin;


	public Bicicleta(String modelo, String marca, int precio, int cv, int ruedas, int manillar, boolean frenos,
			String sillin) {
		super(modelo, marca, precio, cv, ruedas, manillar, frenos);
		this.sillin = sillin;
	}
	
	public Bicicleta() {
		super("", "", 0, 0, 0, 0, false);
		this.sillin = "";
	}
	
	public Bicicleta(Bicicleta b) {
		super(b.modelo, b.marca, b.precio, b.cv, b.ruedas, b.manillar, b.frenos);
		this.sillin = b.sillin;
	}
	
	public String getSillin() {
		return sillin;
	}

	public void setSillin(String sillin) {
		this.sillin = sillin;
	}

	@Override
	public String toString() {
		return marca + " " + modelo + " " +precio +"€" + "tiene" + cv +ruedas + " " + manillar + " " + frenos + " " + sillin+ " ";
	}
	

	
}
