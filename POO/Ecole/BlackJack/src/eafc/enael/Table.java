package eafc.enael;

import java.util.ArrayList;

public class Table {
	Carte paquetDeCarte = new Carte();
	
	public boolean debutTour() {
		System.out.println("le tour commence, voulez vous misez a chien?(Y/N)???");
		String reponse ="" ;//console.Readline en java
		if(reponse=="Y") {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void distribuerCarte (Joueur j1) {
		j1.recevoirCarte(paquetDeCarte.carteDuHaut());
	}

}
