package br.com.banco.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Hanna
 *
 */
public class Transferencia implements Serializable {

	private static final long serialVersionUID = 1053016088998833390L;
	
	/**
	 * Atributo identificador
	 */
	private Integer id;
	
	/**
	 * Conda de origem
	 */
	@NotNull(message = "{campo.obrigatorio}")
	@Size(min=5 , max=6, message="{conta.invalida}")
	private String contaOrigem;
	
	/**
	 * Conda destino
	 */
	@NotNull(message = "{campo.obrigatorio}")
	@Size(min=5 , max=6, message="{conta.invalida}")
	private String contaDestino;
	
	/**
	 * Valor
	 */
	@NotNull(message = "{campo.obrigatorio}")
	@Digits(integer=12, fraction=2, message="{valor.invalido}")
	private BigDecimal valor;
	
	/**
	 * Taxa sobre a transferência
	 */
	private BigDecimal taxa;
	
	/**
	 * Tipo de transferência
	 */
	@NotNull(message = "{campo.obrigatorio}")
	private Date dataAgendamento;
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
