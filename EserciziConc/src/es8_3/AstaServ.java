package es8_3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class AstaServ extends Thread{
	
	private Asta asta;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public AstaServ(Asta a, Socket s) throws IOException {
		this.asta = a;
		this.socket=s;
		this.in = new ObjectInputStream (socket.getInputStream());
		this.out = new ObjectOutputStream(socket.getOutputStream());
		start();
	}
	
	public void run() {
		while(true) {
			String str = "";
			try {
				str = (String) in.readObject();
				
				if(str.equals("END")) 
					break;
				if(str.equals("READ")) {
					if(this.asta.retName() == null) {
						String tmp = "Base di asta: " + this.asta.checkOffer();
						out.writeObject(tmp);	
					}
					else {
						String tmp = "Offerta corrente: " + this.asta.checkOffer() + " di " + this.asta.retName();
						out.writeObject(tmp);	
					}
				}
				if(str.startsWith("OFFER")){
					StringTokenizer tk = new StringTokenizer(str);
					tk.nextToken();
					int off = Integer.parseInt(tk.nextToken());
					String nomeOff = tk.nextToken();
					
					if(asta.newOffer(off, nomeOff)) {
						out.writeObject("OK");
					}
					else {
						out.writeObject("KO");
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
