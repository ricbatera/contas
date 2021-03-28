package br.com.contas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contas.dto.CartaoCreditoDTO;
import br.com.contas.dto.MeioPagamentoDTO;
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

	@GetMapping
	public List<MeioPagamentoDTO> listar() {
		return service.listar();
	}

	@GetMapping("/vencimentos")
	public ResponseEntity<?> buscaVencimentosCartoes() {
		List<CartaoCreditoDTO> vencimentos = service.buscaVencimentosCartoes();
		if (vencimentos.size() == 0) {
			return ResponseEntity.badRequest().body("Não encontrou cartões com vencimentos");
		}
		return ResponseEntity.ok(vencimentos);
	}

}
