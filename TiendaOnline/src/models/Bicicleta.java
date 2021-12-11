package models;

public class Bicicleta extends Vehiculo{

	protected String sillin;


	public Bicicleta(String modelo, String marca, int precio, int cv, String ruedas, String manillar,
			String sillin) {
		super(modelo, marca, precio, cv, ruedas, manillar);
		this.sillin = sillin;
	}
	
	public Bicicleta() {
		super();
		this.sillin = "";
	}
	
	public String getSillin() {
		return sillin;
	}

	public void setSillin(String sillin) {
		this.sillin = sillin;
	}

	@Override
	public String toString() {
		return "Bicicleta [sillin=" + sillin + "]";
	}

	
	

	
}
