package br.com.banco.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.banco.model.Transferencia;
import br.com.banco.model.facade.ITransferencia;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
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
	
	@Path("/transferencia")
	public void transfere(){
		result.include("tiposLista", this.transferenciaFacade.recuperaTiposTransferencia());
		result.include("transferencias", this.transferenciaFacade.recuperaTransferencias());
	}
	
	public void confirma(@Valid Transferencia transferencia){
		//TODO arrumar mensagens e validações
		validator.onErrorRedirectTo(this).transfere();
		validaCampos(transferencia);
		this.transferenciaFacade.cadastraTransferencia(transferencia);
		result.forwardTo(this).transfere();
	}

	private void validaCampos(Transferencia transferencia) {
		if(transferencia.getTipo().getId() == null 
				||transferencia.getTipo().getId() == 0){
			validator.add(new I18nMessage("tipo", "campo.obrigatorio"));
		}
		validator.onErrorRedirectTo(this).transfere();
	}
	
//	@Get("/transferencia/calculo")
//	public void calculaTaxa(Integer tipo, String valor, String data){
//		//BigDecimal taxa = this.transferenciaFacade.calculaTaxa(tipo, new BigDecimal(valor), converteData(data));
//		result.use(Results.json()).withoutRoot().from(taxa).serialize();
//	}
//	
//	public Date converteData(String data){
//		return null;
//	}
	
}
