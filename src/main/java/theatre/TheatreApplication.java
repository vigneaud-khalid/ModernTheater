package theatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import theatre.model.Role;
import theatre.model.Membre;
import theatre.repository.MembreRepository;
import theatre.repository.RoleRepository;
import theatre.service.PasswordEncoderService;

@SpringBootApplication
public class TheatreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreApplication.class, args);
	}
 

	//@Autowired
	//private BilletRepository billetRepository;
/*	@Autowired
	private MembreRepository membreRepository;
	@Autowired
	private PasswordEncoderService passwordEncoderService;
	@Autowired
	private RoleRepository roleRepository;
	@Bean
	CommandLineRunner run() {
		return args -> {
			
			
			String mdp = "12345678";
			String encodedMpd = passwordEncoderService.encoder(mdp);
			
			//Membre user01 = new Membre("Thibault","Pierre","pierre@gmx.fr", encodedMpd); 
			
			//membreRepository.save(user01);

			Role user = new Role(Role.USER);
			roleRepository.save(user);
			
Membre user02 = new Membre("Fred","Lombard","fred@gmx.fr", encodedMpd); 

user02.setRole(user);




			
			membreRepository.save(user02);
			
  
//			Billet billet = new Billet();
//			Billet billet2 = new Billet();
//			
//			
//			billetRepository.save(billet);
//			billetRepository.save(billet2);
			
		};
	}
	
	*/
	
}
