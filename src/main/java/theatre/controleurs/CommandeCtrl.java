package theatre.controleurs;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import theatre.model.Commande;
import theatre.model.Membre;
import theatre.service.AccessSecurityService;
import theatre.service.CommandeService;



@RestController
@CrossOrigin("*")
public class CommandeCtrl {

	
	@Autowired
	private AccessSecurityService accessSecurityService;
	
	@Autowired
	private CommandeService commandeService;
	
	@PostMapping("/commande")
	public ResponseEntity<Commande> Commander(HttpServletRequest request) {

		
		System.out.println("CommandeCtrl:"  );
		
		Membre membre = accessSecurityService.findUserByToken(request);
		
		System.out.println("membre: " +membre);
		
		if(membre != null) {
			//Commande cmd =  commandeService.validerCommande(commande.getDate(), membre);
			//System.out.println("-------" + cmd);
			return ResponseEntity.ok(null);
		}else {
			throw new ResponseStatusException(HttpStatus.FOUND, "membre introvable !");
		}
	}
}
