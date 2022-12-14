package br.edu.ifrn.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifrn.crud.dominio.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("select u from Usuario u where u.matricula like %:matricula% " +
			"and u.nome like %:nome% ")
	List<Usuario> findByMatriculaAndNome(@Param("matricula")String matricula,
							@Param("nome") String nome);
	
	@Query("select u from Usuario u where u.matricula like %:matricula% ")
	Optional<Usuario> findByMatricula(@Param("matricula")String matricula);
}
