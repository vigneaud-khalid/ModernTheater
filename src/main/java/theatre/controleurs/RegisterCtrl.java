package theatre.controleurs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import theatre.http.RegisterEntrant;
import theatre.model.Membre;
import theatre.model.Role;
import theatre.service.AccessSecurityService;
import theatre.service.MembreService;

/**
 * author : kh
 * date : 09/04/2021
 */

@RestController
@CrossOrigin("*")
public class RegisterCtrl {

	@Autowired
	private MembreService membreService;
	
	@Autowired
	private AccessSecurityService accessSecurityService;

	@PostMapping("/register")
	public ResponseEntity<Membre> creerNouveauUtilisateur(@RequestBody RegisterEntrant info) {
		System.out.println(info);
		try {
			Membre newMembre = membreService.creerMembre(info.getNom(), info.getPrenom(), info.getDateNaiss(), info.getRue(), info.getCp(),info.getVille(),info.getTel(), info.getMail(),
					info.getMdp(), info.getMdp2());
			return ResponseEntity.ok(newMembre);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}
	
	@PutMapping("/membre/{id}")
	public ResponseEntity<Membre> modifierUserEnAdmin(HttpServletRequest request, @PathVariable ("id") int idMembre) {
		
		boolean adminAccess = accessSecurityService.verifierRole(request, Role.ADMIN);
		
		if(adminAccess) {
		try {
			
			 
			Membre membre = membreService.modifierUserEnAdmin(idMembre);
			return ResponseEntity.ok(membre);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "accès refusé");
	}
	
	
}