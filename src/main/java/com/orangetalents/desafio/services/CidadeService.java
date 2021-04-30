package com.orangetalents.desafio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangetalents.desafio.domain.Cidade;
import com.orangetalents.desafio.domain.Usuario;
import com.orangetalents.desafio.repositories.CidadeRepository;
import com.orangetalents.desafio.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	public Cidade find(Integer id) throws ObjectNotFoundException {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo: " + Usuario.class.getName()));
	}

	
}
