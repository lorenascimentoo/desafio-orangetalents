package com.orangetalents.desafio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangetalents.desafio.domain.Cidade;
import com.orangetalents.desafio.domain.Endereco;
import com.orangetalents.desafio.domain.Usuario;
import com.orangetalents.desafio.dto.UsuarioDTO;
import com.orangetalents.desafio.repositories.EnderecoRepository;
import com.orangetalents.desafio.repositories.UsuarioRepository;
import com.orangetalents.desafio.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private EnderecoRepository endRepo;
	
	@Autowired
	private CidadeService cid;
	
	public Usuario find(Integer id) throws ObjectNotFoundException {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
			obj.setId(null);
			obj = repo.save(obj);
			endRepo.saveAll(obj.getEnderecos());
			return obj;
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	public Usuario fromDTO(UsuarioDTO obj){
			Cidade cidade = cid.find(obj.getCidadeId()); 
			Usuario usuario = new Usuario(null, obj.getNome(), obj.getEmail(), obj.getCpf(), obj.getDtnasc());
			Endereco end = new Endereco(null, obj.getLogradouro(), obj.getNumero(), obj.getComplemento(), obj.getBairro(), cidade, obj.getCep(), usuario);
			usuario.getEnderecos().add(end);
			repo.save(usuario);
			endRepo.save(end);
			return usuario;
	}
	
	
}