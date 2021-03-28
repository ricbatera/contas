package br.com.contas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.contas.dto.CartaoCreditoDTO;
import br.com.contas.model.CartaoCredito;

@Component
public class CartaoCreditoMapper {
	@Autowired
    private ModelMapper modelMapper;
	
	public CartaoCreditoDTO modelToDto(CartaoCredito cartao) {
        return modelMapper.map(cartao, CartaoCreditoDTO.class);
    }
	
	
}
