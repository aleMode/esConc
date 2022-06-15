package es3_5;

import java.util.concurrent.Semaphore;

public class Table {
	
	private boolean isFinita;
	private int turn;
	
	Table(){
		isFinita = false;
		turn = 0;
	}
	
	synchronized void mossa(int playerId, int dado1, int dado2, boolean doppio){
		
		while(turn != playerId) {
			try {wait();} catch (InterruptedException e) {}	
		}
		if (isFinita == true) return;
		
		isFinita=(Math.random() < 0.05);
		if(isFinita)
			System.out.println("il giocatore " + playerId + " ha mosso e vinto!");
		
		if(!doppio) {
			turn();		
			notifyAll();
		}
	}
	
	private synchronized void turn() {
		turn = (turn + 1) % 3;
	}
	
	boolean finita(){
		return isFinita;
	}
}