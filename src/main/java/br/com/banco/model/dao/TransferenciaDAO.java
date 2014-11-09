package br.com.banco.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.Transferencia;

public class TransferenciaDAO {
	
	private List<Transferencia> transferencias;
	
	public TransferenciaDAO() {
		transferencias = new ArrayList<Transferencia>();
	}
	
	public void cadastra(Transferencia transferencia){
		//TODO Persistir em banco
		transferencias.add(transferencia);
	}

}
