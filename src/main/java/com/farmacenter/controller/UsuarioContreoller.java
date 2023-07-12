package com.farmacenter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farmacenter.modelo.Usuario;
import com.farmacenter.serviceImplement.UsuarioService;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST})
public class UsuarioContreoller {
	private UsuarioService iUsuarioService;

	public UsuarioContreoller(UsuarioService iUsuarioService) {
		this.iUsuarioService = iUsuarioService;
	}

	@PostMapping("/registro")
	 public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
		 Usuario nuevoUsuario = iUsuarioService.registrarUsuario(usuario);
	     return ResponseEntity.ok(nuevoUsuario);
	 }

	 @PostMapping("/inicio-sesion")
	 public ResponseEntity<Usuario> iniciarSesion(@RequestBody Usuario usuario) {
		 Usuario dbUsuario = iUsuarioService.iniciarSesion(usuario.getCorreo(), usuario.getContrasenia());
	     // Aquí puedes generar y devolver un token de autenticación si lo deseas
	     return ResponseEntity.ok(dbUsuario);
	 }
}
