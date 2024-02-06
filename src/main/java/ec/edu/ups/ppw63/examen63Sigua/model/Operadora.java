package ec.edu.ups.ppw63.examen63Sigua.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Operadora {

	@Id
	@GeneratedValue
	private int codigo;
	private String nombre;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_historial") /////////////////////////////////////////
	private List<HistorialRecargas> historiales = new ArrayList<>();

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<HistorialRecargas> getHistoriales() {
		return historiales;
	}

	public void setHistoriales(List<HistorialRecargas> historiales) {
		this.historiales = historiales;
	}

	public void addHistorial(HistorialRecargas historial) {
		if (historial == null) {
			historiales = new ArrayList<HistorialRecargas>();
		}
		historiales.add(historial);
	}

	@Override
	public String toString() {
		return "Operadora [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
