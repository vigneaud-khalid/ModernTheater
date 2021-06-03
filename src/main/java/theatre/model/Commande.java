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

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 60)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne  
	private Membre membre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "commande")
	private Collection<Billet> billets;

	public Commande() {
		billets = new ArrayList<>();
	}

	public Commande(Date date, Membre membre) {
		this();
		this.date = date;
		this.membre = membre; 
	}
	

	
	public Commande(Date date) {
		this();
		this.date = date;
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

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Collection<Billet> getBillets() {
		return billets;
	}

	public void setBillets(Collection<Billet> billets) {
		this.billets = billets;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + "]";
	}
}