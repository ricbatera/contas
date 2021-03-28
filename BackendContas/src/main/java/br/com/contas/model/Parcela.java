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
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Entity
@Data
public class Parcela implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valorUnit;
	private Integer parcelaNumero;
	private String situacao = "Aberta";
	@DateTimeFormat
	private LocalDate dataVenvimento;
	
	@JsonBackReference
	//@JsonBackReference(value = "ref_parcela")//
	@OneToOne
	//@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "saida_id", nullable = true)
	//@JoinColumn(name= "saida_id")
	private Saida saida;

}
