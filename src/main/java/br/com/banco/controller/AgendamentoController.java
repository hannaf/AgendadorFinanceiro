package br.com.banco.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import br.com.banco.model.TipoTransferencia;
import br.com.banco.model.Transferencia;
import br.com.banco.model.facade.ITransferencia;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

@Controller
public class AgendamentoController {
	
	private final Result result;
	
	@Inject
	private ITransferencia transferenciaFacade;
	
	protected AgendamentoController(){
		this(null);
	}
	
	@Inject
	public AgendamentoController(Result result){
		this.result = result;
	}
	
	public void transfere(){
		result.include("tiposLista", this.transferenciaFacade.recuperaTiposTransferencia());
	}
	
	public void confirma(Transferencia transferencia){
		validaCampos(transferencia);
		this.transferenciaFacade.cadastraTransferencia(transferencia);
	}

	private void validaCampos(Transferencia transferencia) {
		
	}
	
}
