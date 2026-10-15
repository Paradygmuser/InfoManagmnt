package be.eafc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class StreamExampler {

	private Properties pokeProps = new Properties();
	
	public StreamExampler() {
		try {
			pokeProps.load(new BufferedReader(new FileReader("c:/temp/pokemon.props")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ecrire(String nomFichier,String contenu) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(nomFichier))) {
			bw.write(contenu);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void lire(String nomFichier) {
		try(BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
			String line = "";
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void afficherProperties() {
		String bb = pokeProps.getProperty("xt");
		System.out.println(bb);
	}
}
