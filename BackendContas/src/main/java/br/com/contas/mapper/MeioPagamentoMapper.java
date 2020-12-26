package br.com.contas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.contas.dto.MeioPagamentoDTO;
import br.com.contas.model.MeioPagamento;
import br.com.contas.request.MeioPagamentoRequest;

@Component
public class MeioPagamentoMapper {
	@Autowired
    private ModelMapper modelMapper;
	
	public MeioPagamentoDTO modelToDto(MeioPagamento meio) {
        return modelMapper.map(meio, MeioPagamentoDTO.class);
    }

    public MeioPagamento dtoRequestToModel(MeioPagamentoRequest request) {
        return modelMapper.map(request, MeioPagamento.class);
    }
}
