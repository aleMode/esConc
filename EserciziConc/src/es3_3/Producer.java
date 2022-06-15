package es3_3;

import es3_3.Coda;

public class Producer extends Thread{
	private Coda buffer;
	
	Producer(Coda a){
		buffer = a;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep((int) (Math.random()*5000));
			}catch(InterruptedException e) {}
			
			int num = (int) (Math.random()*100);
			buffer.setItem(num);
		}
	}
	
}
