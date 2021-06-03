package theatre.http;

/**
* author : kh
* date : 10/04/2021
*/

public class RegisterEntrant {

	private String nom;
	private String prenom;
	private String dateNaiss;
	private String rue;
	private String cp;
	private String ville;
	private String tel;
	private String mail;
	private String mdp;
	private String mdp2;
	

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
	
	public String getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public String getMdp2() {
		return mdp2;
	}
	public void setMdp2(String mdp2) {
		this.mdp2 = mdp2;
	}
	@Override
	public String toString() {
		return "RegisterEntrant [nom=" + nom + ", prenom=" + prenom + ", dateNaiss=" + dateNaiss + ", rue=" + rue
				+ ", cp=" + cp + ", ville=" + ville + ", tel=" + tel + ", mail=" + mail + ", mdp=" + mdp + ", mdp2="
				+ mdp2 + "]";
	}
}