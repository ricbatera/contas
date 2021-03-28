package br.com.contas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Saida implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String descricao;
	@DateTimeFormat
	private LocalDate dataCompra;
	private Boolean parcelada;
	private Double valorTotal;
	@Transient
	private LocalDate dataVencimento;
	
	@JsonManagedReference
	//@JsonManagedReference(value = "ref_parcela") // aqui
	@OneToMany(cascade = CascadeType.ALL)
	//@OneToMany(mappedBy = "saida") // aqui
	private List<Parcela>parcelas;

}
