package theatre.controleurs;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import theatre.model.Avis;
import theatre.model.Piece;
import theatre.model.Role;
import theatre.service.AccessSecurityService;
import theatre.service.PieceService;

@RestController
@CrossOrigin("*")
public class PieceCtrl {

	@Autowired
	private PieceService pieceService;

	private AccessSecurityService accessSecurityService;

	@GetMapping("/catalogue")
	public ResponseEntity<List<Piece>> getAllPieces() {
		List<Piece> pieces = pieceService.getAllPieces();
		return ResponseEntity.ok(pieces);
	}

	@GetMapping("/pieces/{categorie}")
	public ResponseEntity<List<Piece>> getPlaysByCategory(HttpServletRequest request,
			@PathVariable("categorie") String category) {
		List<Piece> pieces = pieceService.getPlaysByCategory(category);
		return ResponseEntity.ok(pieces);
	}

	// toutes les pièces dont les notes sont =... ... >=
	@GetMapping("/pieces/{note}")
	public ResponseEntity<List<Piece>> getPlaysByNote(HttpServletRequest request, @PathVariable("note") int note) {
		List<Piece> pieces = pieceService.getPlaysByNote(note);
		return ResponseEntity.ok(pieces);
	}

	// tous les avis sur une pièce
	@GetMapping("/avispieces/{id}")
	public ResponseEntity<List<Avis>> getReviewsOnPlay(HttpServletRequest request, @PathVariable("id") int id) {
		List<Avis> avis = pieceService.getReviewsOnPlay(id);
		return ResponseEntity.ok(avis);
	}

	
	@GetMapping("/piece/{id}")
	public ResponseEntity<Piece> getPlayById(HttpServletRequest request, @PathVariable("id") int id) throws Exception {
		Piece piece = pieceService.getPlayById(id);
		return ResponseEntity.ok(piece);
	}

	@PutMapping("/piece/{id}")
	public ResponseEntity<Piece> modifierPiece(HttpServletRequest request, @PathVariable("id") int idPiece,
			@RequestBody Piece piece) {

		boolean accessAdmin = accessSecurityService.verifierRole(request, Role.ADMIN);

		if (accessAdmin) {

			try {
				Piece piece2 = pieceService.modifierPiece(idPiece, piece.getPhoto(), piece.getDuree(),
						piece.getDebutRep(), piece.getFinRep());

				return ResponseEntity.ok(piece2);
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			}

		}
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "accès refusé");

	}

}
