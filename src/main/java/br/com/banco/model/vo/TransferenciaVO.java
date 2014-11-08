package br.com.banco.model.vo;

import java.math.BigDecimal;
import java.util.Date;

import br.com.banco.model.TipoTransferencia;

public class TransferenciaVO {
	
	private int contaOrigem;
	
	private int contaDestino;
	
	private BigDecimal valor;
	
	private BigDecimal taxa;
	
	private Date dataAgendamento;
	
	private TipoTransferencia tipo;

	public int getContaOrigem() {
		return contaOrigem;
	}

	public int getContaDestino() {
		return contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public TipoTransferencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransferencia tipo) {
		this.tipo = tipo;
	}
	
}
