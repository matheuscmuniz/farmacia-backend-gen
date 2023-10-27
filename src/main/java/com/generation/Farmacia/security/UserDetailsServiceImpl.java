package com.generation.Farmacia.security;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.Farmacia.model.Usuario;
import com.generation.Farmacia.repository.UsuarioRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String useName) throws UsernameNotFoundException{
		Optional<Usuario>usuario=usuarioRepository.findByUsuario(useName);
		
		if (usuario.isPresent())
			return new UserDetailsImpl(usuario.get());
		
		else 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}

	
}