package br.com.contas.request;

import br.com.contas.model.CartaoCredito;
import br.com.contas.model.ContaBancaria;
import lombok.Data;

@Data
public class MeioPagamentoRequest {
	private String descricao;
	private String tipo;
	private CartaoCredito cartao;
	private ContaBancaria conta;

}
