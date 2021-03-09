package br.com.keyworks.funworks.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "LANCAMENTOS")
public class Lancamento extends AbstractEntity<Long> {

	@Column(name = "VALOR", scale = 14, precision = 2)
	private BigDecimal valor;

	@Column(name = "DESCRICAO")
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONTA")
	private Conta conta;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DATA_LANCAMENTO")
	private LocalDate dataLancamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIO_LANCAMENTO")
	private Usuario usuarioLancamento;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Usuario getUsuarioLancamento() {
		return usuarioLancamento;
	}

	public void setUsuarioLancamento(Usuario usuarioLancamento) {
		this.usuarioLancamento = usuarioLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}
