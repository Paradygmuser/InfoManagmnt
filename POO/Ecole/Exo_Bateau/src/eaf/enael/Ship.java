package eaf.enael;

import java.util.ArrayList;

public class Ship {
	private int poidMax = 95000;
	private int placeMax = 100;
	private int poidIn;
	private int placeIn;	
	private ArrayList<Vehicule> listAuthorise = new ArrayList<Vehicule>(); //pour les vehicule entré
	public Ship (ArrayList<Vehicule> v) {
		for (Vehicule vv : v) {
			addVehicule(vv);			
		}		
	}	
	// tant que le nombre de poid et de place le permet rajoutte les a la liste.
	public void addVehicule(Vehicule v) {
		// Si  la somme du poid actuel(poidIn) et le poid du vehicule à ajouter sont plus petit que le poidMAx alors add, meme chose pour les place.
		if( (poidIn+v.getPoid()) <=poidMax && (placeIn+v.getPlace())<=placeMax ) {
			listAuthorise.add(v); //j'ajoute une voiutre à la liste
			poidIn += v.getPoid(); // j'incremente le poid d'entré par le dernier vehicule ajouter.
			placeIn += v.getPlace(); // j'incremente le place d'entré par le dernier vehicule ajouter.
						
			//controleur au cas où on a dépassé l'une des propriété placeMAx ou poidMax avec un OU logique non exclusif, car l'un ou l'autre ou les deux peuvent etre vrai.
			if(poidMax<poidIn | placeMax < placeIn) {
				removeLastVehicule();		
			}		
		}
	}	
	public void removeLastVehicule() {
		listAuthorise.removeLast();
	}	
	public String getContent() {
		int compteurC =0 ;
		int compteurV = 0;
		
		for(Vehicule v : listAuthorise) {
			if(v.jeSuis().equals("Car")) {
				compteurC ++;				
			}
			else if(v.jeSuis().equals("Van")) {
				compteurV ++;
			}			
		}
		return this.poidIn +" kilo et "+this.placeIn+" places. Il y a "+compteurC + " Voitures et "+ compteurV + " Camionettes";
	}

}
