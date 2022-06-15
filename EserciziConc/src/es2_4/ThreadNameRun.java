package es2_4;

import es2_3.ThreadName;

public class ThreadNameRun implements Runnable{

	ThreadNameRun(String name){
		Thread.currentThread().setName(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i<55; i++) {
			System.out.println("Thread: " + Thread.currentThread().getName());
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}		
	}
	
	public static void main(String[] args) {
		ThreadNameRun thread = new ThreadNameRun("piero");
		thread.run();
		for(int i = 0; i<55; i++) {
			System.out.println("Main");
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}	
	}

	
}
