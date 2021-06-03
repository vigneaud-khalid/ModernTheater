package theatre.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import theatre.model.Commande;
import theatre.model.Membre;
import theatre.repository.CommandeRepository;


@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepository;
	
	public Commande validerCommande(Date date, Membre membre) {
		
			Commande cmd = new Commande();
			cmd.setDate(new Date());		
			cmd.setMembre(membre);
			cmd = commandeRepository.save(cmd);
			
			return cmd;
		}
		
	}

