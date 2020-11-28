package br.com.contas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contas.dto.ResponsavelDTO;
import br.com.contas.mapper.ResponsavelMapper;
import br.com.contas.model.Responsavel;
import br.com.contas.repository.ResponsavelRepository;
import br.com.contas.request.ResponsavelRequest;

@Service
public class ResponsavelService {

	@Autowired
	private ResponsavelMapper mapper;
	@Autowired
	private ResponsavelRepository repository;

	public ResponsavelDTO salvar(ResponsavelRequest responsavelRequest) {
		Responsavel responsavel = mapper.dtoRequestToModel(responsavelRequest);
		return mapper.modelToDto(repository.save(responsavel));
	}

	public List<ResponsavelDTO> listar() {

		return repository.findAll()
				.stream()
				.map(resp -> mapper.modelToDto(resp))
				.collect(Collectors.toList());
	}

}
