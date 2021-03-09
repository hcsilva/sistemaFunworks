package br.com.keyworks.funworks.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.keyworks.funworks.model.enumeradores.sinalTiposContaEnum;

public class TipoContaDto {
	

	@NotEmpty(message = "{tipoConta.descricao.campoObrigatorio}")
	@Size(max = 200)
	private String descricao;

	@NotEmpty(message = "{tipoConta.tipo.campoObrigatorio}")
	private sinalTiposContaEnum tipo;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public sinalTiposContaEnum getTipo() {
		return tipo;
	}

	public void setTipo(sinalTiposContaEnum tipo) {
		this.tipo = tipo;
	}

}
