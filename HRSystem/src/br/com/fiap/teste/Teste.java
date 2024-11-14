package br.com.fiap.teste;

import java.sql.SQLException;
import br.com.fiap.controller.AppController;
import br.com.fiap.model.Candidato;
import br.com.fiap.model.Genero;

public class Teste {

	public static void main(String[] args) throws SQLException {

		AppController app = AppController.getInstance();

		// 1. Teste de Inserção
		System.out.println("Inserindo candidatos...");
		Candidato emerson = new Candidato("Emerson", "99999-0000", "emerson@gmail.com", "Rua A", "Engenheiro",
				"13/11/1978", Genero.MASCULINO, 20, 1);
		Candidato adriane = new Candidato("Adriane", "88888-1111", "adriane@gmail.com", "Rua B", "Analista",
				"13/11/1977", Genero.FEMININO, 10, 2);
		app.adicionarCandidato(emerson);
		app.adicionarCandidato(adriane);
		System.out.println("Inserção concluída.\n");

		// 2. Teste de Consulta
		System.out.println("Consultando todos os candidatos:");
		app.buscarTodosCandidatos();

		// Consulta por ID
		System.out.println("\nConsultando candidato por ID:");
		app.buscarCandidato(3);

		// Consulta por Área
		System.out.println("\nConsultando candidatos por Área de Atuação:");
		app.buscarCandidatoPorArea(1);

		// 3. Teste de Atualização
		System.out.println("\nAtualizando candidato:");
		emerson.setNome("Emerson Silva");
		emerson.setEmail("emerson.silva@gmail.com");
		app.alterarCandidato(emerson);
		System.out.println("Candidato atualizado.\n");

		// 4. Teste de Exclusão
		System.out.println("Excluindo candidato:");
		app.excluirCandidato(5);
		System.out.println("Candidato excluído.\n");

		// Consulta final para verificar exclusão
		System.out.println("Consultando todos os candidatos após exclusão:");
		app.buscarTodosCandidatos();

	}
}
