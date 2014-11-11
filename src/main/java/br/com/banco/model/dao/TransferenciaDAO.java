package br.com.banco.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.websocket.Session;

import br.com.banco.model.Transferencia;

/**
 * 
 * @author Hanna
 *
 */
@RequestScoped
public class TransferenciaDAO {
	
	/**
	 * Session
	 */
	private Session session;
	

	/**
	 * Construtor
	 */
	public TransferenciaDAO() {
		this(null);
	}
	
	/**
	 * Construtor
	 */	
	public TransferenciaDAO(Session session) {
		this.session = session;
		List<Transferencia> transferencias = new ArrayList<Transferencia>();
		session.
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
