package br.edu.ifrn.crud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifrn.crud.dominio.Usuario;
import br.edu.ifrn.crud.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = repository.findByMatricula(username)
				.orElseThrow(() ->
				new UsernameNotFoundException("Usuario não encontrado"));
		
		 return new User(
				usuario.getEmail(),
				usuario.getSenha(),
				new ArrayList<>()
				//AuthorityUtils.createAuthorityList(aluno.getPerfil())
				);
	}

}
