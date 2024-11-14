package br.com.fiap.jdbc.model;

public class AreaAtuacao {

	private int idArea;
	private String nome;

	public AreaAtuacao(int idArea, String nome) {
		this.idArea = idArea;
		this.nome = nome;
	}

	public AreaAtuacao() {
		super();
	}

	public int getIdArea() {
		return idArea;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdArea(int int1) {
		
	}

}
