package br.com.contas.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.contas.model.MeioPagamento;
import lombok.Data;

@Data
public class CartaoCreditoDTO {
	private Long id;
	private String nomeCartao;
	private String numeroCartao;
	@DateTimeFormat
	private LocalDate validade;
	private Integer diaVencimento;
	private List<MeioPagamento> meiosPagamentos = new ArrayList<>();
}
