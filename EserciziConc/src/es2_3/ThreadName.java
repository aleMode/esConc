package es2_3;

public class ThreadName extends Thread{
	
	public ThreadName(String nome){
		this.setName(nome);
	}
	
	public void run() {
		for(int i = 0; i<3; i++) {
			System.out.println("Thread: " + this.getName());
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}		
	}
	
	public static void main(String[] args) {
		ThreadName thread = new ThreadName("piero");
		thread.run();
		for(int i = 0; i<3; i++) {
			System.out.println("Main");
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}	
	}

}
