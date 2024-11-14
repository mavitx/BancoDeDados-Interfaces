package br.com.fiap.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.jdbc.factory.ConnectionFactory;
import br.com.fiap.jdbc.model.AreaAtuacao;
import br.com.fiap.jdbc.model.Candidato;

public class AreaAtuacaoDAO {

	private Connection connection;

	public AreaAtuacaoDAO() {
		this.connection = new ConnectionFactory().conectar();
	}

	public void insert(AreaAtuacao areaAtuacao) {
		String sql = "insert into areaAtuacao (idArea, nome) values (?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, areaAtuacao.getIdArea());
			stmt.setString(2, areaAtuacao.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(long idArea) {
		String sql = "delete * from areaAtuacao where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idArea);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(AreaAtuacao areaAtuacao) {
		String sql = "update areaAtuacao set idArea=? where nome=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, areaAtuacao.getIdArea());
			stmt.setString(2, areaAtuacao.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

	public List<AreaAtuacao> selectAll() {
		List<AreaAtuacao> listaAreaAtuacao = new ArrayList<AreaAtuacao>();
		String sql = "select * from areaAtuacao order by nome";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				AreaAtuacao areaAtuacao = new AreaAtuacao();
				areaAtuacao.setIdArea(rs.getInt("nome"));
				areaAtuacao.setNome(rs.getString("nome"));
				listaAreaAtuacao.add(areaAtuacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAreaAtuacao;
	}

	public AreaAtuacao selectById(long idArea) {
		AreaAtuacao areaAtuacao = null;
		String sql = "select * from areaAtuacao where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idArea);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				areaAtuacao = new AreaAtuacao();
				areaAtuacao.setNome(rs.getString("nome"));
			}
				
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areaAtuacao;
		}

}
