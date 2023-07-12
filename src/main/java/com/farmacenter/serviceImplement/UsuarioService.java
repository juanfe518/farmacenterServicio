package com.farmacenter.serviceImplement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacenter.modelo.Usuario;
import com.farmacenter.repository.IUsuarioRepository;
import com.farmacenter.springbootnewsecurity.exceptions.InvalidCredentialsException;
import com.farmacenter.springbootnewsecurity.exceptions.UserAlreadyExistsException;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	public UsuarioService(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }
	
	 public Usuario registrarUsuario(Usuario usuario) {
		 // Verificar si el correo ya está registrado
	     if (iUsuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
	    	 throw new UserAlreadyExistsException("El correo ya está registrado");
	    	 //throw new RuntimeException("El correo ya está registrado");
	 }
	        // Guardar el nuevo usuario en la base de datos
	        return iUsuarioRepository.save(usuario);
	 }

	 public Usuario iniciarSesion(String correo, String contrasenia) {
	        // Verificar las credenciales del usuario
	        Optional<Usuario> optionalUsuario = iUsuarioRepository.findByCorreo(correo);
	       // System.out.println(correo);
	        if (optionalUsuario.isEmpty() || !(optionalUsuario.get().getContrasenia().equals(contrasenia))) {
	            throw new InvalidCredentialsException("False");
	        	//throw new RuntimeException("Credenciales de inicio de sesión inválidas");
	 }
	        return optionalUsuario.get();
	 }
}
