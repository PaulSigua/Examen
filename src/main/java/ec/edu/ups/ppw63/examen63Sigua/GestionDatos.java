package ec.edu.ups.ppw63.examen63Sigua;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.examen63Sigua.dao.ClienteDAO;
import ec.edu.ups.ppw63.examen63Sigua.dao.OperadoraDAO;
import ec.edu.ups.ppw63.examen63Sigua.model.Cliente;
import ec.edu.ups.ppw63.examen63Sigua.model.HistorialRecargas;
import ec.edu.ups.ppw63.examen63Sigua.model.Operadora;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private OperadoraDAO daoOperadora;
	
	@PostConstruct
	public void init () {
		System.out.println("iniciando");
		
		Cliente cliente1 = new Cliente();
		cliente1.setDni("0106764830");
		cliente1.setNombre("Paul Sigua");
		cliente1.setTelefono("0963501941");
		cliente1.setAhorro(1);
		
		daoCliente.insert(cliente1);
		
		Cliente cliente2 = new Cliente();
		cliente2.setDni("0103131429");
		cliente2.setNombre("Maria Calle");
		cliente2.setTelefono("0997639973");
		cliente2.setAhorro(1);
		
		daoCliente.insert(cliente2);
		
		Cliente cliente3 = new Cliente();
		cliente3.setDni("0103131429");
		cliente3.setNombre("Maria Calle");
		cliente3.setTelefono("0997639973");
		cliente3.setAhorro(1);
		
		daoCliente.insert(cliente3);
		
		Operadora operadora1 = new Operadora();
		operadora1.setNombre("Movistar");
		operadora1.setCliente(cliente1);
		
		Operadora operadora2 = new Operadora();
		operadora2.setNombre("Claro");
		operadora2.setCliente(cliente2);
		
		Operadora operadora3 = new Operadora();
		operadora3.setNombre("Tuenti");
		operadora3.setCliente(cliente3);
		
		HistorialRecargas his1 = new HistorialRecargas();
		his1.setFecha("2024/02/06");
		his1.setResultadoMonto(1);
		his1.setSaldo(cliente1.getAhorro());
		
		operadora1.addHistorial(his1);
		
		operadora2.addHistorial(his1);
		
		operadora3.addHistorial(his1);
		
		daoOperadora.insert(operadora1);
		daoOperadora.insert(operadora2);
		daoOperadora.insert(operadora3);
		
		System.out.println("\n------------- TotalFacturas");
		List<Cliente> list1 = daoCliente.getAll();
		for (Cliente cue : list1) {
			System.out.println(cue);
		}
		
		System.out.println("\n------------- TotalFacturas");
		List<Operadora> list2 = daoOperadora.getAll();
		for (Operadora op : list2) {
			System.out.println(op);
		}
	}
}
