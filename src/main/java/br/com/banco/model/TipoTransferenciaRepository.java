package br.com.banco.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class TipoTransferenciaRepository {

	@Inject
	private TipoTransferenciaDAO dao;

	public List<TipoTransferencia> recuperaTiposTransferencia() {
		return this.dao.recuperaTiposTransferencia();
	}

	public BigDecimal calculaTaxa(TipoTransferencia tipo, BigDecimal valor,
			Date dtAgendamento) {
		switch (tipo.getNome()) {
		case "A":
			return calculoTipoA(valor);
		case "B":
			return calculoTipoB(dtAgendamento);
		case "C":
			return calculoTipoC(valor, dtAgendamento);
		case "D":
			if (valor.compareTo(new BigDecimal("25000")) <= 0) {
				return calculoTipoA(valor);
			} else if (valor.compareTo(new BigDecimal("120000")) > 0) {
				return calculoTipoC(valor, dtAgendamento);
			} else {
				return calculoTipoB(dtAgendamento);
			}
		default:
			return null;
		}
	}

	private BigDecimal calculoTipoA(BigDecimal valor) {
		return valor.multiply(new BigDecimal("0.03")).add(new BigDecimal("2"));
	}

	private BigDecimal calculoTipoB(Date dtAgendamento) {
		int qtdDias = calculaDias(dtAgendamento);
		if (qtdDias > 30) {
			return new BigDecimal("8");
		} else {
			return new BigDecimal("10");
		}
	}

	private BigDecimal calculoTipoC(BigDecimal valor, Date dtAgendamento) {
		int qtdDias = calculaDias(dtAgendamento);
		if(qtdDias > 30){
			return valor.multiply(new BigDecimal("0.012"));
		} else if (qtdDias > 25){
			return valor.multiply(new BigDecimal("0.021"));
		} else if (qtdDias > 20){
			return valor.multiply(new BigDecimal("0.043"));
		} else if (qtdDias > 15){
			return valor.multiply(new BigDecimal("0.054"));
		} else if (qtdDias > 10){
			return valor.multiply(new BigDecimal("0.067"));
		} else if (qtdDias > 5){
			return valor.multiply(new BigDecimal("0.074"));
		} else {
			return valor.multiply(new BigDecimal("0.083"));
		}
	}

	/**
	 * Calcula quantidade de dias da data atual até a data agendada.
	 * 
	 * @param dtAgendamento
	 * @return
	 */
	private int calculaDias(Date dtAgendamento) {
		DateTime dataAtual = new DateTime();
		DateTime dataAgendada = new DateTime(dtAgendamento);
		return Days.daysBetween(dataAtual.withTimeAtStartOfDay(), dataAgendada.withTimeAtStartOfDay()).getDays();
	}

}
