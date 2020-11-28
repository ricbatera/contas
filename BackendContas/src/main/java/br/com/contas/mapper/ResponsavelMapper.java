package br.com.contas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.contas.dto.ResponsavelDTO;
import br.com.contas.model.Responsavel;
import br.com.contas.request.ResponsavelRequest;

@Component
public class ResponsavelMapper {

	@Autowired
    private ModelMapper modelMapper;
	
	public ResponsavelDTO modelToDto(Responsavel usuario) {
        return modelMapper.map(usuario, ResponsavelDTO.class);
    }

    public Responsavel dtoRequestToModel(ResponsavelRequest request) {
        return modelMapper.map(request, Responsavel.class);
    }
}
