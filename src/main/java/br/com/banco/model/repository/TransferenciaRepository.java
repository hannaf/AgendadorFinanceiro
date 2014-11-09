package br.com.banco.model.repository;

import javax.inject.Inject;

import br.com.banco.model.Transferencia;
import br.com.banco.model.dao.TransferenciaDAO;

public class TransferenciaRepository {
	
	@Inject
	private TransferenciaDAO dao;

	public void cadastra(Transferencia transferencia) {
		this.dao.cadastra(transferencia);
	}
	


}
