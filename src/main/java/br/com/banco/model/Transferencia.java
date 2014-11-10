package br.com.banco.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class Transferencia {
	
	private Integer id;
	
	private Integer contaOrigem;
	
	private Integer contaDestino;
	
	@NotNull(message = "{campo.obrigatorio}")
	private BigDecimal valor;
	
	private BigDecimal taxa;
	
	@NotNull(message = "{campo.obrigatorio}")
	private Date dataAgendamento;
	
	@NotNull(message = "{campo.obrigatorio}")
	private TipoTransferencia tipo;
	
	private StatusTransferencia status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Integer contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Integer getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Integer contaDestino) {
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

	public StatusTransferencia getStatus() {
		return status;
	}

	public void setStatus(StatusTransferencia status) {
		this.status = status;
	}
	
}
