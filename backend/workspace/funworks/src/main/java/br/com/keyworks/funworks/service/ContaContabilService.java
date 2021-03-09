package br.com.keyworks.funworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public ContaContabil toModel(ContaContabilDto contaContabilDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContaContabilDto toDto(ContaContabil contaContabil) {
		// TODO Auto-generated method stub
		return null;
	}

}
