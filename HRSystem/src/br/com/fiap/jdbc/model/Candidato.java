package br.com.fiap.jdbc.model;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class Candidato {

	private long idCandidato; // PK
	private String nome, formacao, telefone, endereco, email;
	Genero genero;
	private Date dataNascimento;
	private int tempoExp;
	private long idArea; // FK

	public Candidato(String nome, String formacao, String telefone, String endereco, String email, Genero genero,
			Date dataNascimento, int tempoExp) {
		this.nome = nome;
		this.formacao = formacao;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.genero = genero;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		this.dataNascimento = dataNascimento;
		this.tempoExp = tempoExp;
	}

	public Candidato() {

	}

	public Candidato(String nome2, String formacao2, String telefone2, String endereco2, String email2, String string,
			Date dataNascimento2, int tempoExp2) {
	}

	public long getIdCandidato() {
		return idCandidato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getTempoExp() {
		return tempoExp;
	}

	public void setTempoExp(int tempoExp) {
		this.tempoExp = tempoExp;
	}

	public long getIdArea() {
		return idArea;
	}

	public void setIdArea(long idArea) {
		this.idArea = idArea;
	}

	public Candidato selectById(int i) {
		return null;
	}

	public void update(Candidato mariaUpdate) {
		
	}

	public void insert(Candidato maria) {
		
	}

}
