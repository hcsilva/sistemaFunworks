package br.com.keyworks.funworks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.keyworks.funworks.Dto.ContaContabilDto;
import br.com.keyworks.funworks.model.ContaContabil;

@Mapper(componentModel = "spring")
public interface ContaContabilMapper {

	ContaContabilMapper INSTANCE = Mappers.getMapper(ContaContabilMapper.class);

	ContaContabil toModel(ContaContabilDto contaContabilDto);

	ContaContabilDto toDto(ContaContabil contaContabil);

}
