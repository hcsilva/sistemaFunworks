package br.com.keyworks.funworks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TIPO_CONTA")
public class TipoConta extends AbstractEntity<Long> {

	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	@Column(name = "TIPO", nullable = false)
	private String tipo;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
