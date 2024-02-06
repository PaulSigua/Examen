package ec.edu.ups.ppw63.examen63Sigua.service;

import java.util.List;

import ec.edu.ups.ppw63.examen63Sigua.GestionOperadoras;
import ec.edu.ups.ppw63.examen63Sigua.model.HistorialRecargas;
import ec.edu.ups.ppw63.examen63Sigua.model.Operadora;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("operadora")
public class OperadoraServices {
	
	@Inject
	private GestionOperadoras gOperadora;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)//Obtiene los parametros de las consultas y los envia
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Operadora Operadora) {
		try{
			gOperadora.guardarOperadoras(Operadora);
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
	public Response actualizar(Operadora Operadora) {
		try{
			gOperadora.actualizarOperadora(Operadora);
			return Response.ok(Operadora).build();
		}catch (Exception e) {
			// TODO: handle exception
			String error = "99, " + e.getMessage();
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getOperadoras(){
		List<Operadora> Operadoras = gOperadora.getOperadoras();
		if(Operadoras.size()>0)
			return Response.ok(Operadoras).build();
		
		String error = "6, " + "No se registran Operadoras";
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("historial")
	public Response getHistorial(){
		List<HistorialRecargas> Operadoras = gOperadora.getHistorial();
		if(Operadoras.size()>0)
			return Response.ok(Operadoras).build();
		
		String error = "6, " + "No se registran Operadoras";
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}

	
}
