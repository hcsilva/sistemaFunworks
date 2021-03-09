package br.com.keyworks.funworks.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.keyworks.funworks.model.ContaContabil;

public class ContaDto {

	@NotEmpty(message = "{conta.descricao.campoObrigatorio}")
	@Size(max = 200, message = "{conta.descricao.size}")
	private String descricao;

	@NotNull(message = "{conta.contaContabil.campoObrigatorio}")
	private ContaContabil contaContabil;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ContaContabil getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(ContaContabil contaContabil) {
		this.contaContabil = contaContabil;
	}

}
