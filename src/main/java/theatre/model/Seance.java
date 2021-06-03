package theatre.model;

/**
 * author :  kh
 * date : 04/04/2021
 */

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Seance implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 70)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(nullable = false)
	private int nbrePlacesDispo;
		
	@ManyToOne 
	private Salle salle;
	
	@ManyToOne 
	private Piece piece;
	
	@JsonIgnore
	@OneToMany(mappedBy = "seance")
	private Collection<Billet> billets;
	
	@JsonIgnore
	@ManyToMany
	private Collection<Tarif> tarifs;

	public Seance() {
		billets = new ArrayList<>();
		tarifs = new ArrayList<>();
	}

	public Seance(Date date, int nbrePlacesDispo) {
		this();
		this.date = date;
		this.nbrePlacesDispo = nbrePlacesDispo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Collection<Billet> getBillets() {
		return billets;
	}

	public void setBillets(Collection<Billet> billets) {
		this.billets = billets;
	}
	
	public int getnbrePlacesDispo() {
		return nbrePlacesDispo;
	}

	public void setnbrePlacesDispo(int nbrePlacesDispo) {
		this.nbrePlacesDispo = nbrePlacesDispo;
	}

	public Collection<Tarif> getTarifs() {
		return tarifs;
	}

	public void setTarifs(Collection<Tarif> tarifs) {
		this.tarifs = tarifs;
	}

	public Collection<Tarif> getReductions() {
		return tarifs;
	}

	public void setReductions(Collection<Tarif> reductions) {
		this.tarifs = reductions;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	@Override
	public String toString() {

		return "Seance [date=" + date + ", nbrePlacesDispo=" + nbrePlacesDispo + "]";
	}
}