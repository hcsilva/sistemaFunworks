package br.com.keyworks.funworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.keyworks.funworks.Dto.ContaContabilDto;
import br.com.keyworks.funworks.mapper.ContaContabilMapper;
import br.com.keyworks.funworks.model.ContaContabil;
import br.com.keyworks.funworks.repository.ContaContabilRepository;

@Service
public class ContaContabilService implements ContaContabilMapper {

	@Autowired
	private ContaContabilRepository contaContabilRepository;

	@Autowired
	private ContaContabilMapper contaContabilMapper;

	@Transactional
	public ContaContabil save(ContaContabilDto contaContabilDto) {
		return contaContabilRepository.save(contaContabilMapper.toModel(contaContabilDto));
	}

	@Transactional(readOnly = true)
	public ContaContabil findById(Long id) {
		return contaContabilRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta Contabil não encontrada"));
	}

	public void deletar(Long id) {
		ContaContabil contaContabil = findById(id);
		contaContabilRepository.delete(contaContabil);
	}

	public void update(Long id, ContaContabilDto contaContabilDto) {
		ContaContabil contaContabilSalva = findById(id);
		ContaContabil contaContabil = contaContabilMapper.toModel(contaContabilDto);
		contaContabil.setId(contaContabilSalva.getId());

		contaContabilRepository.save(contaContabil);
	}

	@Transactional(readOnly = true)
	public List<ContaContabil> findAll() {
		return contaContabilRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<ContaContabil> findAll(Pageable pageable) {
		return contaContabilRepository.findAll(pageable);
	}

	@Override
	public ContaContabil toModel(ContaContabilDto contaContabilDto) {
		if (contaContabilDto != null) {
			return null;
		}

		ContaContabil contaContabil = new ContaContabil();
		contaContabil.setDescricao(contaContabilDto.getDescricao());
		contaContabil.setTipoConta(contaContabilDto.getTipoConta());

		return contaContabil;
	}

	@Override
	public ContaContabilDto toDto(ContaContabil contaContabil) {
		// TODO Auto-generated method stub
		return null;
	}

}
