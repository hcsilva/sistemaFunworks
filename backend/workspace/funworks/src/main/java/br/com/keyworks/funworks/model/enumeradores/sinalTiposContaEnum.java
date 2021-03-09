package br.com.keyworks.funworks.model.enumeradores;

public enum sinalTiposContaEnum {

	DEBITO("-", "Débito"), 
	CREDITO("+", "Crédito");

	private String id;
	private String descricao;

	private sinalTiposContaEnum(String id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
