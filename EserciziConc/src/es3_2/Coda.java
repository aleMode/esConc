package es3_2;

import java.util.concurrent.Semaphore;

public class Coda {
	static int SIZE;
	private int numItems = 0;
	private int[] numeri;
	private int primo, ultimo;
	
	Semaphore mutex = new Semaphore(1);
	
	Coda(int size){
		SIZE = size;
		primo = 0;
		ultimo = 0;
		numeri = new int[SIZE];
	}
	
	public void setItem(int item) {
		try {mutex.acquire();}
		catch(InterruptedException e) {}
		
		while(numItems == SIZE) {
			System.err.println("buffer pieno");
			mutex.release();
			
			try{wait();}
			catch (InterruptedException e) {}
			
			try {mutex.acquire();} 
			catch (InterruptedException e) {}
		}
		
		numItems++;
		numeri[ultimo] = item;
		ultimo = (ultimo + 1) % SIZE;
		
		System.out.println("caricato " + item );
		
		if((numItems - 1) == SIZE)
			notifyAll();
		
		mutex.release();
	}
	
	public int getItem() {
		try {
			mutex.acquire();
		}catch(InterruptedException e) {}
		
		while(numItems == 0) {
			System.err.println("Buffer vuoto");
			mutex.release();
			
			try{wait();}
			catch (InterruptedException e) {}
			
			try {mutex.acquire();} 
			catch (InterruptedException e) {}
		}
				
		int num;
		
		numItems--;
		num = numeri[primo];
		primo = (primo + 1) % SIZE;
		
		System.out.println("Prelevato " + num);
		
		if((numItems + 1) == SIZE)
			notifyAll();
		mutex.release();
		
		return num;
	}
	
}
