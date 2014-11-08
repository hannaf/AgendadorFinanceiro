package br.com.banco.model;

import java.util.List;

import javax.inject.Inject;

public class TipoTransferenciaRepository {
	
	@Inject
	private TipoTransferenciaDAO dao;
	
	public List<TipoTransferencia> recuperaTiposTransferencia(){
		return this.dao.recuperaTiposTransferencia();
	}

}
