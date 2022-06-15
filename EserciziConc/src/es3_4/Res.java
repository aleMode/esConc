package es3_4;

public class Res {
	private boolean res;
	
	Res(){
		
	}
	
	public synchronized void action(){
		res = !res;
		System.out.println("Il thread: " + Thread.currentThread().getName() + " ha cambiato lo stato a: " + res);
		
		notifyAll();
		try {wait();} 
		catch (InterruptedException e) {}
	}
}
