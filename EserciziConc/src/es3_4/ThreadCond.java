package es3_4;

public class ThreadCond extends Thread{

	private static Res res;
	
	ThreadCond(Res r, String name){
		res = r;
		this.setName(name);
	}
	
	public void run() {
		while(true) {
			res.action();
			try {sleep(100);} 
			catch (InterruptedException e) {}
		}
	}
}
