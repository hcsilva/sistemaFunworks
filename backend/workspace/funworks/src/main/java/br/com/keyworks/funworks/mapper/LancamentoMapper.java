package br.com.keyworks.funworks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.keyworks.funworks.Dto.LancamentoDto;
import br.com.keyworks.funworks.model.Lancamento;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {

	LancamentoMapper INSTANCE = Mappers.getMapper(LancamentoMapper.class);

	Lancamento toModel(LancamentoDto lancamentoDto);

	LancamentoDto toDto(Lancamento lancamento);

}
