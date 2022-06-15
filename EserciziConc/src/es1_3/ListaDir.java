package es1_3;

import java.io.*;
import java.util.Arrays;

public class ListaDir {

	public static void main(String[] args) {

		File elem;
		if(args.length != 0){elem = new File(args[0]);}
		else {elem = new File(".");}
		
		if(elem.isFile()) {
			System.out.println(elem.getAbsolutePath());
			System.out.println(elem.length());
		}
		if(elem.isDirectory()) System.out.println(Arrays.toString(elem.list()));
			
			
	}

}
