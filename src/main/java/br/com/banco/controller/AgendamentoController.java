package br.com.banco.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;

import br.com.banco.SiteUtil;
import br.com.banco.model.TipoTransferencia;
import br.com.banco.model.Transferencia;
import br.com.banco.model.facade.ITransferencia;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

/**
 * 
 * @author Hanna
 * 
 *         Classe controle de agendamento de transferência
 * 
 */
@Controller
public class AgendamentoController {

	/**
	 * Result
	 */
	private final Result result;

	/**
	 * ITransferencia
	 */
	@Inject
	private ITransferencia transferenciaFacade;

	/**
	 * Validator
	 */
	private Validator validator;

	/**
	 * Contrutor
	 */
	protected AgendamentoController() {
		this(null, null);
	}

	/**
	 * Contrutor
	 */
	@Inject
	public AgendamentoController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	/**
	 * Método inicial da transferência
	 */
	@Path("/transferencia")
	public void transfere() {
		result.include("tiposLista",
				this.transferenciaFacade.recuperaTiposTransferencia());
		result.include("transferencias",
				this.transferenciaFacade.recuperaTransferencias());
	}

	/**
	 * Método de cadastramento de agendamento de transferência
	 * 
	 * @param transferencia
	 */
	public void confirma(@Valid Transferencia transferencia) {
		// TODO arrumar mensagens e validações
		validator.onErrorRedirectTo(this).transfere();
		validaCampos(transferencia);
		this.transferenciaFacade.cadastraTransferencia(transferencia);
		result.include("sucesso", "Transferência agendada com sucesso");
		result.redirectTo(this).transfere();
	}

	/**
	 * Valida campos do formulário
	 * 
	 * @param transferencia
	 */
	private void validaCampos(Transferencia transferencia) {
		if (transferencia.getTipo().getId() == null
				|| transferencia.getTipo().getId() == 0) {
			validator.add(new I18nMessage("tipo", "campo.obrigatorio", "Tipo"));
		}
		if (SiteUtil.calculaDias(transferencia.getDataAgendamento()) < 0) {
			validator.add(new I18nMessage("dataAgendamento",
					"data.agendamento.anterior", "Data Agendamento"));
		}
		validator.onErrorRedirectTo(this).transfere();
	}

	@Get("/transferencia/calculo")
	public void calculaTaxa(Integer idTipo, String valor, String data) {
		if (validaParametros(idTipo, valor, data)) {
			TipoTransferencia tipo = new TipoTransferencia();
			tipo.setId(idTipo);
			BigDecimal taxa = this.transferenciaFacade.calculaTaxa(tipo,
					SiteUtil.converteStringParaBigDecimal(valor),
					SiteUtil.converteStringParaDate(data));
			result.use(Results.json()).withoutRoot().from(taxa).serialize();
		}
	}

	private boolean validaParametros(Integer idTipo, String valor, String data) {
		if (idTipo == null
				|| (idTipo != null && this.transferenciaFacade
						.recuperaTipoTransferenciaId(idTipo) == null)) {
			return false;
		}
		if(valor == null || (valor != null && SiteUtil.converteStringParaBigDecimal(valor) == null)){
			return false;
		}
		if(data == null || (data != null && SiteUtil.converteStringParaDate(data) == null)){
			return false;
		}
		return true;
	}


}
