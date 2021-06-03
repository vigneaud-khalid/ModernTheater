package theatre.http;

/**
 * author : kh
 * date : 09/04/2021
 */

public class LoginEntrant {
	
	private String mail;
	private String password;
	
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginEntrant [mail=" + mail + ", password=" + password + "]";
	}
	
}