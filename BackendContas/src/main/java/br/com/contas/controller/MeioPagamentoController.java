package br.com.contas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contas.request.MeioPagamentoRequest;
import br.com.contas.service.MeioPagamentoService;

@CrossOrigin
@RequestMapping("/meioPagto")
@RestController
public class MeioPagamentoController {
	
	@Autowired
	private MeioPagamentoService service;

	
	@PostMapping
	public void salvar(@RequestBody MeioPagamentoRequest meioPagamentoRequest) {
		service.salvar(meioPagamentoRequest);
	}

}
