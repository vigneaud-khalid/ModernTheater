package theatre.model;

/**
 * author :  kh
 * date : 04/04/2021
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Piece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 70)
	private String nom;

	@Column(nullable = false, length = 5000)
	private String resume;

	@Column(length = 70)
	private String photo;

	@Column(nullable = false)
	private int duree; //min

	@Column(length = 60)
	@Temporal(TemporalType.DATE)
	private Date debutRep;

	@Column(length = 60)
	@Temporal(TemporalType.DATE)
	private Date finRep;

	@ManyToOne  
	private Categorie categorie;
	
	@JsonIgnore
	@OneToMany(mappedBy = "piece")
	private Collection<Seance> seances;
	
	@JsonIgnore
	@OneToMany(mappedBy = "piece")
	private Collection<Distribution> distributions;
	
	@JsonIgnore
	@OneToMany(mappedBy = "piece")
	private Collection<Avis> avis;
	
	@JsonIgnore
	@OneToMany(mappedBy = "piece")
	private Collection<Note> notes;

	public Piece() {
		seances = new ArrayList<>();
		distributions = new ArrayList<>();
		avis = new ArrayList<>();
		notes = new ArrayList<>();
		
	}

	public Piece(String nom, String resume, String photo, int duree, Date debutRep, Date finRep) {
		this();
		this.nom = nom;
		this.resume = resume;
		this.photo = photo;
		this.duree = duree;
		this.debutRep = debutRep;
		this.finRep = finRep;

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

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Date getDebutRep() {
		return debutRep;
	}

	public void setDebutRep(Date debutRep) {
		this.debutRep = debutRep;
	}

	public Date getFinRep() {
		return finRep;
	}

	public void setFinRep(Date finRep) {
		this.finRep = finRep;
	}
	
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Collection<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Collection<Seance> seances) {
		this.seances = seances;
	}

	public Collection<Distribution> getDistributions() {
		return distributions;
	}

	public void setDistributions(Collection<Distribution> distributions) {
		this.distributions = distributions;
	}

	public Collection<Avis> getAvis() {
		return avis;
	}

	public void setAvis(Collection<Avis> avis) {
		this.avis = avis;
	}

	public Collection<Note> getNotes() {
		return notes;
	}

	public void setNotes(Collection<Note> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Piece [id=" + id + ", nom=" + nom + ", resume=" + resume + ", photo=" + photo + ", duree=" + duree
				+ ", debutRep=" + debutRep + ", finRep=" + finRep + "]";
	}
	
}
