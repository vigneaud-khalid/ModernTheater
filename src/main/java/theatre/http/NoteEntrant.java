package theatre.http;

import java.util.Date;

public class NoteEntrant {
	
	private int valeur;
	
	
	private int pieceId;
	
	public NoteEntrant() {
		super();
	}
	public NoteEntrant(int valeur, int pieceId) {
		super();
		this.valeur = valeur;
		
	
		this.pieceId = pieceId;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	public int getPieceId() {
		return pieceId;
	}
	public void setPieceId(int pieceId) {
		this.pieceId = pieceId;
	}
	
	
	
	

}
