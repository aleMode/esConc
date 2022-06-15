package es4_1;

public class CalcParall extends Thread{
	static int[][] matrix; 
	static int m;
	int n;
	static int[] tot;
	String name = "";
	
	CalcParall(String name, int n){
		this.setName(name);
		this.n = n;
		tot = new int[m];
	}
	
	public static void main(String[] args) throws InterruptedException {
		int n = 25000;
		int m = 25000;
		int[][] matrix = new int[n][m];
	
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < m; j++) 
				matrix[i][j] = ((int) (10*Math.random()));
				
		
		final long startTime = System.currentTimeMillis();
		
		CalcParall.m = m;
		CalcParall.matrix = matrix;
		CalcParall[] threads = new CalcParall[n];
		for(int i = 0; i < n; i++) 
			threads[i] = new CalcParall("name"+i, i);

		for(CalcParall elem : threads)
			elem.start();
		
		for(CalcParall elem : threads)
			elem.join();
		
		for(int i : CalcParall.tot)
			System.out.println(i);
		
		final long endTime = System.currentTimeMillis();
		final long Time = endTime - startTime;
		System.out.println("Total execution time: " + Time + "ms");

	}

	@Override
	public void run() {
		int c = 0;

		for(int j = 0; j < m; j++)
			c += matrix[n][j];
		
		tot[n] = c;
	}
}
