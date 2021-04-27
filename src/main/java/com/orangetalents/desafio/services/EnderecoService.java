package com.orangetalents.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangetalents.desafio.domain.Endereco;
import com.orangetalents.desafio.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository endRepo;
	
	@Autowired UsuarioService user;
	
	public Endereco insert(Endereco obj) {
		obj.setId(null);		
		obj = endRepo.save(obj);
		obj.getUsuario().getEnderecos().add(obj);
		user.update(obj.getUsuario());
		return obj;
	}
}
