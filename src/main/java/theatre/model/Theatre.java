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
public class Theatre implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 70)
	private String nom;

	@Column(length = 80)
	private String rue;

	@Column(length = 40)
	private String cp;

	@Column(length = 40)
	private String ville;

	@Column(length = 40)
	private String mail;
	
	@Column(length = 40)
	private String tel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "theatre")
	private Collection<Salle> salles;
	
	public Theatre() {
		salles = new ArrayList<>();
	}

	public Theatre(String nom, String rue, String cp, String ville, String mail, String tel) {
		this();
		this.nom = nom;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
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

	public Collection<Salle> getSalles() {
		return salles;
	}

	public void setSalles(Collection<Salle> salles) {
		this.salles = salles;
	}

	@Override
	public String toString() {
		return "Theatre [id=" + id + ", nom=" + nom + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville + ", mail="
				+ mail + ", tel=" + tel + "]";
	}
	
	
	
	


}
