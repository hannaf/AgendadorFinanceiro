package br.com.banco.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.banco.model.Transferencia;
import br.com.banco.model.facade.ITransferencia;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class AgendamentoController {
	
	private final Result result;
	
	@Inject
	private ITransferencia transferenciaFacade;
	
	private Validator validator;
	
	protected AgendamentoController(){
		this(null,null);
	}
	
	@Inject
	public AgendamentoController(Result result, Validator validator){
		this.result = result;
		this.validator = validator;
	}
	
	public void transfere(){
		result.include("tiposLista", this.transferenciaFacade.recuperaTiposTransferencia());
	}
	
	public void confirma(@Valid Transferencia transferencia){
		validator.onErrorRedirectTo(this).transfere();
		validaCampos(transferencia);
		this.transferenciaFacade.cadastraTransferencia(transferencia);
	}

	private void validaCampos(Transferencia transferencia) {
		
	}
	
}
