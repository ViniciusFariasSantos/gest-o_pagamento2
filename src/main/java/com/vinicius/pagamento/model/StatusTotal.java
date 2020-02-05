package com.vinicius.pagamento.model;

public enum StatusTotal  {
	
	PEDENTE("Pedente"),
	RECEBIDO("Recebido");
	
	
	private String descricao;
	
	private StatusTotal(String descricao) {
		
		this.descricao = descricao;
		
			}

	public String getDescricao() {
		
		return descricao;
	}
}
