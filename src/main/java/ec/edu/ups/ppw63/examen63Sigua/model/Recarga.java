package ec.edu.ups.ppw63.examen63Sigua.model;

public class Recarga {

	private int operadora;
	private int clienteDes;
	private float monto;
	
	public int getOperadora() {
		return operadora;
	}
	public void setOperadora(int operadora) {
		this.operadora = operadora;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	

	public int getClienteDes() {
		return clienteDes;
	}
	public void setClienteDes(int clienteDes) {
		this.clienteDes = clienteDes;
	}
	@Override
	public String toString() {
		return "Recarga [operadora=" + operadora + ", clienteDes=" + clienteDes + ", monto=" + monto + "]";
	}
	
}
