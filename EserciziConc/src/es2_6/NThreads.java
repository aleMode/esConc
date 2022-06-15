package es2_6;

public class NThreads {
	private int id;
	
	NThreads(int num){
		this.id=num;
		run();
	}
	
	public void run(){
		for(int i = 0; i < 10; i++) {
			System.out.println("Thread: " + this.id);
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}
	}
	
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		NThreads a;
		
		for(int i = 0; i < num; i++) {
			 a = new NThreads(i);
		}
		
	}

}
