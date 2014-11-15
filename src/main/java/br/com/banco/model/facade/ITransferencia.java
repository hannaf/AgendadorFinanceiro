package br.com.banco.model.facade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.banco.model.TipoTransferencia;
import br.com.banco.model.Transferencia;

/**
 * 
 * @author Hanna
 *
 */
public interface ITransferencia {
	
	/**
	 * Recupera tipos de transferência cadastrados
	 * @return List<TipoTransferencia>
	 */
	List<TipoTransferencia> recuperaTiposTransferencia();
	
	/**
	 * Calcula valor da taxa de transferência
	 * @param tipo
	 * @param valor
	 * @param dtAgendamento
	 * @return BigDecimal
	 */
	BigDecimal calculaTaxa(TipoTransferencia tipo, BigDecimal valor, Date dtAgendamento);
	
	/**
	 * Cadastra transferências
	 * @param transferencia
	 */
	void cadastraTransferencia(Transferencia transferencia);

	/**
	 * Recupera transferências cadastradas
	 * @return List<Transferencia>
	 */
	List<Transferencia> recuperaTransferencias();

	/**
	 * Recupera tipo transferência por id
	 * @param idTipo
	 * @return
	 */
	TipoTransferencia recuperaTipoTransferenciaId(Integer idTipo);
	
}
