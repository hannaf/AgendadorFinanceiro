package br.com.banco.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ITransferencia {
	
	List<TipoTransferencia> recuperaTiposTransferencia();
	
	BigDecimal calculaTaxa(TipoTransferencia tipo, BigDecimal valor, Date dtAgendamento);

}
