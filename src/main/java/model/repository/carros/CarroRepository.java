package model.repository.carros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entity.Carro;
import model.repository.Banco;
import model.seletor.carros.CarroSeletor;

public class CarroRepository {

	   public ArrayList<Carro> consultarComFiltros(CarroSeletor seletor) {
	        ArrayList<Carro> carros = new ArrayList<>();
	        String sql = "SELECT * FROM CARRO WHERE 1=1";

	        if (seletor.getModelo() != null && !seletor.getModelo().isEmpty()) {
	            sql += " AND modelo LIKE '%" + seletor.getModelo() + "%'";
	        }
	        if (seletor.getAnoInicial() != null && seletor.getAnoFinal() != null) {
	            sql += " AND ano BETWEEN " + seletor.getAnoInicial() + " AND " + seletor.getAnoFinal();
	        }
	        if (seletor.getValorInicial() != null && seletor.getValorFinal() != null) {
	            sql += " AND valor BETWEEN " + seletor.getValorInicial() + " AND " + seletor.getValorFinal();
	        }

	        try (Connection conn = Banco.getConnection();
	             PreparedStatement pst = conn.prepareStatement(sql);
	             ResultSet rs = pst.executeQuery()) {

	            while (rs.next()) {
	                Carro carro = new Carro();
	                carro.setId(rs.getInt("id"));
	                carro.setModelo(rs.getString("modelo"));
	                carro.setPlaca(rs.getString("placa"));
	                carro.setAno(rs.getInt("ano"));
	                carro.setValor(rs.getDouble("valor"));
	                // Configure outros atributos conforme necessário
	                carros.add(carro);
	            }

	        } catch (SQLException e) {
	            System.out.println("Erro ao consultar carros com filtros");
	            System.out.println("Erro: " + e.getMessage());
	        }

	        return carros;
	    }

}
