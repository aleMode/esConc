package es3_1;

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
		try {
			mutex.acquire();
		} catch(InterruptedException e) {}
		
		if(numItems == SIZE) {
			System.err.println("buffer pieno");
			mutex.release();
			return;
		}
		
		numItems++;
		numeri[ultimo] = item;
		ultimo = (ultimo + 1) % SIZE;
		
		System.out.println("caricato " + item );
		
		mutex.release();
	}
	
	public int getItem() {
		try {
			mutex.acquire();
		}catch(InterruptedException e) {}
		
		if(numItems == 0) {
			System.err.println("Buffer vuoto");
			mutex.release();
			return -1;
		}
				
		int num;
		
		numItems--;
		num = numeri[primo];
		primo = (primo + 1) % SIZE;
		
		System.out.println("Prelevato " + num);
		
		mutex.release();
		
		return num;
	}
	
}
