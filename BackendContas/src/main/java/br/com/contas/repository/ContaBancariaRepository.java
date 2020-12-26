package br.com.contas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.contas.model.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long>{
	
	@Query(value = "SELECT * FROM conta_bancaria WHERE conta = ?1", nativeQuery = true)
	public ContaBancaria buscaPorConta(String conta);

}
