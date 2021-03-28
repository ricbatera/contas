package br.com.contas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.contas.dto.SaidaDTO;
import br.com.contas.model.Saida;
import br.com.contas.request.SaidaRequest;

@Component
public class SaidaMapper {

	@Autowired
    private ModelMapper modelMapper;
	
	public SaidaDTO modelToDto(Saida saida) {
        return modelMapper.map(saida, SaidaDTO.class);
    }

    public Saida dtoRequestToModel(SaidaRequest request) {
        return modelMapper.map(request, Saida.class);
    }
}
