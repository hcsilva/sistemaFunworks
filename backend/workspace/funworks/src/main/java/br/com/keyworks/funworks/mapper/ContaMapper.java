package br.com.keyworks.funworks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.keyworks.funworks.Dto.ContaDto;
import br.com.keyworks.funworks.model.Conta;

@Mapper(componentModel = "spring")
public interface ContaMapper {

	ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);
	
	Conta toModel(ContaDto contaDto);
	
	ContaDto toDto(Conta conta);

}
