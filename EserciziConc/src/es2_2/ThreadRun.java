package es2_2;

public class ThreadRun implements Runnable{

	public static void main(String[] args) {
		ThreadRun th = new ThreadRun();
		Thread thRun = new Thread(th);
		
		thRun.run();
		
		for(int i = 0; i<3; i++) {
			System.out.println("Main");
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}
	}

	@Override
	public void run() {
		for(int i = 0; i<3; i++) {
			System.out.println("Thread");
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}	
	}

}
