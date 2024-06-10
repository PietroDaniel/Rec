package service;

import exception.MontadorasException;
import model.entity.Montadora;
import model.repository.carros.MontadoraRepository;

public class MontadoraService {
	
	  private MontadoraRepository repository = new MontadoraRepository();

	public Montadora cadastrarMontadora(Montadora montadora) throws Exception {
        if (montadora.getNome() == null || montadora.getNome().isEmpty() ||
            montadora.getPaisFundacao() == null || montadora.getPaisFundacao().isEmpty() ||
            montadora.getPresidente() == null || montadora.getPresidente().isEmpty() ||
            montadora.getDataFundacao() == null) {
            throw new Exception("Todos os campos são obrigatórios.");
        }
        return repository.inserir(montadora);
    }
    
    public Montadora consultarMontadoraPorId(int id) throws MontadorasException {
        return repository.consultarPorId(id);
    }

	
}
