package be.eafc;

public class Launcher {

	public static void main(String[] args) {
		StreamExampler ex = new StreamExampler();
		//ex.ecrire("c:/temp/streamExample", "ceci est un test!!!");
		ex.lire("c:/temp/streamExample");
		ex.afficherProperties();
	}

}
