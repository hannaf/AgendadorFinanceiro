package br.com.banco.model.facade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.banco.model.TipoTransferencia;
import br.com.banco.model.Transferencia;
import br.com.banco.model.repository.TipoTransferenciaRepository;
import br.com.banco.model.repository.TransferenciaRepository;

/**
 * 
 * @author Hanna
 *
 */
public class TransferenciaFacade implements ITransferencia {

	/**
	 * TipoTransferenciaRepository
	 */
	@Inject
	private TipoTransferenciaRepository tipoRepository;

	/**
	 * TransferenciaRepository
	 */
	@Inject
	private TransferenciaRepository transferenciaRepository;

	/**
	 * Recupera tipos de transferência cadastrados
	 * @return List<TipoTransferencia>
	 */
	@Override
	public List<TipoTransferencia> recuperaTiposTransferencia() {
		return this.tipoRepository.recuperaTiposTransferencia();
	}

	/**
	 * Calcula valor da taxa de transferência
	 * @param tipo
	 * @param valor
	 * @param dtAgendamento
	 * @return BigDecimal
	 */
	@Override
	public BigDecimal calculaTaxa(TipoTransferencia tipo, BigDecimal valor,
			Date dtAgendamento) {
		return this.tipoRepository.calculaTaxa(tipo, valor, dtAgendamento);
	}

	/**
	 * Cadastra transferências
	 * @param transferencia
	 */
	@Override
	public void cadastraTransferencia(Transferencia transferencia) {
		transferencia.setTaxa(this.tipoRepository.calculaTaxa(
				transferencia.getTipo(), transferencia.getValor(),
				transferencia.getDataAgendamento()));
		this.transferenciaRepository.cadastra(transferencia);
	}

	/**
	 * Recupera transferências cadastradas
	 * @return List<Transferencia>
	 */
	@Override
	public List<Transferencia> recuperaTransferencias() {
		return this.transferenciaRepository.recuperaTransferencias();
	}

	/**
	 * Recupera tipo transferência por id
	 */
	@Override
	public TipoTransferencia recuperaTipoTransferenciaId(Integer idTipo) {
		return this.tipoRepository.recuperaTipoTransferenciaId(idTipo);
	}

}
