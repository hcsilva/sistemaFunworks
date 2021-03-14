package br.com.keyworks.funworks.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
	public Lancamento save(LancamentoDto lancamentoDto) {
		return lancamentoRepository.save(lancamentoMapper.toModel(lancamentoDto));
	}

	@Transactional(readOnly = true)
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

	@Transactional(readOnly = true)
	public List<Lancamento> findAll() {
		return lancamentoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Lancamento> findAll(Pageable pageable) {
		return lancamentoRepository.findAll(pageable);
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

		return lancamento;
	}

	@Override
	public LancamentoDto toDto(Lancamento lancamento) {

		return null;
	}

}
