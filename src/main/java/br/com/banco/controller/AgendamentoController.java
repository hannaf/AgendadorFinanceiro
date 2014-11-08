package br.com.banco.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

@Controller
public class AgendamentoController {
	
	private final Result result;
	
	protected AgendamentoController(){
		this(null);
	}
	
	@Inject
	public AgendamentoController(Result result){
		this.result = result;
	}
	
	public void transfere(){
	}

}
