package br.com.fiap.jdbc.teste;

import java.sql.Date;

import br.com.fiap.jdbc.dao.AreaAtuacaoDAO;
import br.com.fiap.jdbc.model.Candidato;

public class Teste {

	public static void main(String[] args) {

		AreaAtuacaoDAO daoArea = new AreaAtuacaoDAO();
		Candidato daoCandidato = new Candidato();

		Candidato maria = new Candidato("maria", "adm", "123456", "sp", "m@gmail.com", "F", new Date(12/12/2012), 4);
		
		daoCandidato.insert(maria);
		
//		Candidato mariaUpdate = daoCandidato.selectById(24);
//		mariaUpdate.setNome("Maria Silva");
//		mariaUpdate.setEmail("mariavi;t@gmail.com");
//		daoCandidato.update(mariaUpdate);
		
	}

}
