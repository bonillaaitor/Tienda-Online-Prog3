package models;

public class Pedido {
	
	int idP;
	String clienteUsuario;
	String fechaP;
	String fechaE;
	int precioTotal;
	
	public Pedido(int idP, String clienteUsuario, String fechaP, String fechaE, int precioTotal) {
		super();
		this.idP = idP;
		this.clienteUsuario = clienteUsuario;
		this.fechaP = fechaP;
		this.fechaE = fechaE;
		this.precioTotal = precioTotal;
	}
	
	public Pedido() {
		super();
		this.idP = 0;
		this.clienteUsuario = "";
		this.fechaP = "";
		this.fechaE = "";
		this.precioTotal = 0;
	}

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public String getClienteUsuario() {
		return clienteUsuario;
	}

	public void setClienteUsuario(String clienteUsuario) {
		this.clienteUsuario = clienteUsuario;
	}

	public String getFechaP() {
		return fechaP;
	}

	public void setFechaP(String fechaP) {
		this.fechaP = fechaP;
	}

	public String getFechaE() {
		return fechaE;
	}

	public void setFechaE(String fechaE) {
		this.fechaE = fechaE;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	

	@Override
	public String toString() {
		return "Pedido [idP=" + idP + ", clienteUsuario=" + clienteUsuario + ", fechaP=" + fechaP + ", fechaE=" + fechaE
				+ ", precioTotal=" + precioTotal + "]";
	}
	
	
	
	

}
