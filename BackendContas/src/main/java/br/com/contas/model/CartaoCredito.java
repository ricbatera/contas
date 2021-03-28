package br.com.contas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class CartaoCredito implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCartao;
	private String numeroCartao;
	@DateTimeFormat
	private LocalDate validade;
	private Integer diaVencimento;
	
	//@JsonBackReference(value = "ref_cartao")
	@JsonManagedReference(value = "ref_cartao")
	@OneToMany(mappedBy = "cartao")
	private List<MeioPagamento> meiosPagamentos = new ArrayList<>();

	@Override
	public String toString() {
		return "CartaoCredito [id=" + id + ", nomeCartao=" + nomeCartao + ", numeroCartao=" + numeroCartao
				+ ", validade=" + validade + ", diaVencimento=" + diaVencimento + "]";
	}
	
	

}
