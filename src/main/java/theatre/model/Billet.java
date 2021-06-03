package theatre.model;

/**
 * author :  kh
 * date : 04/04/2021
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;



@Entity
public class Billet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 60)
	private String numero;

	@ManyToOne
	private Seance seance; 

	@ManyToOne
	private TVA tva;

	@ManyToOne
	private Tarif tarif;

	@ManyToOne
	private Commande commande;

	public Billet() {
	
	}

	


	public Billet( Seance seance, TVA tva, Tarif reduction, Commande commande) {
		this();
		this.seance = seance;
		this.tva = tva;
		this.tarif = reduction;
		this.commande = commande;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public TVA getTva() {
		return tva;
	}

	public void setTva(TVA tva) {
		this.tva = tva;
	}

	

	
	public Tarif getTarif() {
		return tarif;
	}




	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}




	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	 public float getPrixTTC(){
	        return tarif.getPrix()  + tarif.getPrix()*(tva.getTaux()/100);
	    } 

	
	@Override
	public String toString() {

		return "Billet [numero=" + numero +  "]";
	}
	
	@PrePersist
	public void init() {
		UUID  uuid = UUID.randomUUID(); 
		numero = uuid.toString();
	}


}