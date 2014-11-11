package br.com.banco.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.Transferencia;

/**
 * 
 * @author Hanna
 *
 */
public class TransferenciaDAO {
	
	/**
	 * Lista transferência
	 */
	private List<Transferencia> transferencias;
	
	/**
	 * Construtor
	 */
	public TransferenciaDAO() {
		transferencias = new ArrayList<Transferencia>();
	}
	
	/**
	 * Cadastra transferências
	 * @param transferencia
	 */
	public void cadastra(Transferencia transferencia){
		//TODO Persistir em banco
		transferencias.add(transferencia);
	}
	
	/**
	 * Recupera transferências cadastradas
	 * @return List<Transferencia>
	 */
	public List<Transferencia> recuperaTransferencias(){
		return transferencias;
	}

}
