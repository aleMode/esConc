package es3_4;

import es3_4.ThreadCond;

public class mainRes {

	public static void main(String[] args) {
		Res resource = new Res();
		
		ThreadCond a = new ThreadCond(resource, "Antonio");
		ThreadCond b = new ThreadCond(resource, "Balenciago");

		a.start();
		b.start();
	}
}
