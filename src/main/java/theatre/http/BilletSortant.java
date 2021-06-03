package theatre.http;

import java.util.Date;

import theatre.model.Piece;
import theatre.model.TVA;

public class BilletSortant {
	
	private String nom;
	private String prenom;
	private String numeroBillet;
	private Piece piece;
	private Date dateSeance;
	private float prixHT;
	private float prixTTC;
	

	private TVA tva;
	
	
	
	
	public TVA getTva() {
		return tva;
	}
	public void setTva(TVA tva) {
		this.tva = tva;
	}
	public BilletSortant() {
		
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
	public String getNumeroBillet() {
		return numeroBillet;
	}
	public void setNumeroBillet(String numeroBillet) {
		this.numeroBillet = numeroBillet;
	}
	
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public Date getDateSeance() {
		return dateSeance;
	}
	public void setDateSeance(Date dateSeance) {
		this.dateSeance = dateSeance;
	}
	
	
	
	
	public float getPrixHT() {
		return prixHT;
	}
	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}
	public float getPrixTTC() {
		return prixTTC;
	}
	public void setPrixTTC(float prixTTC) {
		this.prixTTC = prixTTC;
	}

	
	
	

}
