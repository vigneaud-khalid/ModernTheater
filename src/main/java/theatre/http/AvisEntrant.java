package theatre.http;

/**
 * author : kh
 * date : 09/04/2021
 */

public class AvisEntrant {
	
	private String valeur;
	private int pieceId;
	
	public AvisEntrant() { 	}
	
	public AvisEntrant(String valeur, int pieceId) {
		this();
		this.valeur = valeur;
		this.pieceId = pieceId;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	public int getPieceId() {
		return pieceId;
	}
	public void setPieceId(int pieceId) {
		this.pieceId = pieceId;
	}

	@Override
	public String toString() {
		return "AvisEntrant [valeur=" + valeur + ", pieceId=" + pieceId + "]";
	}
	
}