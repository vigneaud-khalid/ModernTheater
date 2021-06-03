package theatre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import theatre.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {
	
	@Query("select AVG(n.valeur) from Note n  where n.piece.id= :pieceId")
	public float calculerMoyenne(int pieceId); 
	
	

}
