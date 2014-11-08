package br.com.banco.model;

import java.io.Serializable;

public class TipoTransferencia implements Serializable {
	
	private static final long serialVersionUID = -6698923607071728883L;

	private Long id;
	
	private String nome;
	
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return nome;
	}

}
