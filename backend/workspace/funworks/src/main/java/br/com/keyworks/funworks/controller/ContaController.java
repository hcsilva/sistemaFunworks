package br.com.keyworks.funworks.controller;

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

import br.com.keyworks.funworks.Dto.ContaDto;
import br.com.keyworks.funworks.model.Conta;
import br.com.keyworks.funworks.service.ContaService;

@RestController
@RequestMapping("api/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Conta save(@RequestBody @Valid ContaDto contaDto) {
		return contaService.save(contaDto);
	}

	@GetMapping("{id}")
	public Conta findById(@PathVariable(value = "id") Long id) {
		return contaService.findById(id);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Long id) {
		contaService.deletar(id);
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable(value = "id") Long id, @RequestBody @Valid ContaDto contaDto) {
		contaService.update(id, contaDto);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Conta> list(@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "10") Integer tamanhoPagina) {

		Sort sort = Sort.by(Sort.Direction.ASC, "id");
		PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina, sort);
		return contaService.findAll(pageRequest);
	}

}
