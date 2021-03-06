package br.com.keyworks.funworks.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.keyworks.funworks.Dto.LancamentoDto;
import br.com.keyworks.funworks.model.Lancamento;
import br.com.keyworks.funworks.service.LancamentoService;

@RestController
@RequestMapping("api/Lancamento")
public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Lancamento salvar(@RequestBody @Valid LancamentoDto lancamentoDto) {
		lancamentoDto.setDataLancamento(LocalDate.now());
		return lancamentoService.save(lancamentoDto);
	}

	@GetMapping("{id}")
	public Lancamento findById(@PathVariable(value = "id") Long id) {
		return lancamentoService.findById(id);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Long id) {
		lancamentoService.deletar(id);
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable(value = "id") Long id, @RequestBody @Valid LancamentoDto lancamentoDto) {
		lancamentoService.update(id, lancamentoDto);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Lancamento> list(@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "10") Integer tamanhoPagina) {

		Sort sort = Sort.by(Sort.Direction.ASC, "id");
		PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina, sort);
		return lancamentoService.findAll(pageRequest);

	}

}
