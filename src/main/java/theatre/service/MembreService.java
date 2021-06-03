package theatre.service;

import java.text.SimpleDateFormat;

/**
 * author : kh
 * date : 09/04/2021
 */

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import theatre.http.LoginSortant;
import theatre.model.Membre;
import theatre.model.Role;
import theatre.model.Token;
import theatre.outil.CustomedException;
import theatre.repository.MembreRepository;
import theatre.repository.RoleRepository;
import theatre.repository.TokenRepository;

@Service
public class MembreService {

	@Autowired
	private MembreRepository membreRepository;

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	PasswordEncoderService passwordEncoderService;

	public List<Membre> getAllUser() {
		return membreRepository.findAll();
	}

	public List<Membre> getUserByFirstName(String prenom) {
		return membreRepository.trouverMembreParPrenom(prenom);
	}

	public List<Membre> getUserByLastName(String nom) {
		return membreRepository.trouverMembreParNom(nom);
	} 

	public Membre changeUser(int id, String nom, String prenom, String mail, int roleId) throws Exception {

		// to do : controler les valeurs de chaque élément (conforme) et sécurisation
		Optional<Membre> optionUtili = membreRepository.findById(id);
		Optional<Role> optionRole = roleRepository.findById(roleId);
		if (optionUtili.isPresent() && optionRole.isPresent()) {
			Membre u = optionUtili.get();
			Role role = optionRole.get();
			u.setNom(nom);
			u.setPrenom(prenom);
			u.setMail(mail);
			u.setRole(role);
			membreRepository.save(u);
			return u;
		} else {
			throw new Exception("Failure :  incorrect data...");
		}
	}
	
	
public Membre modifierUserEnAdmin(int id) throws Exception {

		
		Optional<Membre> optionMembre = membreRepository.findById(id);
		Optional<Role> optionRole = roleRepository.findRoleByNom(Role.ADMIN);
		
		if (optionMembre.isPresent() && optionRole.isPresent()) {
			Membre membre = optionMembre.get();
			Role role = optionRole.get();
			
			
		
			membre.setRole(role);
			membreRepository.save(membre);
			return membre;
		} else {
			throw new Exception("Failure :  incorrect data...");
		}
	}
	
	
	public LoginSortant login(String mail, String password) throws Exception {

		Optional<Membre> option = membreRepository.chercherMembreParMail(mail);

		Exception ex = new Exception("You are mistaken on your email address or your password !!!");  
		if (option.isPresent()) {
			Membre user = option.get();
			boolean ok = passwordEncoderService.verifier(password, user.getMdp());
			if (ok) {
				Token token = genererToken();
				token.setMembre(user);
				tokenRepository.save(token);

				LoginSortant loginSortant = new LoginSortant();
				loginSortant.setNom(user.getNom());
				loginSortant.setPrenom(user.getPrenom());
				loginSortant.setMail(user.getMail());
				loginSortant.setRole(user.getRole().getNom());
				loginSortant.setToken(token.getValeur());
				return loginSortant;
			} else {
				throw ex;
			}
		} else {
			throw ex;
		}
	}
	
	private Token genererToken() {
		UUID uuid = UUID.randomUUID();
		String valueToken = uuid.toString();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 30);
		Date expiredDate = calendar.getTime();
		return new Token(valueToken, expiredDate);
	}

	public Membre creerMembre(String nom, String prenom, String dateNaiss, String rue, String cp, String ville, String tel, String mail,  String mdp, String mdp2)
			throws Exception {
		String msgErreur = "";
	//	HashMap<String, String> erreurs = new HashMap<>();
		//1) controle des données
		if (!mdp.equals(mdp2)) { 
			msgErreur += " Passwords do not match !";
		} else if (mdp.equals(mdp2) && mdp.length() < 10) {
			msgErreur += " 10 characters or more are required ...";
		}

		String regex = "[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*";

		if (!mail.matches(regex)) {	msgErreur += " Non-compliant email address ! ";}

		Optional<Membre> optionMembre = membreRepository.chercherMembreParMail(mail);
		
		if (optionMembre.isPresent()) {
			msgErreur += "This email address is used by a member...  Are you already registered ?";
			}
        
		if (msgErreur != "") { 
			Exception ex= new Exception(msgErreur);
			throw ex; }
			  

		Membre membre = new Membre();
		String mdpEncoded = passwordEncoderService.encoder(mdp);
		Date dateNaissance = new SimpleDateFormat("yyyy-MM-dd").parse(dateNaiss); 
		
		membre.setNom(nom);
		membre.setPrenom(prenom);
		membre.setDateNaiss(dateNaissance);
		membre.setRue(rue);
		membre.setCp(cp);
		membre.setTel(tel);
		membre.setVille(ville);
		membre.setMail(mail);
		membre.setMdp(mdpEncoded);
		
		Optional<Role> optionRole = roleRepository.findRoleByNom(Role.USER);
		Role role = optionRole.get();
		membre.setRole(role);
		membreRepository.save(membre);
		return membre;
	}
}