package br.com.contas.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.com.contas.model.Parcela;
import lombok.Data;

@Data
public class SaidaDTO {
	private Long id;
	private String descricao;
	private List<Parcela> parcelas;
	private LocalDate dataCompra;
	private Boolean parcelada;
	private Double valorTotal;
	
}
