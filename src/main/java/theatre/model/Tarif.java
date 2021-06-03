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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tarif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 70)
	private String nom;
	
	@Column(nullable = false)
	private float prix;

	@JsonIgnore
	@OneToMany(mappedBy = "tarif")
	private Collection<Billet> billets;
	
	@JsonIgnore 
	@ManyToMany(mappedBy = "tarifs") //sens principal: Seance vers Tarif
	private Collection<Seance> seances;
	
	
	public Tarif() {
		billets = new ArrayList<>();
		seances = new ArrayList<>();
	}

	public Tarif(String nom, float prix) {
		this();
		this.nom = nom;
		this.prix = prix; 
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Collection<Billet> getBillets() {
		return billets;
	}

	public void setBillets(Collection<Billet> billets) {
		this.billets = billets;
	}

	public Collection<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Collection<Seance> seances) {
		this.seances = seances;
	}

	@Override
	public String toString() {
		return "Tarif [nom=" + nom + ", prix=" + prix + "]";
	}

	
}