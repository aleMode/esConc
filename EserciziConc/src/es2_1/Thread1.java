package es2_1;

public class Thread1 extends Thread{

	public Thread1(){
		
	}
	
	public void run() {
		for(int i = 0; i<3; i++) {
			System.out.println("Thread: " + this.getName());
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}		
	}
	
	public static void main(String[] args) {
		Thread1 thread = new Thread1();
		thread.run();
		for(int i = 0; i<3; i++) {
			System.out.println("Main");
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}	
	}
	
}
