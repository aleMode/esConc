package es2_5;

public class ThreadSubito extends Thread{
	public ThreadSubito(String nome){
		this.setName(nome);
		run();
	}
	
	public void run() {
		for(int i = 0; i<3; i++) {
			System.out.println("Thread: " + this.getName());
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}		
	}
	
	public static void main(String[] args) {
		ThreadSubito thread = new ThreadSubito("piero");
		for(int i = 0; i<3; i++) {
			System.out.println("Main");
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}	
	}
}
