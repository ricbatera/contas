package br.com.contas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contas.dto.CartaoCreditoDTO;
import br.com.contas.dto.MeioPagamentoDTO;
import br.com.contas.mapper.CartaoCreditoMapper;
import br.com.contas.mapper.MeioPagamentoMapper;
import br.com.contas.model.CartaoCredito;
import br.com.contas.model.ContaBancaria;
import br.com.contas.model.MeioPagamento;
import br.com.contas.repository.CartaoCreditoRepository;
import br.com.contas.repository.ContaBancariaRepository;
import br.com.contas.repository.MeioPagamentoRepository;
import br.com.contas.request.MeioPagamentoRequest;

@Service
public class MeioPagamentoService {
	@Autowired
	private MeioPagamentoMapper mapper;
	
	@Autowired
	private CartaoCreditoMapper mapperCartaocredito;

	@Autowired
	private MeioPagamentoRepository meioPgtoRepo;

	@Autowired
	private ContaBancariaRepository contaRepo;

	@Autowired
	private CartaoCreditoRepository cartaoRepo;

	public void salvar(MeioPagamentoRequest meioPagamentoRequest) {
		MeioPagamento meioPagamento = mapper.dtoRequestToModel(meioPagamentoRequest);
		ContaBancaria conta = verificaConta(meioPagamento.getConta());
		CartaoCredito cartao = verificaCartao(meioPagamento.getCartao());

		meioPagamento.setConta(conta);
		meioPagamento.setCartao(cartao);
		meioPagamento = meioPgtoRepo.save(meioPagamento);
	}

	public ContaBancaria verificaConta(ContaBancaria conta) {
		if (conta.getConta() != null) {
			ContaBancaria verificaContaExiste = contaRepo.buscaPorConta(conta.getConta());
			if (verificaContaExiste != null) {
				return verificaContaExiste;
			}
			return contaRepo.save(conta); // se não encontrar a conta, cadastra uma nova e retorna
		}
		return null;// se não achar numero de conta retorna null
	}

	public CartaoCredito verificaCartao(CartaoCredito cartao) {
		if (cartao.getNumeroCartao() != null) {
			CartaoCredito verificaCartaoEcxiste = cartaoRepo.buscaPorCartao(cartao.getNumeroCartao());
			if (verificaCartaoEcxiste != null) {
				return verificaCartaoEcxiste;
			}
			return cartaoRepo.save(cartao); // se não encontar cartão, salva um novo e retorna
		}
		return null; // se não achar numero de cartão retorna null
	}

	public List<MeioPagamentoDTO> listar() {

		return meioPgtoRepo.findAll().stream().map(resp -> mapper.modelToDto(resp)).collect(Collectors.toList());
	}

//	public List<CartaoVencimentos> buscaVencimentosCartoes() {
//		return meioPgtoRepo.buscarVencCartao();
//	}
	
	public List<CartaoCreditoDTO> buscaVencimentosCartoes() {
		List<CartaoCreditoDTO> retorno = cartaoRepo.findAll()
				.stream()
				.map(cartao -> mapperCartaocredito.modelToDto(cartao))
				.collect(Collectors.toList());
//		List <String[]> retorno2 = retorno.stream()
//		.map(cartao -> cartao.split(","))
//		.collect(Collectors.toList());		
		return retorno;
	}

}
