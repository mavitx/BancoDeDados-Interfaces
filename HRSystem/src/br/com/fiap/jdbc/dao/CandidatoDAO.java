package br.com.fiap.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.jdbc.factory.ConnectionFactory;
import br.com.fiap.jdbc.model.Candidato;

public class CandidatoDAO {

	private Connection connection;

	public CandidatoDAO() {
		this.connection = new ConnectionFactory().conectar();
	}

	public void insert(Candidato candidato) {
		String sql = "insert into candidato (nome, formacao, telefone, endereco, email, "
				+ "genero, dataNascimento, tempoExp) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, candidato.getNome());
			stmt.setString(2, candidato.getFormacao());
			stmt.setString(3, candidato.getTelefone());
			stmt.setString(4, candidato.getEndereco());
			stmt.setString(5, candidato.getEmail());
			stmt.setString(6, candidato.getGenero().name());
			stmt.setObject(7, candidato.getDataNascimento());
			stmt.setInt(8, candidato.getTempoExp());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(long idCandidato) {
		String sql = "delete * from candidato where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idCandidato);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Candidato candidato) {
		String sql = "update candidato set nome=?, formacao=?, telefone=?, endereco=?, email=?, genero=?,"
				+ " dataNascimento=? where tempoExp=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, candidato.getNome());
			stmt.setString(2, candidato.getFormacao());
			stmt.setString(3, candidato.getTelefone());
			stmt.setString(4, candidato.getEndereco());
			stmt.setString(5, candidato.getEmail());
			stmt.setString(6, candidato.getGenero().name());
			stmt.setObject(7, candidato.getDataNascimento());
			stmt.setInt(8, candidato.getTempoExp());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Candidato> selectAll() {
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();
		String sql = "select * from candidato order by nome";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Candidato candidato = new Candidato();
				candidato.setNome(rs.getString("nome"));
				candidato.setFormacao(rs.getString("formacao"));
				candidato.setTelefone(rs.getString("telefone"));
				candidato.setEndereco(rs.getString("endereco"));
				candidato.setEmail(rs.getString("email"));
//				candidato.setGenero(rs.getString("genero"));
				candidato.setDataNascimento(rs.getDate("dataNascimento"));
				listaCandidatos.add(candidato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCandidatos;
	}

	public Candidato selectById(long id) {
		Candidato candidato = null;
		String sql = "select * from candidato where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				candidato = new Candidato();
				candidato.setNome(rs.getString("nome"));
				candidato.setFormacao(rs.getString("formacao"));
				candidato.setTelefone(rs.getString("telefone"));
				candidato.setEndereco(rs.getString("endereco"));
				candidato.setEmail(rs.getString("email"));
//				candidato.setGenero(rs.getString("genero"));
				candidato.setDataNascimento(rs.getDate("dataNascimento"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candidato;
	}
}
