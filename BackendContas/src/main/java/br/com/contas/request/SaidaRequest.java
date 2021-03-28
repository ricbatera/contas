package br.com.contas.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
public class SaidaRequest {
	private String descricao;
	private Double valorTotal;
	private LocalDate dataCompra;
	private Boolean parcelada;
	private Integer qtdeParcelas;
	private Long idMeioPagto;
	private Long id;
	private LocalDate dataVencimento;
	private String situacao;
}
