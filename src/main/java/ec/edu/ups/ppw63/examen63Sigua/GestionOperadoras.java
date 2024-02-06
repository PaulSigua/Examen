package ec.edu.ups.ppw63.examen63Sigua;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.examen63Sigua.dao.ClienteDAO;
import ec.edu.ups.ppw63.examen63Sigua.dao.HistorialDAO;
import ec.edu.ups.ppw63.examen63Sigua.dao.OperadoraDAO;
import ec.edu.ups.ppw63.examen63Sigua.model.Cliente;
import ec.edu.ups.ppw63.examen63Sigua.model.HistorialRecargas;
import ec.edu.ups.ppw63.examen63Sigua.model.Operadora;
import ec.edu.ups.ppw63.examen63Sigua.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionOperadoras {

	@Inject
	private OperadoraDAO daoOperadora;
	
	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private HistorialDAO daoHis;

	public void guardarOperadoras(Operadora Operadora) {
		Operadora cli = daoOperadora.read(Operadora.getCodigo());
		if (cli != null) {
			daoOperadora.update(Operadora);
		} else {
			daoOperadora.insert(Operadora);
		}
	}

	public void actualizarOperadora(Operadora Operadora) throws Exception {
		Operadora cli = daoOperadora.read(Operadora.getCodigo());
		if (cli != null) {
			daoOperadora.update(Operadora);
		} else {
			throw new Exception("Operadora no existe");
		}
	}

	public Operadora getOperadoraByCodigo(int codigo){
		return daoOperadora.getOperadoraPorCodigo(codigo);
	}

	public void borrarOperadora(int codigo) {

		daoOperadora.remove(codigo);
	}

	public List<Operadora> getOperadoras() {
		return daoOperadora.getAll();
	}
	
	public List<HistorialRecargas> getHistorial(){
		return daoHis.getAll();
	}
	
	public Cliente getClienteById(int codigo) {
		return daoCliente.getClienteByCodigo(codigo);
	}
	
	public void recargar (Recarga recarga) {
		Cliente clienteDestino = getClienteById(recarga.getClienteDes());
		Operadora operadora = getOperadoraByCodigo(recarga.getOperadora());
		
		System.out.println("Cliente antes: " + recarga.getClienteDes());
		
		System.out.println("Monto: " + recarga.getMonto());
		
		clienteDestino.setAhorro(clienteDestino.getAhorro() + recarga.getMonto());
		
		HistorialRecargas his = new HistorialRecargas();
		
		String fecha = "2024/02/06";
		
		his.setFecha(fecha);
		his.setResultadoMonto(recarga.getMonto());
		his.setSaldo(clienteDestino.getAhorro());
		
		operadora.addHistorial(his);
		
		System.out.println("Cliente final: " + getClienteById(recarga.getClienteDes()));
		
		daoCliente.update(clienteDestino);
	}
}
