package com.orangetalents.desafio.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.orangetalents.desafio.domain.Usuario;
import com.orangetalents.desafio.dto.UsuarioDTO;
import com.orangetalents.desafio.services.UsuarioService;
import com.orangetalents.desafio.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	@Autowired
	private UsuarioService service;
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Usuario> find(@PathVariable Integer id) throws ObjectNotFoundException{
			Usuario obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO obj){
			Usuario user = service.fromDTO(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
}