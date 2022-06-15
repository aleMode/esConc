package es5_1;

public class Pool {
	private int size;
	private Chopstick[] sticks;
	private Integer available;
	
	Pool(int qta){
		this.size = qta;
		sticks = new Chopstick[size];
		for(int i = 0; i < size; i++)
			sticks[i] = new Chopstick(i+1);
		available = size;
	}
	
	public synchronized void chop(boolean isSecond) throws InterruptedException {
		while( (!isSecond && (available == 1)) || available == 0)
			wait();
		synchronized(available) {
			available--;
			System.out.println(Thread.currentThread().getName() + " Chop preso, ne rimangono: " + available);
		}
	}
	
	public synchronized void posa() {
		synchronized(available) {
			available = available + 2;
			System.out.println(Thread.currentThread().getName() + " Chop posati, ne rimangono: " + available);
			notifyAll();
		}
		
	}
}
