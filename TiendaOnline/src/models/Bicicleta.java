package models;

public class Bicicleta extends Vehiculo{

	protected String sillin;


	public Bicicleta(String modelo, String marca, int precio, int cv, String ruedas, String manillar,
			String sillin) {
		super(modelo, marca, precio, cv, ruedas, manillar);
		this.sillin = sillin;
	}
	
	public Bicicleta() {
		super("", "", 0, 0, "", "");
		this.sillin = "";
	}
	
	public Bicicleta(Bicicleta b) {
		super(b.modelo, b.marca, b.precio, b.cv, b.ruedas, b.manillar);
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
		return marca + " " + modelo + " " +precio +"€" + "tiene" + cv +ruedas + " " + manillar + " " + sillin+ " ";
	}
	

	
}
