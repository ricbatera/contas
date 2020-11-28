package br.com.contas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contas.dto.ResponsavelDTO;
import br.com.contas.request.ResponsavelRequest;
import br.com.contas.service.ResponsavelService;

@CrossOrigin
@RequestMapping("/responsavel")
@RestController
public class ResponsavelController {
	
	@Autowired
	private ResponsavelService service;

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody ResponsavelRequest responsavelRequest) {
		try {
			ResponsavelDTO responsavelDTO = service.salvar(responsavelRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(responsavelDTO);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
	
	@GetMapping
	public List<ResponsavelDTO>listar(){
		return service.listar();
	}
}
