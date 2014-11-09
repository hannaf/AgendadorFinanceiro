package br.com.banco.model.facade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.banco.model.TipoTransferencia;
import br.com.banco.model.Transferencia;
import br.com.banco.model.repository.TipoTransferenciaRepository;
import br.com.banco.model.repository.TransferenciaRepository;

public class TransferenciaFacade implements ITransferencia {
	
	@Inject
	private TipoTransferenciaRepository tipoRepository;
	
	@Inject
	private TransferenciaRepository transferenciaRepository;

	@Override
	public List<TipoTransferencia> recuperaTiposTransferencia() {
		return this.tipoRepository.recuperaTiposTransferencia();
	}

	@Override
	public BigDecimal calculaTaxa(TipoTransferencia tipo, BigDecimal valor, Date dtAgendamento) {
		return this.tipoRepository.calculaTaxa(tipo, valor, dtAgendamento);
	}

	@Override
	public void cadastraTransferencia(Transferencia transferencia) {
		this.transferenciaRepository.cadastra(transferencia);
	}
	
	public List<Transferencia> recuperaTransferencias(){
		return this.transferenciaRepository.recuperaTransferencias();
	}

}
