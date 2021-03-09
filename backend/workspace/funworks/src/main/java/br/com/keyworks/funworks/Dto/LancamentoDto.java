package br.com.keyworks.funworks.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.keyworks.funworks.model.Conta;

public class LancamentoDto {

	@NotNull(message = "{lancamento.valor.campoObrigatorio}")
	private BigDecimal valor;

	@NotEmpty(message = "{lancamento.descricao.campoObrigatorio}")
	@Size(max = 200, message = "{lancamento.descricao.size}")
	private String descricao;

	@NotNull(message = "{lancamento.conta.campoObrigatorio}")
	private Conta conta;

	@NotNull
	private LocalDate dataLancamento;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}
