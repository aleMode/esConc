package es3_1;

import es3_1.*;

public class ProdCons {

	public static void main(String[] args) {
		Coda buffer = new Coda(4);
		Producer prod = new Producer(buffer);
		Consumer cons = new Consumer(buffer);
		
		prod.start();
		cons.start();

	}

}
