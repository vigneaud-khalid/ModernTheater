package theatre.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import theatre.http.NoteEntrant;
import theatre.model.Membre;
import theatre.model.Note;
import theatre.model.Piece;
import theatre.repository.MembreRepository;
import theatre.repository.NoteRepository;
import theatre.repository.PieceRepository;

@Service
public class NoteService {
	@Autowired
	private MembreRepository membreRepository;
	
	@Autowired
	private PieceRepository pieceRepository;
	
	@Autowired
	private NoteRepository noteRepository;
	
	
	public Note appliquerNote(int valeur, int pieceId, Membre membre) {
		
		Optional<Piece> optionPiece = pieceRepository.findById(pieceId);
		
			Note note = new Note();
			Date d = new Date();
			note.setDate(d);
			note.setValeur(valeur);
			note.setMembre(membre);
			note.setPiece(optionPiece.get());
			
			noteRepository.save(note);
			String reponse = "Merci pour votre retour!";
			return note;
		}
	
	
	public float moyenneNote(int pieceId) {
		float moyenneNote = noteRepository.calculerMoyenne(pieceId);
		return moyenneNote;
	}
}
	


