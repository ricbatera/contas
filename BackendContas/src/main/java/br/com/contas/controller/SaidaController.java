package br.com.contas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contas.request.SaidaRequest;
import br.com.contas.service.SaidaService;

@CrossOrigin
@RequestMapping("/saida")
@RestController
public class SaidaController {
	
	@Autowired
	private SaidaService saidaService;
	
	@PostMapping
	public void salvar(@RequestBody SaidaRequest saidaRequest) {
		saidaService.salvar(saidaRequest);
	}

}
