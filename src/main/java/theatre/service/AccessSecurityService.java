package theatre.service;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * author :  kh
 * date : 04/04/2021
 */

import org.springframework.stereotype.Service;

import theatre.model.Membre;
import theatre.model.Role;
import theatre.model.Token;
import theatre.repository.TokenRepository;

@Service
public class AccessSecurityService {

	@Autowired
	private TokenRepository tokenRepository;

	// récuperation un token via HttpServletRequest
	public Optional<Token> identifierToken(HttpServletRequest request) {
		String valeurToken = request.getHeader("Authorization");
		//suppression des tokens obsolètes
		if (valeurToken == null) {
			return Optional.empty();
		}
		valeurToken = valeurToken.replace("Bearer ", "");
		Optional<Token> option = tokenRepository.selectByValeur(valeurToken);
		return option;
	}
	
	// verification d'accès au role
	public boolean verifierRole(HttpServletRequest request, String nomRole) {
		Optional<Token> option = identifierToken(request);
		if (option.isPresent()) {
			Token token = option.get();  //récuperation du token
			if (token.getExpireDate().before(new Date()))
				return false;
			Membre membre = token.getMembre(); //
			
			Role role = membre.getRole();
			return role.getNom().equals(nomRole);
		}
		return false;
	}
	//verification de la date d'expiration du token ???????????????
	
	public Membre findUserByToken(HttpServletRequest request ) {
		Optional<Token> option = identifierToken(request);
		if(option.isPresent()) {
			Token token = option.get();//recuperer le token
			Membre utilisateur = token.getMembre(); // recuperer l'utilisateur qui correspond au token
			return utilisateur;
		}else {
			return null;
		}
	}
}

