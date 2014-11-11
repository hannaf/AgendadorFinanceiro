package br.com.banco.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Since;

public class Transferencia implements Serializable {

	private static final long serialVersionUID = 1053016088998833390L;

	private Integer id;
	
	@NotNull(message = "{campo.obrigatorio}")
	@Size(min=5 , max=6, message="{conta.invalida}")
	private String contaOrigem;
	
	@NotNull(message = "{campo.obrigatorio}")
	@Size(min=5 , max=6, message="{conta.invalida}")
	private String contaDestino;
	
	@NotNull(message = "{campo.obrigatorio}")
	@Digits(integer=12, fraction=2, message="{valor.invalido}")
	private BigDecimal valor;
	
	private BigDecimal taxa;
	
	@NotNull(message = "{campo.obrigatorio}")
	private Date dataAgendamento;
	
	private TipoTransferencia tipo;
	
	private StatusTransferencia status;

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

	public StatusTransferencia getStatus() {
		return status;
	}

	public void setStatus(StatusTransferencia status) {
		this.status = status;
	}
	
}
