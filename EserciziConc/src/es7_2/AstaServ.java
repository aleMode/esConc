package es7_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class AstaServ extends Thread{
	
	private Asta asta;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public AstaServ(Asta a, Socket s) throws IOException {
		this.asta = a;
		this.socket=s;
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		start();
	}
	
	public void run() {
		while(true) {
			String str = "";
			try {
				str = in.readLine();
				
				if(str.equals("END")) 
					break;
				if(str.equals("READ")) {
					if(this.asta.retName() == null)
						out.println("Base di asta: " + this.asta.checkOffer());	
					else
						out.println("Offerta corrente: " + this.asta.checkOffer() + " di " + this.asta.retName());	
				}
				if(str.startsWith("OFFER")){
					StringTokenizer tk = new StringTokenizer(str);
					tk.nextToken();
					int off = Integer.parseInt(tk.nextToken());
					String nomeOff = tk.nextToken();
					
					if(asta.newOffer(off, nomeOff)) {
						out.println("OK");
					}
					else {
						out.println("KO");
					}
				}					
			}catch(Exception e) {
				System.out.println("Tempo scaduto, vincitore: " + asta.retName());
				break;
			}
		}
		try {socket.close();} 
		catch (IOException e) {}
	}

}
