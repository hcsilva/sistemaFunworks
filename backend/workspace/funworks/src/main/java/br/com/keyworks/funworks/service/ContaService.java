package br.com.keyworks.funworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.keyworks.funworks.Dto.ContaDto;
import br.com.keyworks.funworks.mapper.ContaMapper;
import br.com.keyworks.funworks.model.Conta;
import br.com.keyworks.funworks.repository.ContaRepository;

@Service
public class ContaService implements ContaMapper {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ContaMapper contaMapper;

	@Transactional
	public Conta save(ContaDto contaDto) {
		return contaRepository.save(contaMapper.toModel(contaDto));
	}

	@Transactional(readOnly = true)
	public List<Conta> findAll() {
		return contaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Conta> findAll(Pageable pageable) {
		return contaRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Conta findById(Long id) {
		return contaRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrado"));
	}

	public void deletar(Long id) {
		Conta conta = findById(id);
		contaRepository.delete(conta);
	}

	public void update(Long id, ContaDto contaDto) {
		Conta contaSalva = findById(id);
		Conta conta = contaMapper.toModel(contaDto);
		conta.setId(contaSalva.getId());
		contaRepository.save(conta);
	}

	@Override
	public Conta toModel(ContaDto contaDto) {

		if (contaDto == null) {
			return null;
		}

		Conta conta = new Conta();
		conta.setDescricao(contaDto.getDescricao());
		conta.setContaContabil(contaDto.getContaContabil());

		return conta;
	}

	@Override
	public ContaDto toDto(Conta conta) {
		// TODO Auto-generated method stub
		return null;
	}

}
