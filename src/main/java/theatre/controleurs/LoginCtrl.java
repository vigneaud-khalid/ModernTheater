package theatre.controleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import theatre.http.LoginEntrant;
import theatre.http.LoginSortant;
import theatre.service.MembreService;

@RestController
@CrossOrigin("*")
public class LoginCtrl {
	
	@Autowired
	private MembreService membreService;
	
	@PostMapping("/connexion") 
	public ResponseEntity<LoginSortant> login(@RequestBody LoginEntrant info){ 
		
		try {
			System.out.println(">>>>>> login info:" +info);
			LoginSortant loginSortant = membreService.login(info.getMail(), info.getPassword()); 
			return ResponseEntity.ok(loginSortant);
		}catch
		 (Exception e){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage()); 
		} 
		
		}  
	

}
