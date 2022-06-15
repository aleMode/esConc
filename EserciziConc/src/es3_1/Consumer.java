package es3_1;

import es3_1.Coda;

public class Consumer extends Thread{
	private Coda buffer;
	
	Consumer(Coda a){
		buffer = a;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep((int) (Math.random()*5000));
			}catch(InterruptedException e) {}
			
			buffer.getItem();
		}
	}
}
