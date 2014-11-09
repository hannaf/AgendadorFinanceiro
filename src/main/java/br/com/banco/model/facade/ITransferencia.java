package br.com.banco.model.facade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.banco.model.TipoTransferencia;
import br.com.banco.model.Transferencia;

public interface ITransferencia {
	
	List<TipoTransferencia> recuperaTiposTransferencia();
	
	BigDecimal calculaTaxa(TipoTransferencia tipo, BigDecimal valor, Date dtAgendamento);
	
	void cadastraTransferencia(Transferencia transferencia);

	List<Transferencia> recuperaTransferencias();
	
}
