package controller;

import java.util.ArrayList;

import exception.CarrosException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Carro;
import model.seletor.carros.CarroSeletor;
import service.CarroService;

@Path("/carro")
public class CarroController {

	private CarroService service = new CarroService();

	@POST
	@Path("/filtro")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Carro> consultarComFiltros(CarroSeletor seletor) {
		try {
			return service.consultarComFiltros(seletor);
		} catch (CarrosException e) {
			System.out.println("Erro ao consultar carros com filtros: " + e.getMessage());
			return new ArrayList<>();
		}
	}
}