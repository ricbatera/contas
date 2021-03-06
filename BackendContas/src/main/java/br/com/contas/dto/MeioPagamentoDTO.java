package br.com.contas.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MeioPagamentoDTO {
	private Long id;
	private String descricao;
	private String tipo;
	private String nomeCartao;
	private String numeroCartao;
	@DateTimeFormat
	private LocalDate validade;
	private Integer diaVencimento;
}
