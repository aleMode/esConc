package es4_1;

public class CalcSeq {
	public static void main(String[] args) {
		int n = 25000;
		int m = 25000;
		int[][] matrix = new int[n][m];
		
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < m; j++) 
				matrix[i][j] = ((int) (10*Math.random()));
				
		int[] c = new int[n];
		
		final long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < m; j++)
				c[i] += matrix[i][j];
		
		final long endTime = System.currentTimeMillis();
		final long Time = endTime - startTime;
		
		System.out.println("Total execution time: " + Time + "ms");

	}
}
