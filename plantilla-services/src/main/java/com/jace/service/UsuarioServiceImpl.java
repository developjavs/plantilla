package com.jace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.model.Usuario;
import com.jace.repository.CommonRepository;
import com.jace.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, Long> implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(CommonRepository<Usuario, Long> repository) {
		super(repository);
	}

}