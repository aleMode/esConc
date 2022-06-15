package es7_2;

public class Asta {
	public String nomeOggetto;
	private int currOffer;
	private String nameOffer;
	private long timeOffer;
	private int minRaise;
	
	
	Asta(String nome, int baseOffer, int raise){
		this.nomeOggetto = nome;
		this.currOffer = baseOffer;
		this.minRaise = raise;
		this.timeOffer = System.currentTimeMillis();
		
	}
	
	public synchronized boolean newOffer(int offer, String name) {
		if(offer > (this.currOffer + this.minRaise)) {
			this.currOffer = offer;
			this.nameOffer = name;
			this.timeOffer = System.currentTimeMillis();
			return true;
		}else {
			return false;
		}
	}
	
	public int checkOffer() {
		return this.currOffer;
	}
	
	public String retName() { 
		return this.nameOffer;
	}
	
	public long timeOffer() {
		return this.timeOffer;
	}
}
