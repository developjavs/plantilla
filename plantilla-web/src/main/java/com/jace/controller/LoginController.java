package com.jace.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.develop.model.Usuario;
import com.jace.service.UsuarioService;
import com.jace.utils.CommonUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@ManagedBean(name = "login")
@ViewScoped
@Log4j2
public class LoginController extends SpringBeanAutowiringSupport {

	/* .............................................................. GLOBAL VARIABLES SCHEME - INI */
	@Getter @Setter private String user/*                  LoginForm |      usuario */ = "";
	@Getter @Setter private String pass/*                  LoginForm |     Password */ = "";
	/* .............................................................. GLOBAL VARIABLES SCHEME - FIN */

	@Autowired
	private UsuarioService service;

	@PostConstruct
	public void init(){
		log.info("ENTRA CONSTRUCTOR");
	}

	public void login(){
		Map<String, Object> filters = new HashMap<>();
		filters.put("correo", this.user);
		filters.put("password", this.pass);
		Optional<Usuario> usuario = this.service.findByCriteria(filters);
		if(usuario.isPresent())
			CommonUtils.showMessage("INFO", "EXITOSO", "Bienvenido al home");
		else
			CommonUtils.showMessage("ERROR", "¡UPS!", "Ocurrio un problema ingresar al portal");
	}
}