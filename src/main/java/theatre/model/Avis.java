package theatre.model;

/**
 * author :  kh
 * date : 04/04/2021
 */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 200)
	private String valeur;

	@Column(length = 60)
	private Date date;

	@Column(length = 60)
	private Date dateModif;

	@ManyToOne 
	private Piece piece;
	
	@ManyToOne 
	private Membre membre;
	
	public Avis() { 	}

	public Avis(String valeur, Date date, Date dateModif) {
		this();
		this.valeur = valeur;
		this.date = date;
		this.dateModif = dateModif;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	@Override
	public String toString() {
		return "Avis [id=" + id + ", valeur=" + valeur + ", date=" + date + ", dateModif=" + dateModif + "]";
	}
}