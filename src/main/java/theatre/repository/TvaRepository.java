package theatre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import theatre.model.TVA;

public interface TvaRepository extends JpaRepository<TVA, Integer>{
	
	@Query("select t from TVA t where t.nom = :tvaNom")
	public Optional<TVA> findRoleByNom(String tvaNom);

}
