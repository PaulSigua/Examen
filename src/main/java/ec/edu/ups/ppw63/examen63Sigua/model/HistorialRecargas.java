package ec.edu.ups.ppw63.examen63Sigua.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class HistorialRecargas {

	@Id
	@GeneratedValue
	private int codigo;
	private String fecha;
	private float resultadoMonto;
	private float saldo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getResultadoMonto() {
		return resultadoMonto;
	}

	public void setResultadoMonto(float resultadoMonto) {
		this.resultadoMonto = resultadoMonto;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "HistorialRecargas [codigo=" + codigo + ", fecha=" + fecha + ", resultadoMonto=" + resultadoMonto
				+ ", saldo=" + saldo + "]";
	}
}
