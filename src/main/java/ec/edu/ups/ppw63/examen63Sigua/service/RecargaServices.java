package ec.edu.ups.ppw63.examen63Sigua.service;

import ec.edu.ups.ppw63.examen63Sigua.GestionOperadoras;
import ec.edu.ups.ppw63.examen63Sigua.model.Recarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recarga")
public class RecargaServices {

	@Inject 
	private GestionOperadoras gOperadora;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response transferir(Recarga recarga) {
	    try {
	        gOperadora.recargar(recarga);
	        System.out.println("Recarga: " + recarga);
	        String error = "1, ok";
	        return Response.status(Response.Status.CREATED).entity(error).build();
	    } catch (Exception e) {
	        String error = "99,  " + e.getMessage();
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
	    }
	}
	
}
