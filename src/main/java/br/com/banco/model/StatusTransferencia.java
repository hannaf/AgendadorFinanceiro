package br.com.banco.model;

public enum StatusTransferencia {
	
	ALIQUIDAR(1),
	LIQUIDADO(2),
	CANCELADO(3);
	
	private Integer codigo;
	
	StatusTransferencia(Integer codigo){
		this.codigo = codigo;
	}
	
	private Integer getCodigo(){
		return codigo;
	}

}
