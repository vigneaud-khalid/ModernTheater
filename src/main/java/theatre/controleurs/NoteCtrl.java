package theatre.controleurs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import theatre.http.NoteEntrant;
import theatre.model.Membre;
import theatre.model.Note;
import theatre.model.Role;
import theatre.service.AccessSecurityService;
import theatre.service.NoteService;

@RestController
@CrossOrigin("*")
public class NoteCtrl { 
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private AccessSecurityService accessSecurityService;
	
	@PostMapping("/note")
	public ResponseEntity<Note> appliquerNote(HttpServletRequest request, @RequestBody NoteEntrant noteEntrant) {
		System.out.println("noteEntrant : " + noteEntrant);
		
		//recuperer le membre via le token 
		Membre membre = accessSecurityService.findUserByToken(request);
		
		boolean accessAdmin = accessSecurityService.verifierRole(request, Role.ADMIN);
		boolean accessUser = accessSecurityService.verifierRole(request, Role.USER);
		
	
		if (membre != null) {
			if (accessUser || accessAdmin) {

				Note note = noteService.appliquerNote( noteEntrant.getValeur(), noteEntrant.getPieceId(), membre);
		System.out.println("note: "+note);
		return ResponseEntity.ok(note);	

			}
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "accès refusé");
		}

		throw new ResponseStatusException(HttpStatus.FOUND, "membre introuvable !");
	}
		
		
		
	
	
	@GetMapping("moyenneNote/piece/{id}")
	public float moyenneNote(@PathVariable("id") int idPiece) {
				
		float moyenne = noteService.moyenneNote(idPiece);
		System.out.println("moyenneNote: "+moyenne); 
		return moyenne;	
		
		
	}

}
