package br.com.banco.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Hanna
 *
 */
@Entity
@Table(name="transferencia")
public class Transferencia implements Serializable {

	private static final long serialVersionUID = 1053016088998833390L;
	
	/**
	 * Atributo identificador
	 */
	@Id
	@GeneratedValue
	@Column(name="id_transferencia")
	private Integer id;
	
	/**
	 * Conda de origem
	 */
	@NotNull(message = "{campo.obrigatorio}")
	@Size(min=5 , max=6, message="{conta.invalida}")
	@Column(name="conta_origem")
	private String contaOrigem;
	
	/**
	 * Conda destino
	 */
	@NotNull(message = "{campo.obrigatorio}")
	@Size(min=5 , max=6, message="{conta.invalida}")
	@Column(name="conta_destino")
	private String contaDestino;
	
	/**
	 * Valor
	 */
	@NotNull(message = "{campo.obrigatorio}")
	@Digits(integer=12, fraction=2, message="{valor.invalido}")
	@Column(name="vl_transferencia")
	private BigDecimal valor;
	
	/**
	 * Taxa sobre a transferência
	 */
	@Column(name="taxa_transferencia")
	private BigDecimal taxa;
	
	/**
	 * Dada agendada para a transferência
	 */
	@NotNull(message = "{campo.obrigatorio}")
	@Column(name="dt_transferencia")
	private Date dataAgendamento;
	
	/**
	 * Tipo de transferência
	 */
	@ManyToOne
	@JoinColumn(name="id_tipo_transferencia")
	private TipoTransferencia tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public TipoTransferencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransferencia tipo) {
		this.tipo = tipo;
	}

}
