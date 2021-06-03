package theatre.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import theatre.model.Membre;

public interface MembreRepository   extends JpaRepository<Membre, Integer> {

	public List<Membre> findByNom(String nom);
	
	@Query("select m from Membre m where m.nom = :nomMembre")
	public List<Membre> trouverMembreParNom(String nomMembre);
	
	@Query("select m from Membre m where m.prenom = :prenomMembre")
	public List<Membre> trouverMembreParPrenom(String prenomMembre);
		
	@Query("SELECT m FROM Membre m WHERE m.mail = :mailMembre")
	public Optional<Membre> chercherMembreParMail(String mailMembre);
	
	@Query("SELECT m FROM Membre m WHERE m.id =:idMembre")
	public Membre finUserById(String idMembre);	
}
