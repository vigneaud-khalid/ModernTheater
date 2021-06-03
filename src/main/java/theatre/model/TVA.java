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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TVA implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String TVA_ACTIVE = "Taux TVA sur les spectacles classiques";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 40)
	private String nom;
	
	@Column(nullable = false)
	private float taux;

	@JsonIgnore
	@OneToMany(mappedBy = "tva")
	private Collection<Billet> billets;

	public TVA() {
		billets = new ArrayList<>();
	}

	public TVA(String nom, float taux) {
		this();
		this.nom = nom;
		this.taux = taux;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public Collection<Billet> getBillets() {
		return billets;
	}

	public void setBillets(Collection<Billet> billets) {
		this.billets = billets;
	}

	@Override
	public String toString() {
		return "TVA [id=" + id + ", nom=" + nom + ", taux=" + taux + "]";
	}
}