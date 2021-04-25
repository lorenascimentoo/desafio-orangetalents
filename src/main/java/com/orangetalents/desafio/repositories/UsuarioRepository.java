package com.orangetalents.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents.desafio.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
