package br.com.contas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class MeioPagamento implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	private String tipo;
	
	@JsonBackReference(value = "ref_cartao")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "cartao_credito_id")
	private CartaoCredito cartao;	
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_bancaria_id")
	private ContaBancaria conta;

	@Override
	public String toString() {
		return "MeioPagamento [id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + ", cartao=" + cartao
				+ ", conta=" + conta + "]";
	}

}
