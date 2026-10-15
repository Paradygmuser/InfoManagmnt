package eafc.enael;

import java.util.ArrayList;

public class Joueur {
	private ArrayList<String> mainJoueur = new ArrayList<String>();
	private int solde = 200;
	
	public void recevoirCarte( String e) {
			mainJoueur.add(e);
	}
	public int getSolde() {
	    return this.solde;
	}
	public ArrayList<String> getMain() {
		return mainJoueur;
	}
	public void hitCarte(String e) {
		mainJoueur.add(e);		
	}

}
