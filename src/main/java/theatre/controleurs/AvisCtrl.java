package theatre.controleurs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import theatre.http.AvisEntrant;
import theatre.model.Avis;
import theatre.model.Membre;
import theatre.model.Piece;
import theatre.model.Role;
import theatre.service.AccessSecurityService;
import theatre.service.AvisService;

/**
 * author : kh date : 09/04/2021
 */

@RestController
@CrossOrigin("*")
public class AvisCtrl {

	@Autowired
	private AvisService avisService;

	@Autowired
	private AccessSecurityService accessSecurityService;

	@PostMapping("/avis")
	public ResponseEntity<Avis> appliquerAvis(HttpServletRequest request, @RequestBody AvisEntrant avisEntrant) {
		System.out.println("avisEntrant : " + avisEntrant);
		// recuperation d'un membre via le token
		Membre membre = accessSecurityService.findUserByToken(request);
		boolean accessAdmin = accessSecurityService.verifierRole(request, Role.ADMIN);
		boolean accessUser = accessSecurityService.verifierRole(request, Role.USER);
		if (membre != null) {
			if (true)    //(accessUser || accessAdmin) 
			{
				try {
					Avis avis = avisService.giveReview(avisEntrant.getValeur(), avisEntrant.getPieceId(), membre);
					System.out.println("avis: " + avis);
					return ResponseEntity.ok(avis);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Access denied !");
		}
		throw new ResponseStatusException(HttpStatus.FOUND, "You need to be registered to post reviews !");
	}

	/*
	 * @DeleteMapping("/deleteavis/{id}") public void effacerAvis(HttpServletRequest
	 * request, @PathVariable("id") int idAvis) { // quoi comme paramètre au dessus
	 * ??????????????? boolean accessAdmin =
	 * accessSecurityService.verifierRole(request, Role.ADMIN); if (accessAdmin) {
	 * try { avisService.effacerAvis(idAvis); // return ResponseEntity.ok(); } catch
	 * (Exception e) { throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
	 * e.getMessage()); } } throw new
	 * ResponseStatusException(HttpStatus.UNAUTHORIZED, "accès refusé"); }
	 */
}