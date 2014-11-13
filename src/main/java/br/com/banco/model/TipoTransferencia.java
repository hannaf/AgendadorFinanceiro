package br.com.banco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Hanna
 *
 *
 */
@Entity
@Table(name="tipo_transferencia")
public class TipoTransferencia implements Serializable {
	
	private static final long serialVersionUID = -6698923607071728883L;

	/**
	 * Atributo identificador
	 */
	@Id
	@GeneratedValue
	@Column(name="id_tipo_transferencia")
	private Integer id;
	
	/**
	 * Nome do tipo de transferencia
	 */
	@Column(name="nm_tipo_transferencia")
	private String nome;
	
	/**
	 * Descrição do tipo transferencia
	 * Esse campo deve armazenar as regras de cobrança do tipo de transferencia 
	 */
	@Column(name="ds_tipo_transferencia")
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
