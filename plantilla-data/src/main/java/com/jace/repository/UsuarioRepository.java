package com.jace.repository;

import org.springframework.stereotype.Repository;

import com.develop.model.Usuario;

@Repository
public interface UsuarioRepository extends CommonRepository<Usuario, Long> {

}
