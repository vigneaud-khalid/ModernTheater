package theatre.repository;


import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import theatre.model.Avis;

import theatre.model.Acteur;

import theatre.model.Piece;

public interface PieceRepository extends JpaRepository<Piece, Integer> {
	
	@Query("select p from Piece p where p.id = :idPiece")
	public Optional<Piece> chercherPieceParId(int idPiece); 


	@Query("SELECT c.pieces FROM Categorie c WHERE c.nom = :paramName ")
	public List<Piece> chercherPiecesParCategorie(String paramName);
	
	
	@Query("SELECT p.avis FROM Piece p WHERE p.id = :paramId ")
	public List<Avis> chercherAvisSelonPiece(int paramId);

	
	@Query("SELECT p FROM Piece p JOIN p.notes n GROUP BY p HAVING AVG(n) >= :paramNote ") 
	public List<Piece> chercherPiecesParNote(int paramNote);
	 
	
}
