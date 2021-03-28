package br.com.contas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contas.model.Saida;

public interface SaidaRepository extends JpaRepository<Saida, Long>{
	
}
