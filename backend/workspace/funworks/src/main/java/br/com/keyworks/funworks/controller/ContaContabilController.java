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

import br.com.keyworks.funworks.Dto.ContaContabilDto;
import br.com.keyworks.funworks.model.ContaContabil;
import br.com.keyworks.funworks.service.ContaContabilService;

@RestController
@RequestMapping("api/contaContabil")
public class ContaContabilController {

	@Autowired
	private ContaContabilService contabilService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContaContabil salvar(@RequestBody @Valid ContaContabilDto contaContabilDto) {
		return contabilService.save(contaContabilDto);
	}

	@GetMapping("{id}")
	public ContaContabil findById(@PathVariable(value = "id") Long id) {
		return contabilService.findById(id);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Long id) {
		contabilService.deletar(id);
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable(value = "id") Long id, @RequestBody @Valid ContaContabilDto contaContabilDto) {
		contabilService.update(id, contaContabilDto);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<ContaContabil> list(@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "10") Integer tamanhoPagina) {

		Sort sort = Sort.by(Sort.Direction.ASC, "id");
		PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina, sort);
		return contabilService.findAll(pageRequest);

	}

}
