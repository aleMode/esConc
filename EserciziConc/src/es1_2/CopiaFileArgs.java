package es1_2;

import java.io.*;

public class CopiaFileArgs {
	public static void main(String[] args) throws IOException{
		FileReader rd;
		try{rd = new FileReader(args[0]);}
		catch(FileNotFoundException e){System.out.println(e); return;}
		
		FileWriter wr;
		try{wr = new FileWriter(args[1], false); wr.close();}
		catch(FileNotFoundException e){System.out.println(e); return;}
		
		try{wr = new FileWriter(args[1], true);}
		catch(FileNotFoundException e){System.out.println(e); return;}	
		
		char c;
		int counter = 0;
		
		while(rd.ready()) {
			c = (char) rd.read();
			wr.write(c);
			counter++;
		}
		wr.flush();

		System.out.println("File copiato, sono stati scritti " + counter + " caratteri");
	}

}
