package com.orangetalents.desafio.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.orangetalents.desafio.domain.Endereco;
import com.orangetalents.desafio.dto.EnderecoDTO;
import com.orangetalents.desafio.services.EnderecoService;

@RestController
@RequestMapping(value = "/usuarios/{id}/enderecos")
public class EnderecoResource {
		@Autowired
		private EnderecoService service;

			@RequestMapping(method = RequestMethod.POST)
			public ResponseEntity<Void> insert( @PathVariable Integer id, @RequestBody EnderecoDTO obj) {
				obj.setUsuarioId(id);
				Endereco end = service.fromDTO(obj);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(end.getId()).toUri();
				return ResponseEntity.created(uri).build();
			}
}