package br.com.banco.model;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

public class TipoTransferenciaRepository {

	@Inject
	private TipoTransferenciaDAO dao;

	public List<TipoTransferencia> recuperaTiposTransferencia() {
		return this.dao.recuperaTiposTransferencia();
	}

	public BigDecimal calculaTaxa(TipoTransferencia tipo, BigDecimal valor) {
		switch (tipo.getNome()) {
		case "A":
			return calculoTipoA(valor);
		case "B":
			return calculoTipoB(valor);
		case "C":
			return calculoTipoC(valor);
		case "D":
			if(valor.compareTo(new BigDecimal("25000")) <= 0){
				return calculoTipoA(valor);
			} else if(valor.compareTo(new BigDecimal("120000")) > 0){
				return calculoTipoC(valor);
			} else {
				return calculoTipoB(valor);
			}
		default:
			return null;
		}
	}
	
	private BigDecimal calculoTipoA(BigDecimal valor) {
		return null;
	}
	
	private BigDecimal calculoTipoB(BigDecimal valor) {
		return null;
	}

	private BigDecimal calculoTipoC(BigDecimal valor) {
		return null;
	}





}
