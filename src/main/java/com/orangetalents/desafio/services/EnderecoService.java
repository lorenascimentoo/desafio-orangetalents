package com.orangetalents.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangetalents.desafio.domain.Cidade;
import com.orangetalents.desafio.domain.Endereco;
import com.orangetalents.desafio.domain.Usuario;
import com.orangetalents.desafio.dto.EnderecoDTO;
import com.orangetalents.desafio.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository endRepo;
	@Autowired
	private CidadeService cid;
	@Autowired
	UsuarioService user;
	
	public Endereco insert(Endereco obj) {
		obj.setId(null);		
		obj = endRepo.save(obj);
		obj.getUsuario().getEnderecos().add(obj);
		user.update(obj.getUsuario());
		return obj;
	}
	
	public Endereco fromDTO(EnderecoDTO obj) {
		Cidade cidade = cid.find(obj.getCidadeId());
		System.out.println(cidade);
		Usuario usuario = user.find(obj.getUsuarioId());
		System.out.println(usuario);
		Endereco end = new Endereco(null, obj.getLogradouro(), obj.getNumero(), obj.getComplemento(), obj.getBairro(), cidade, obj.getCep(), usuario);
		System.out.println(end);
		usuario.getEnderecos().add(end);
		user.update(usuario);
		return end;
	}
}
