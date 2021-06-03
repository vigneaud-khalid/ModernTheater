package theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import theatre.model.Avis;

/**
 * author : kh
 * date : 09/04/2021
 */

public interface AvisRepository  extends JpaRepository<Avis, Integer> {
	
	// @Query("DELETE a from Avis a  where a.id= :pieceId")
	// public float deleteAvis(int pieceId);
	
}