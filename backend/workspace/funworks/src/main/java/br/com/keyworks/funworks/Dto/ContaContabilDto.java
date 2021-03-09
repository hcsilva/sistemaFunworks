package br.com.keyworks.funworks.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.keyworks.funworks.model.TipoConta;

public class ContaContabilDto {

	@NotEmpty(message = "{contaContabil.descricao.campoObrigatorio}")
	@Size(max = 200, message = "{contaContabil.descricao.size}")
	private String descricao;

	@NotNull(message = "{contaContabil.tipoConta.campoObrigatorio}")
	private TipoConta tipoConta;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

}
