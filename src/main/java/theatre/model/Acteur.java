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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Acteur implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	@Column(nullable = false, length = 70)
	private String nom;

	@Column(nullable = false, length = 70)
	private String prenom;

	@Column(length = 40)
	private String nationalite;

	@Column(length = 40)
	private String mail;
	
	@Column(length = 40)
	private String tel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "acteur")
	private Collection<Distribution> distributions;

	public Acteur() {
		distributions = new ArrayList<>();
	}

	public Acteur(String nom, String prenom, String nationalite, String mail, String tel) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.mail = mail;
		this.tel = tel;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Collection<Distribution> getDistributions() {
		return distributions;
	}

	public void setDistributions(Collection<Distribution> distributions) {
		this.distributions = distributions;
	}

	@Override
	public String toString() {
		return "Acteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nationalite=" + nationalite + ", mail="
				+ mail + ", tel=" + tel + "]";
	}
}