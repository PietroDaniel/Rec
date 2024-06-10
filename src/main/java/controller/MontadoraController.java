package controller;

import exception.MontadorasException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Montadora;
import service.MontadoraService;

@Path("/montadora")
public class MontadoraController {

	private MontadoraService montadoraService = new MontadoraService();

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Montadora cadastrarMontadora(Montadora montadora) throws Exception {
		return montadoraService.cadastrarMontadora(montadora);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Montadora consultarMontadoraPorId(@PathParam("id") int id) throws MontadorasException {
		return montadoraService.consultarMontadoraPorId(id);
	}

}