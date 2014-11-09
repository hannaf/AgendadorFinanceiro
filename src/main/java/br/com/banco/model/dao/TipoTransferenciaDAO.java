package br.com.banco.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.TipoTransferencia;

public class TipoTransferenciaDAO {

	public List<TipoTransferencia> recuperaTiposTransferencia() {
		//TODO Persistir em banco
		
		List<TipoTransferencia> tiposLista = new ArrayList<TipoTransferencia>();
		
		TipoTransferencia tipo = new TipoTransferencia();
		tipo.setId(1L);
		tipo.setNome("A");
		tipo.setDescricao("Taxa de $2 mais 3% do valor da transferência");
		tiposLista.add(tipo);
		
		tipo = new TipoTransferencia();
		tipo.setId(1L);
		tipo.setNome("B");
		tipo.setDescricao("Taxa de: $10 para pedidos com agendamento até 30 dias da data de cadastro e $8 para os demais");
		tiposLista.add(tipo);
		
		tipo = new TipoTransferencia();
		tipo.setId(1L);
		tipo.setNome("C");
		tipo.setDescricao("Taxa regressiva conforme a data de agendamento: maior que 30 dias da data de cadastro - 1.2%; "
				+ "até 30 dias da data de cadastro - 2.1%; até 25 dias da data de cadastro - 4.3%; "
				+ "até 20 dias da data de cadastro - 5.4%; até 15 dias da data de cadastro - 6.7%; "
				+ "até 10 dias da data de cadastro - 7.4%; até 5 dias da data de cadastro - 8.3%.");
		tiposLista.add(tipo);
		
		tipo = new TipoTransferencia();
		tipo.setId(1L);
		tipo.setNome("D");
		tipo.setDescricao("Taxa igual a A, B ou C dependendo do valor da transferência. "
				+ "Valores até $25.000 seguem a taxação tipo A. "
				+ "Valores de $25.001 até $120.000 seguem a taxação tipo B. "
				+ "Valores maiores que $120.000 seguem a taxação tipo C");
		tiposLista.add(tipo);
		
		return tiposLista;
	}

}