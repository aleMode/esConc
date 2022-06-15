package es1_5;

import java.io.*;
import java.util.*;

public class provaToken {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\alemo\\eclipse-workspace\\EserciziConc\\bin\\es1_5\\dizionario.txt");
		FileInputStream filerd = new FileInputStream(file);
		BufferedReader dizionario = new BufferedReader(new InputStreamReader(filerd));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String riga = "";
		String input = in.readLine();
		String parolaDiz = "";
		boolean tradotto = false;
		
		while(!input.equals("<Fine>")) {
			while(dizionario.ready() && !tradotto) {
				StringTokenizer stk = new StringTokenizer(dizionario.readLine(), ",");
				parolaDiz = stk.nextToken();
				
				if(parolaDiz.equals(input)) {
					System.out.println("Traduzione della parola: " + stk.nextToken());
					tradotto = true;
				}
			}
			if(!tradotto) System.out.println("Parola non stata trovata");
			
			filerd.getChannel().position(0);
			dizionario = new BufferedReader(new InputStreamReader(filerd));
			tradotto = false;
			input = in.readLine();
		}
		
		System.out.println("Fine");	
	}

}
