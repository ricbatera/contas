package br.com.contas.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class ContaBancaria implements Serializable {	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String agencia;
	private String conta;
	private String banco;
	
	//@JsonBackReference
	@JsonManagedReference
	@OneToMany(mappedBy = "conta")
	private List<MeioPagamento> meios = new ArrayList<>();

	@Override
	public String toString() {
		return "ContaBancaria [id=" + id + ", agencia=" + agencia + ", conta=" + conta + ", banco=" + banco + "]";
	}
	
	
}
