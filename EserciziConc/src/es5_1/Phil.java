package es5_1;

public class Phil extends Thread{
	private Pool pool;
	
	Phil(Pool pool, String name){
		this.pool = pool;
		Thread.currentThread().setName(name);
	}
	
	public void run() {
		while(true) {
			try {
				doActivity();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				takeChop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				eat();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void doActivity() throws InterruptedException {
		Thread.sleep((long) (15*Math.random()));
		//System.out.println(Thread.currentThread().getName() + " ha fatto cose");
	}
	
	private void takeChop() throws InterruptedException {
		pool.chop(false);
		//System.out.println(Thread.currentThread().getName() + " ha preso la prima bacchetta");
		pool.chop(true);
		//System.out.println(Thread.currentThread().getName() + " ha preso la seconda bacchetta");
	}
	
	private void eat() throws InterruptedException {
		//System.out.println(Thread.currentThread().getName() + " is eating");
		Thread.sleep((long) (15*Math.random()));
		
		//System.out.println(Thread.currentThread().getName() + " posa i chopsticks");
		pool.posa();
		
		//System.out.println(Thread.currentThread().getName() + " ricomincia");
	}
}
