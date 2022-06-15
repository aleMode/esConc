package es2_7;

import java.io.*;

public class ThreadFine extends Thread{
	boolean sleep;
	boolean kill = false;
	
	ThreadFine(boolean pausa){
		sleep = pausa;
	}

	public void run() {		
		while(!kill) {
			System.out.println("ciao");
			if(sleep) {
				try {sleep(500);} 
				catch (InterruptedException e) {}
			}
			else {
				for(int i = 0; i < 1000; i++)
					sleep = true;
			}
		}
		System.out.println("termino");
	}
	
	public void kill() {
		kill=true;
	}
	
	public static void main(String[] args) throws IOException {
		ThreadFine a = new ThreadFine(true);
		a.start();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			if(in.readLine().equals("fine")) {
				a.kill();
				break;
			}
		}
	}
}
