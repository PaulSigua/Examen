package ec.edu.ups.ppw63.examen63Sigua;

import java.util.List;

import ec.edu.ups.ppw63.examen63Sigua.dao.ClienteDAO;
import ec.edu.ups.ppw63.examen63Sigua.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {

	@Inject
	private ClienteDAO daoCliente;

	public void guardarClientes(Cliente cliente) {
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null) {
			daoCliente.update(cliente);
		} else {
			daoCliente.insert(cliente);
		}
	}

	public void actualizarCliente(Cliente cliente) throws Exception {
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null) {
			daoCliente.update(cliente);
		} else {
			throw new Exception("Cliente no existe");
		}
	}

	public Cliente getClientePorCedula(int codigo) {
		return daoCliente.getClienteByCodigo(codigo);
	}

	public void borrarCliente(int codigo) {

		daoCliente.remove(codigo);
	}

	public List<Cliente> getClientes() {
		return daoCliente.getAll();
	}
	
	
}
