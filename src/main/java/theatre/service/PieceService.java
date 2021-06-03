package theatre.service;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import theatre.model.Avis;
import theatre.model.Membre;
import theatre.model.Piece;
import theatre.repository.PieceRepository;

@Service
public class PieceService {

	@Autowired
	private PieceRepository pieceRepository;

	public List<Piece> getAllPieces() {
		List<Piece> pieces = pieceRepository.findAll();
		return pieces;
	}

	public List<Piece> getPlaysByCategory(String name) {
		List<Piece> pieces = pieceRepository.chercherPiecesParCategorie(name);
		return pieces;
	}

	public List<Piece> getPlaysByNote(int note) {
		List<Piece> pieces = pieceRepository.chercherPiecesParNote(note);
		return pieces;
	}

	public List<Avis> getReviewsOnPlay(int id) {
		List<Avis> avis = pieceRepository.chercherAvisSelonPiece(id);
		return avis;
	}

	public Piece getPlayById(int id) throws Exception {
		Optional<Piece> optionPiece = pieceRepository.chercherPieceParId(id);
		if (optionPiece.isPresent()) {
			Piece piece = optionPiece.get();
			return piece;
		} else {
			throw new Exception("Not such a play");
		}
	}

	public Piece modifierPiece(int idPiece, String photo, int duree, Date debutRep, Date finRep) {
		Optional<Piece> pieceOption = pieceRepository.findById(idPiece);

		Piece piece = pieceOption.get();

		piece.setPhoto(photo);
		piece.setDuree(duree);
		piece.setDebutRep(debutRep);
		piece.setFinRep(finRep);

		pieceRepository.save(piece);

		return piece;
	}
}
