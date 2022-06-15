package es3_3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Coda {
	static int SIZE;
	private int numItems = 0;
	private BlockingQueue<Integer> numeri;
	private int primo, ultimo;
	
	Semaphore mutex = new Semaphore(1);
	
	Coda(int size){
		SIZE = size;
		primo = 0;
		ultimo = 0;
		numeri = new ArrayBlockingQueue<Integer>(SIZE);
	}
	
	public void setItem(int item){
		try{numeri.offer(item, 5, TimeUnit.SECONDS );}
		catch(InterruptedException e) {}
		
		System.out.println("caricato " + item );
		
	}
	
	public int getItem(){
		int num = -1;
		
		try{num = numeri.poll(5, TimeUnit.SECONDS);}
		catch(InterruptedException e) {}
		
		System.out.println("Prelevato " + num);
		
		return num;
	}
	
}
