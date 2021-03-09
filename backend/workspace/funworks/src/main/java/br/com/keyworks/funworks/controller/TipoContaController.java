package br.com.keyworks.funworks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.keyworks.funworks.Dto.TipoContaDto;
import br.com.keyworks.funworks.model.TipoConta;
import br.com.keyworks.funworks.service.TipoContaService;

@RestController
@RequestMapping("api/tipoConta")
public class TipoContaController {

	@Autowired
	private TipoContaService tipoContaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TipoConta salvar(@RequestBody @Valid TipoContaDto tipoContaDto) {
		return tipoContaService.save(tipoContaDto);
	}

	@GetMapping
	public List<TipoConta> findAll() {
		return tipoContaService.findAll();
	}

	@GetMapping("{id}")
	public TipoConta findById(@PathVariable(value = "id") Long id) {
		return tipoContaService.findById(id);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tipoContaService.deletar(id);
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable(value = "id") Long id, @RequestBody @Valid TipoContaDto tipoContaDto) {
		tipoContaService.update(id, tipoContaDto);
	}

}
