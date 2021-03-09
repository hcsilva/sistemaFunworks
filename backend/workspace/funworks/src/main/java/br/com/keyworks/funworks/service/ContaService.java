package br.com.keyworks.funworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public Conta toModel(ContaDto contaDto) {
		
		return null;
	}

	@Override
	public ContaDto toDto(Conta conta) {
		// TODO Auto-generated method stub
		return null;
	}

}
