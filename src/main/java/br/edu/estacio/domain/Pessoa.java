package br.edu.estacio.domain;

public class Pessoa {

	//Funciona como autoincremento
	private Long codigo;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long l) {
		this.codigo = l;
	}
	
}
