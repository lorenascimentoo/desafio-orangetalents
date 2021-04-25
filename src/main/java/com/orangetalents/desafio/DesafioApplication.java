package com.orangetalents.desafio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orangetalents.desafio.domain.Cidade;
import com.orangetalents.desafio.domain.Endereco;
import com.orangetalents.desafio.domain.Estado;
import com.orangetalents.desafio.domain.Usuario;
import com.orangetalents.desafio.repositories.CidadeRepository;
import com.orangetalents.desafio.repositories.EnderecoRepository;
import com.orangetalents.desafio.repositories.EstadoRepository;
import com.orangetalents.desafio.repositories.UsuarioRepository;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner{
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception{
		Estado est1 = new Estado(null, "Pará");
		Estado est2 = new Estado(null, "São Paulo"); 
		
		Cidade cid1 = new Cidade(null, "Ananindeua", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Belém", est1);
		
		est1.getCidades().addAll(Arrays.asList(cid1,cid3));
		est2.getCidades().addAll(Arrays.asList(cid2));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		Usuario user1 = new Usuario(null, "Maria Silva", "maria@gmail.com", "33365498732", "05/06/1981");
		Usuario user2 = new Usuario(null, "Joaquim Silva", "joaquim@gmail.com", "05796325814", "10/10/2000");
		
		Endereco end1 = new Endereco(null, "Rua 2 de Junho", "2020", "", "Águas Brancas", cid1, "67033000", user1);
		Endereco end2 = new Endereco(null, "Tv. Perimetral", "5", "", "Guamá", cid3, "66045698", user2);
		
		user1.getEnderecos().addAll(Arrays.asList(end1));
		user2.getEnderecos().addAll(Arrays.asList(end2));
		
		usuarioRepository.saveAll(Arrays.asList(user1,user2));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
	}
}
