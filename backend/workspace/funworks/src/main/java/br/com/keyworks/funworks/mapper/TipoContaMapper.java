package br.com.keyworks.funworks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.keyworks.funworks.Dto.TipoContaDto;
import br.com.keyworks.funworks.model.TipoConta;

@Mapper(componentModel = "spring")
public interface TipoContaMapper {
	
	TipoContaMapper INSTANCE = Mappers.getMapper(TipoContaMapper.class);

	TipoConta toModel(TipoContaDto tipoContaDto);

	TipoContaDto toDto(TipoConta tipoConta);
}
