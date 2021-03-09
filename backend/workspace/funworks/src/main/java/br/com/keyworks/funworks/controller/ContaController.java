package br.com.keyworks.funworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.keyworks.funworks.service.ContaService;

@RestController
@RequestMapping("api/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;

}
