package theatre.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import theatre.model.Commande;
import theatre.http.BilletSortant;
import theatre.model.Billet;
import theatre.model.Piece;
import theatre.model.Role;
import theatre.model.Salle;
import theatre.model.Seance;
import theatre.model.TVA;
import theatre.model.Tarif;
import theatre.model.Membre;
import theatre.repository.BilletRepository;
import theatre.repository.CommandeRepository;
import theatre.repository.MembreRepository;
import theatre.repository.PieceRepository;
import theatre.repository.SeanceRepository;
import theatre.repository.TarifRepository;
import theatre.repository.TvaRepository;

@Service
public class PanierService {

	@Autowired
	private PieceRepository pieceRepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	private BilletRepository billetRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private TarifRepository tarifRepository;
	@Autowired
	private TvaRepository tvaRepository;

	public List<BilletSortant> creerCommande(List<HashMap<String, String>> panier, Membre membre) {

		if (!panier.isEmpty()) {
			Commande cmd = new Commande();

			List<BilletSortant> billetSortant = new ArrayList<>();

			cmd.setDate(new Date());
			cmd.setMembre(membre);
			cmd = commandeRepository.save(cmd);

			for (HashMap<String, String> ligne : panier) {

				int idSeance = Integer.valueOf(ligne.get("idSeance"));
				int idTarif = Integer.valueOf(ligne.get("idTarif"));

				Optional<Seance> seanceOption = seanceRepository.findSeanceById(idSeance);
				Optional<Tarif> tarifOption = tarifRepository.findById(idTarif);

				if (seanceOption.isPresent()) {

					Seance seance = seanceOption.get();
					Tarif tarif = tarifOption.get();

					System.out.println(seance);

					seanceRepository.save(seance);

					int qte = Integer.valueOf(ligne.get("qte"));
					seance.setnbrePlacesDispo(seance.getnbrePlacesDispo() - qte);
					
					for (int i = 0; i < qte; i++) {
						Billet b1 = new Billet();

						b1.setCommande(cmd); 
						b1.setSeance(seance);
						b1.setTarif(tarif);
						
						
						Optional<TVA> tvaOption = tvaRepository.findRoleByNom(TVA.TVA_ACTIVE);
						TVA tva = tvaOption.get();
						
						b1.setTva(tva);

						billetRepository.save(b1);

						BilletSortant bs1 = new BilletSortant();
						bs1.setNom(membre.getNom());
						bs1.setPrenom(membre.getPrenom());
						bs1.setNumeroBillet(b1.getNumero());
						bs1.setDateSeance(seance.getDate());

						bs1.setPiece(seance.getPiece());
						bs1.setPrixHT(tarif.getPrix());
						bs1.setPrixTTC(b1.getPrixTTC());

						bs1.setTva(b1.getTva());

						billetSortant.add(bs1);

					}

				}
			}
			return billetSortant;
		} else {
			return null;
		}

	}

}
