package br.com.evandroslk.springrestapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.evandroslk.springrestapi.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@EntityGraph(
			type = EntityGraphType.FETCH,
			attributePaths = {
					"telefones"
			})
	List<Usuario> findAll();

}
