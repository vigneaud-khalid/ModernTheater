package theatre.model;

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
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String USER = "ROLE_USER";
	public static final String ADMIN = "ROLE_ADMIN";


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, nullable = false, length = 15)
	private String nom;
  
	
    @JsonIgnore
	@OneToMany(mappedBy = "role")
	private Collection<Membre> membres;


	public Role() {
		membres = new ArrayList<>();
		
	}
	


	public Role(String nom) {
	
		this.nom = nom;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Role(String nom, Collection<Membre> membres) {
		this();
		this.nom = nom;
		
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Collection<Membre> getMembres() {
		return membres;
	}


	public void setMembres(Collection<Membre> membres) {
		this.membres = membres;
	}


	@Override
	public String toString() {
		return "Role [nom=" + nom + ", membres=" + membres + "]";
	}	
	
    
    
    
    

}
