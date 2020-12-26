package br.com.contas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contas.model.MeioPagamento;

public interface MeioPagamentoRepository extends JpaRepository<MeioPagamento, Long> {

}
