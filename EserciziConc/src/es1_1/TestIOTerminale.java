package es1_1;

import java.io.*;

public class TestIOTerminale {

	public static void main(String[] args) throws IOException  {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		
		Integer num;
		String tmp;
		
		while(true){
			num = null;
			tmp = in.readLine();
			
			if(tmp.equals("basta")) break;
			while(num == null) {
				try {num = Integer.parseInt(tmp);}
				catch (Exception e) {
					System.out.println("Errore, riprova");
					tmp = in.readLine();
				}
			}
			System.out.println("ciao: " + num);
		}
	}
}
