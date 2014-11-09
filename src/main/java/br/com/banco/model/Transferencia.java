package br.com.banco.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class Transferencia {
	
	private int contaOrigem;
	
	private int contaDestino;
	
	@NotNull(message = "{campo.obrigatorio}")
	private BigDecimal valor;
	
	private BigDecimal taxa;
	
	@NotNull(message = "{campo.obrigatorio}")
	private Date dataAgendamento;
	
	@NotNull(message = "{campo.obrigatorio}")
	private TipoTransferencia tipo;

	public int getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(int contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public int getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(int contaDestino) {
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
