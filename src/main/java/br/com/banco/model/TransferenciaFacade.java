package br.com.banco.model;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

public class TransferenciaFacade implements ITransferencia {
	
	@Inject
	private TipoTransferenciaRepository tipoRepository;

	@Override
	public List<TipoTransferencia> recuperaTiposTransferencia() {
		return this.tipoRepository.recuperaTiposTransferencia();
	}

	@Override
	public BigDecimal calculaTaxa(TipoTransferencia tipo, BigDecimal valor) {
		return this.tipoRepository.calculaTaxa(tipo, valor);
	}

}
