package ec.edu.ups.ppw63.examen63Sigua.service;

import java.util.List;

import ec.edu.ups.ppw63.examen63Sigua.GestionClientes;
import ec.edu.ups.ppw63.examen63Sigua.model.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("clientes")
public class ClienteServices {
	
	@Inject
	private GestionClientes gClientes;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)//Obtiene los parametros de las consultas y los envia
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Cliente cliente) {
		try{
			gClientes.guardarClientes(cliente);
			String error = "ok";
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			String error2 = "99, " + e.getMessage();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error2)
					.build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Cliente cliente) {
		try{
			gClientes.actualizarCliente(cliente);
			return Response.ok(cliente).build();
		}catch (Exception e) {
			// TODO: handle exception
			String error = "99, " + e.getMessage();
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("id") int codigo) {
		try{
			gClientes.borrarCliente(codigo);
			return "OK, se borro el cliente";
		}catch (Exception e) {
			// TODO: handle exception
			return "Error al eliminar el cliente";
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Cliente> clientes = gClientes.getClientes();
		if(clientes.size()>0)
			return Response.ok(clientes).build();
		
		String error = "6, " + "No se registran clientes";
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}

}
