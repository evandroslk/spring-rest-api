package br.com.evandroslk.springrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.evandroslk.springrestapi.entities.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
