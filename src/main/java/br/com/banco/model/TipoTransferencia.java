package br.com.banco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 
 * @author Hanna
 *
 *
 */
@Entity
@Table(name="tipo_transferencia")
@NamedQueries({
	@NamedQuery(name="TipoTransferencia.recuperaTiposTransferencias", query="SELECT tipo FROM TipoTransferencia tipo"),
	@NamedQuery(name="TipoTransferencia.recuperaTipoTransferenciaId", query="SELECT tipo FROM TipoTransferencia tipo where tipo.id = :id"),
})
public class TipoTransferencia implements Serializable {
	
	private static final long serialVersionUID = -6698923607071728883L;

	/**
	 * Atributo identificador
	 */
	@Id
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
	@Size(max=500)
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
