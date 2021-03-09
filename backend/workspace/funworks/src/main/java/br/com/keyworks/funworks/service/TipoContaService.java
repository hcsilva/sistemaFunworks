package br.com.keyworks.funworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.keyworks.funworks.Dto.TipoContaDto;
import br.com.keyworks.funworks.mapper.TipoContaMapper;
import br.com.keyworks.funworks.model.TipoConta;
import br.com.keyworks.funworks.repository.TipoContaRepository;

@Service
public class TipoContaService implements TipoContaMapper {

	@Autowired
	private TipoContaRepository tipoContaRepository;

	@Autowired
	private TipoContaMapper tipoContaMapper;

	@Transactional
	public TipoConta save(TipoContaDto tipoContaDto) {
		return tipoContaRepository.save(tipoContaMapper.toModel(tipoContaDto));
	}

	@Transactional(readOnly = true)
	public List<TipoConta> findAll() {
		return tipoContaRepository.findAll();
	}

	public TipoConta findById(Long id) {
		return tipoContaRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo Conta Não encontrada"));
	}

	public void deletar(Long id) {
		TipoConta tipoConta = findById(id);
		tipoContaRepository.delete(tipoConta);
	}

	public void update(Long id, TipoContaDto tipoContaDto) {
		TipoConta tipoContaSalvo = findById(id);
		TipoConta tipoConta = tipoContaMapper.toModel(tipoContaDto);
		tipoConta.setId(tipoContaSalvo.getId());

		tipoContaRepository.save(tipoConta);
	}

	@Override
	public TipoConta toModel(TipoContaDto tipoContaDto) {
		if (tipoContaDto == null) {
			return null;
		}

		TipoConta tipoConta = new TipoConta();
		tipoConta.setDescricao(tipoContaDto.getDescricao());
		tipoConta.setTipo(tipoContaDto.getTipo().getId());

		return tipoConta;
	}

	@Override
	public TipoContaDto toDto(TipoConta tipoConta) {
		return null;
	}

}
