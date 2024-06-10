package service;

import java.util.ArrayList;

import exception.CarrosException;
import model.entity.Carro;
import model.repository.carros.CarroRepository;
import model.seletor.carros.CarroSeletor;

public class CarroService {

	private CarroRepository repository = new CarroRepository();

	public ArrayList<Carro> consultarComFiltros(CarroSeletor seletor) throws CarrosException {
		if (!seletor.temFiltro()) {
			throw new CarrosException("Pelo menos um filtro deve ser preenchido.");
		}
		return repository.consultarComFiltros(seletor);
	}

}
