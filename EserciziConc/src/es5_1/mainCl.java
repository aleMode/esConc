package es5_1;

public class mainCl {
	public static void main(String[] args) {
		Pool pool = new Pool(5);
		for(int i=0; i<5; i++)
			new Phil(pool, "F"+(i+1)).start();
	}
}
