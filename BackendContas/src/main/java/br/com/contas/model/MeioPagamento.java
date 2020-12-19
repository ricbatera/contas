package br.com.contas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MeioPagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "cartao_credito_id", nullable = true)
	private CartaoCredito cartao;
	
	@ManyToOne
	@JoinColumn(name = "conta_bancaria_id", nullable = true)
	private ContaBancaria conta;

}
