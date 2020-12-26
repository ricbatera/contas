package br.com.contas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.contas.model.CartaoCredito;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long>{
	@Query(value = "SELECT * FROM cartao_credito WHERE numero_cartao = ?1", nativeQuery = true)
	public CartaoCredito buscaPorCartao(String cartao);
}
