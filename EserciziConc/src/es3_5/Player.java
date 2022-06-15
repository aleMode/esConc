package es3_5;

import java.util.concurrent.ThreadLocalRandom;

public class Player extends Thread {
	int myId;
	Table myTable;
	
	public Player(int id, Table t){
		this.myId=id;
		this.myTable = t;
		
		this.start();
	}
	
	public void run(){
		boolean doppio=false;
		int dado1;
		int dado2;
		
		while(!myTable.finita()){
			doppio=true;
			while(doppio){
				dado1=(int)(6*Math.random());
				dado2=(int)(6*Math.random());
				doppio=(dado1==dado2);
				
				myTable.mossa(myId, dado1, dado2, doppio);
				if(myTable.finita() != true) System.out.println("Giocatore "+ myId +" ha mosso ");
			}
						
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(100, 300));
			} catch (InterruptedException e1) {	}

		}
	}
}