package br.com.contas.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ResponsavelDTO {
	private Long id;	
	private String nome;	
    private String sobrenome;
    private Date dataCadastro;
}
