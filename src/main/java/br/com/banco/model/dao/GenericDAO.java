package br.com.banco.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Hanna
 *
 */
public class GenericDAO {
	
	/**
	 * EntityManager
	 */
	@PersistenceContext(name="agendador-financeiro")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

}
