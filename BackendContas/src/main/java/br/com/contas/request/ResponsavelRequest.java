package br.com.contas.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ResponsavelRequest {
	private Long id;
	@NotBlank
	private String nome;	
    private String sobrenome;
}
