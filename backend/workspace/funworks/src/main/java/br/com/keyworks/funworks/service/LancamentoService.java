package br.com.keyworks.funworks.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.keyworks.funworks.Dto.LancamentoDto;
import br.com.keyworks.funworks.mapper.LancamentoMapper;
import br.com.keyworks.funworks.model.Lancamento;
import br.com.keyworks.funworks.repository.LancamentoRepository;

@Service
public class LancamentoService implements LancamentoMapper {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private LancamentoMapper lancamentoMapper;

	@Transactional
	private Lancamento save(LancamentoDto lancamentoDto) {
		return lancamentoRepository.save(lancamentoMapper.toModel(lancamentoDto));
	}

	public Lancamento findById(Long id) {
		return lancamentoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lançamento não encontrado"));
	}

	public void deletar(Long id) {
		Lancamento lancamento = findById(id);
		lancamentoRepository.delete(lancamento);
	}

	public void update(Long id, LancamentoDto lancamentoDto) {
		Lancamento lancamentoSalvo = findById(id);
		Lancamento lancamento = lancamentoMapper.toModel(lancamentoDto);
		lancamento.setId(lancamentoSalvo.getId());

		lancamentoRepository.save(lancamento);
	}

	@Override
	public Lancamento toModel(LancamentoDto lancamentoDto) {
		if (lancamentoDto == null) {
			return null;
		}

		Lancamento lancamento = new Lancamento();
		lancamento.setConta(lancamentoDto.getConta());
		lancamento.setDataLancamento(LocalDate.now());
		lancamento.setDescricao(lancamentoDto.getDescricao());
		lancamento.setUsuarioLancamento(lancamento.getUsuarioLancamento());
		lancamento.setValor(lancamento.getValor());

		return null;
	}

	@Override
	public LancamentoDto toDto(Lancamento lancamento) {

		return null;
	}

}
