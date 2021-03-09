package br.com.keyworks.funworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.keyworks.funworks.service.ContaContabilService;

@RestController
@RequestMapping("api/contaContabil")
public class ContaContabilController {

	@Autowired
	private ContaContabilService contabilService;

}
