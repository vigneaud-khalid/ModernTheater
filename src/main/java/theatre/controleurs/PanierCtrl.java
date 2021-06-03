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

import theatre.http.BilletSortant;
import theatre.model.Billet;
import theatre.model.Billet;
import theatre.model.Membre;
import theatre.model.Note;
import theatre.model.Role;
import theatre.service.AccessSecurityService;
import theatre.service.PanierService;

@RestController
@CrossOrigin("*")
public class PanierCtrl {

	@Autowired
	private PanierService panierService;
	
	
	@Autowired
	private AccessSecurityService accessSecurityService;


	/*
	@PostMapping("/commander")
	public ResponseEntity<Billet> commander(HttpServletRequest request, @RequestBody List<HashMap<String, String>> panier) {

		System.out.println("-------" + panier);
		System.out.println("--CommandeCtrl: " );
		
		Membre membre = accessSecurityService.findUserByToken(request);
		boolean accessAdmin = accessSecurityService.verifierRole(request, Role.ADMIN);
		boolean accessUser = accessSecurityService.verifierRole(request, Role.USER);
		
		if (membre != null) {
			if (accessUser || accessAdmin) {

				Billet cmd =  panierService.creerCommande(panier, membre);	
				return ResponseEntity.ok(cmd);

			}
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "accès refusé");
		}

		throw new ResponseStatusException(HttpStatus.FOUND, "membre introuvable !");
		}
*/
	
	@PostMapping("/commander")
	public ResponseEntity<List<BilletSortant>> commander(HttpServletRequest request, @RequestBody List<HashMap<String, String>> panier) {

		System.out.println("-------" + panier);
		System.out.println("--CommandeCtrl: " );
		
		Membre membre = accessSecurityService.findUserByToken(request);
		boolean accessAdmin = accessSecurityService.verifierRole(request, Role.ADMIN);
		boolean accessUser = accessSecurityService.verifierRole(request, Role.USER);
		
		if (membre != null) {
			if (accessUser || accessAdmin) {

				List<BilletSortant> cmdSortant =  panierService.creerCommande(panier, membre);
				System.out.println(cmdSortant);
				return ResponseEntity.ok(cmdSortant);
				

			}
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "accès refusé");
		}

		throw new ResponseStatusException(HttpStatus.FOUND, "membre introuvable !");
		}

}





