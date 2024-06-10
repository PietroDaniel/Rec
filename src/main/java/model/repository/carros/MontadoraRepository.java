package model.repository.carros;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entity.Montadora;
import model.repository.Banco;

public class MontadoraRepository {

	public Montadora inserir(Montadora novaMontadora) {
		String sql = "INSERT INTO montadora (nome, pais, presidente, data_fundacao) VALUES (?, ?, ?, ?)";
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);

		try {
			stmt.setString(1, novaMontadora.getNome());
			stmt.setString(2, novaMontadora.getPaisFundacao());
			stmt.setString(3, novaMontadora.getPresidente());
			stmt.setDate(4, Date.valueOf(novaMontadora.getDataFundacao()));

			stmt.execute();
			ResultSet resultado = stmt.getGeneratedKeys();
			if (resultado.next()) {
				novaMontadora.setId(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir nova montadora");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return novaMontadora;
	}

	public Montadora consultarPorId(int id) {
		String sql = "SELECT * FROM montadora WHERE id = ?";
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		Montadora montadora = null;

		try {
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				montadora = new Montadora();
				montadora.setId(resultado.getInt("id"));
				montadora.setNome(resultado.getString("nome"));
				montadora.setPaisFundacao(resultado.getString("pais"));
				montadora.setPresidente(resultado.getString("presidente"));
				montadora.setDataFundacao(resultado.getDate("data_fundacao").toLocalDate());
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar montadora com id: " + id);
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return montadora;
	}

}
