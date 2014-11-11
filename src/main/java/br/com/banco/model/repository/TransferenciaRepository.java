package br.com.banco.model.repository;

import java.util.List;

import javax.inject.Inject;

import br.com.banco.model.Transferencia;
import br.com.banco.model.dao.TransferenciaDAO;

/**
 * 
 * @author Hanna
 *
 */
public class TransferenciaRepository {
	
	@Inject
	private TransferenciaDAO dao;

	/**
	 * Cadastra transferências
	 * @param transferencia
	 */
	public void cadastra(Transferencia transferencia) {
		this.dao.cadastra(transferencia);
	}
	
	/**
	 * Recupera transferências cadastradas
	 * @return List<Transferencia>
	 */
	public List<Transferencia> recuperaTransferencias(){
		return this.dao.recuperaTransferencias();
	}

}
