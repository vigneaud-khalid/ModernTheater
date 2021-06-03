package theatre.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import theatre.model.Acteur;
import theatre.model.Distribution;

public interface DistributionRepository extends JpaRepository<Distribution, Integer> {
	
	//@Query("select a from Acteur a join a.distribution d where d.piece.id = :idPiece ")
	
	//@Query("select d.acteurs from Distribution d where d.piece.id = :idPiece ")
	
	@Query("select d from Distribution d where d.piece.id= :idPiece")
	public List<Distribution> rolesParPiece(int idPiece);
 
}
 