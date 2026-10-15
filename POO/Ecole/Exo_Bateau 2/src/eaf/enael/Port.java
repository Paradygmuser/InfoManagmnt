package eaf.enael;

import java.util.ArrayList;

public class Port {
	// HORS ENNONCER ? ajouter a la liste direcetement avec l'ouverture d'une file imaginaire ou les voiture demandant a rentrer sont lister..
	private ArrayList<Vehicule> listeDemande = new ArrayList<Vehicule>();
	
	public Port (int a){
		for (int i=0 ; i<a; i++ ) {
			listeDemande.add(new Car());
			listeDemande.add(new Van());
		}		
	}
	
	public ArrayList<Vehicule> getListeDemande () {
		return this.listeDemande;
	}

}
