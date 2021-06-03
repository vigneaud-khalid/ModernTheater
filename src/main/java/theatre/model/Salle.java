package theatre.model;

/**
 * author :  kh
 * date : 04/04/2021
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Salle implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
	
	@Column(length = 70,nullable = false)
    private String nom;
	 
	@Column(length = 30,nullable = false)
    private int nbPlaces;
	
	@ManyToOne 
	private Theatre theatre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "salle")
	private Collection<Seance> seances;
	
	public Salle() {
		seances = new ArrayList<>();
	}

	public Salle(int numero, String nom, int nbPlaces) {
		this();
		this.numero = numero;
		this.nom = nom;
		this.nbPlaces = nbPlaces;
	}


	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	
	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Collection<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Collection<Seance> seances) {
		this.seances = seances;
	}

	@Override
	public String toString() {

		return "Salle [ numero=" + numero + ", nom=" + nom + ", nbPlaces=" + nbPlaces + "]";

	}

	
	
}