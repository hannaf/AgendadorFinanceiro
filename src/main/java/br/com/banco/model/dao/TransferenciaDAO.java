package br.com.banco.model.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.banco.model.Transferencia;

/**
 * 
 * @author Hanna
 *
 */
@Stateless
@Local(TransferenciaDAO.class)
public class TransferenciaDAO extends GenericDAO {
	
	/**
	 * Cadastra transferências
	 * @param transferencia
	 */
	public void cadastra(Transferencia transferencia){
		super.getEm().persist(transferencia);
	}
	
	/**
	 * Recupera transferências cadastradas
	 * @return List<Transferencia>
	 */
	public List<Transferencia> recuperaTransferencias(){
		Query query = super.getEm().createNamedQuery("Transferencia.recuperaTransferencias");
		return (List<Transferencia>) query.getResultList();
	}

}
