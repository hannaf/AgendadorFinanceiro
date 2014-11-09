package br.com.banco.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Transferencia {
	
	@Min(6)
	@Max(6)
	private int contaOrigem;
	
	@Min(6)
	@Max(6)
	private int contaDestino;
	
	@NotNull(message = "Teste")
	private BigDecimal valor;
	
	private BigDecimal taxa;
	
	@NotNull(message = "Teste")
	private Date dataAgendamento;
	
	@NotNull(message = "Teste")
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
