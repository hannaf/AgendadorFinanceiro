package br.com.banco.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import br.com.banco.model.ITransferencia;
import br.com.banco.model.TipoTransferencia;
import br.com.banco.model.vo.TransferenciaVO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

@Controller
public class AgendamentoController {
	
	private final Result result;
	
	@Inject
	private ITransferencia transferencia;
	
	private TransferenciaVO transferenciaVO;
	
	private List<TipoTransferencia> tiposLista;
	
	protected AgendamentoController(){
		this(null);
	}
	
	@Inject
	public AgendamentoController(Result result){
		this.result = result;
	}
	
	public void transfere(){
		result.include("tiposLista", this.transferencia.recuperaTiposTransferencia());
		TipoTransferencia tipo = new TipoTransferencia();
		tipo.setNome("D");
		this.transferencia.calculaTaxa(tipo, new BigDecimal("120000.00001"));
	}
	
}
