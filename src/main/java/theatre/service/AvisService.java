package theatre.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import theatre.model.Avis;
import theatre.model.Membre;
import theatre.model.Piece;
import theatre.repository.AvisRepository;
import theatre.repository.MembreRepository;
import theatre.repository.PieceRepository;

/**
 * author : kh
 * date : 09/04/2021
 */

@Service
public class AvisService {
	@Autowired
	private MembreRepository membreRepository;
	
	@Autowired
	private PieceRepository pieceRepository;
	
	@Autowired
	private AvisRepository avisRepository;
	
	
public Avis giveReview(String texte, int pieceId, Membre membre) throws Exception {
		
		Optional<Piece> optionPiece = pieceRepository.findById(pieceId);
		Exception ex = new Exception("This play is not available for a review !!!");  
		if (optionPiece.isPresent()) {
			Avis avis = new Avis();
			Date d = new Date();
			avis.setDate(d);
			avis.setValeur(texte);
			avis.setMembre(membre);
			avis.setPiece(optionPiece.get());
			avisRepository.save(avis);
			String reponse = "Thank you for your review !";    // non retourné
			return avis;
		}else {	throw ex; }
	}

	/*
	 * public void effacerAvis(int idAvis) throws Exception {
	 * 
	 * Optional<Piece> optionPiece = pieceRepository.findById(idAvis); Exception ex
	 * = new
	 * Exception("This play is not available for deletion of this review !!!"); if
	 * (optionPiece.isPresent()) { avisRepository.deleteAvis(idAvis); String reponse
	 * = "Review deleted !"; // non retourné }else { throw ex; } }
	 */
}