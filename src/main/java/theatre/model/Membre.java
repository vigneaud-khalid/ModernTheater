package theatre.model;

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


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Membre implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private String prenom;
	
	
	@Column
	private Date dateNaiss;
	
	@Column
	private String mail;
	
	@JsonIgnore
	@Column
	private String mdp;
	
	@Column
	private String rue;
	
	@Column
	private String ville;
	
	@Column
	private String cp;
	
	@Column
	private String tel;
	
	@ManyToOne
	private Role role;
	
	@JsonIgnore
	@OneToMany (mappedBy = "membre")
	private Collection <Token> tokens;
	
	@JsonIgnore
	@OneToMany (mappedBy = "membre")
	private Collection <Avis> avis;
	
	@JsonIgnore
	@OneToMany (mappedBy = "membre")
	private Collection <Note> notes;
	
	@JsonIgnore
	@OneToMany (mappedBy = "membre")

	private Collection <Commande> commandes;


	public Membre() {
		tokens= new ArrayList<>();
		avis = new ArrayList<>();
		notes = new ArrayList<>();

		commandes = new ArrayList<>();

		
	}

	public Membre(String nom, String prenom, Date dateNaiss, String mail, String mdp, String rue, String ville,
			String cp, String tel) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
		this.mail = mail;
		this.mdp = mdp;
		this.rue = rue;
		this.ville = ville;
		this.cp = cp;
		this.tel = tel;
	}
	
	

	public Membre(String nom, String prenom, String mail, String mdp) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
	}
	

	public Membre(String nom, String prenom, String mail, String mdp, Role role) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.role = role;
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

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Collection<Token> getTokens() {
		return tokens;
	}

	public void setTokens(Collection<Token> tokens) {
		this.tokens = tokens;
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




	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;

	}

	@Override
	public String toString() {
		return "Membre [nom=" + nom + ", prenom=" + prenom + ", dateNaiss=" + dateNaiss + ", mail=" + mail + "]";
	}
	
	
	
	

}