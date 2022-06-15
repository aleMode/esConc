package es1_4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Testo {

	private File nomeFile;
	
	public Testo (File file) {
		nomeFile = file;
	}
	
	public int numeroParole() throws IOException {
		FileReader rd = new FileReader(nomeFile);
		int parole = 0;
		char letto;
		
		while(rd.ready()) {
			letto = (char) rd.read();
			if(letto == ' ') parole++;
		}
		rd.close();
		return parole;
	}
	
	public int numeroParoleDistinte() throws IOException {
		FileReader rd = new FileReader(nomeFile);
		int parole = 0;
		char letto;
		ArrayList<String> lista = new ArrayList<String>();
		String parolaCorr = "";
		
		while(rd.ready()) {
			letto = (char) rd.read();
			
			if(letto != ' ') 
				parolaCorr += letto;
			else {
				if(lista.contains(parolaCorr)) parolaCorr = "";
				else {
					lista.add(parolaCorr);
					parole++;
				}
			}
		}
		
		rd.close();
		return parole;
	}
	
	public int contaOccorrenzeParola(String daCercare) throws IOException {
		FileReader rd = new FileReader(nomeFile);
		int occorr=0;
		char letto;
		String parolaCorr = "";

		while(rd.ready()) {
			letto = (char) rd.read();
			
			if(letto != ' ') 
				parolaCorr += letto;
			else {
				if(parolaCorr.equals(daCercare))
					occorr++;
				parolaCorr = "";
			}
		}
		
		return occorr;
	}
	
	public LinkedList<String> paroleDistinteInOrdineAlfabetico() throws IOException{
		FileReader rd = new FileReader(nomeFile);
		LinkedList<String> lista = new LinkedList<String>();
		
		char letto;
		String parolaCorr = "";
	
		while(rd.ready()) {
			letto = (char) rd.read();
			
			if(letto != ' ') 
				parolaCorr += letto;
			else {
				if(lista.contains(parolaCorr)) parolaCorr = "";
				else lista.add(parolaCorr);
			}
		}
		
		rd.close();
		
		String[] tmp = lista.toArray(new String[0]);
		Arrays.sort(tmp);
		LinkedList<String> listaOrd = new LinkedList<String>(Arrays.asList(tmp));
		
		return listaOrd;
	}
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\alemo\\eclipse-workspace\\EserciziConc\\bin\\es1_4\\prova.txt");
		Testo a = new Testo(file);
		System.out.println("Numero di parole: " + a.numeroParole());
		System.out.println("Numero di parole distinte: " + a.numeroParoleDistinte());
		System.out.println("Occorrenze della parola numero: " + a.contaOccorrenzeParola("numero"));
		System.out.println("Lista delle parole del testo: " + a.paroleDistinteInOrdineAlfabetico().toString());
	}

}
