package eafc.enael;

import java.util.ArrayList;

public class Carte {
	//private static String [] figures = {"A","J","Q","K"}; 
	private static String [] couleurs = {"♥","♦","♣","♠"}; // pour que les couleur soit toujour les meme et que personne n'y accede pour les changer
	private ArrayList<String> deck = new ArrayList<String>();
	private ArrayList<String> paquetMelanger = new ArrayList<String>();
	
	public ArrayList<String> creerPaquet() {		
		//int compteIndice = 0;
		for (int i=0 ; i<couleurs.length ; i++)
		{
			for (int a=0 ; a<=12 ; a++) // car il rest 9 valeur à inserer en dehor des figure, je ferais a chaque fois +1 pour que a la fin 9+1=10
			{
				switch (a) {
				    case 12 :
				    	deck.add("K-"+couleurs[i]);
				    	break;
				    case 11 :
				    	deck.add("Q-"+couleurs[i]);
				    	break;
				    case 10 :
				    	deck.add("J-"+couleurs[i]);
				    	break;
				    case 0 :
				    	deck.add("A-"+couleurs[i]);
				    	break;
				    default :
				    	deck.add((a+1)+"-"+couleurs[i]);				    	
				}			
				//compteIndice++;				
			}
		}
		return deck;
	}
	
	public ArrayList<String> melanger () {
		ArrayList<String> paquet = creerPaquet();		
		for (int i =0; i<52; i++)
		{
			int randomNum = (int)(Math.random() * paquet.size());
			paquetMelanger.add(paquet.get(randomNum));
			paquet.remove(randomNum);
			
		}		
		return paquetMelanger;		
	}
	
	public Carte () {
		melanger(); //le constructeur melange direct les cartes
	}
	
	public void affichePaquet() {
		for (int i = 0 ; i<paquetMelanger.size() ; i++) {
			System.out.println(paquetMelanger.get(i));
		}
		
	}
	
	// pour recuperer le paquet par les autre classe
	public ArrayList<String> getPaquet() {
		return paquetMelanger;
	}
	
	public String carteDuHaut() {
		
		return paquetMelanger.getFirst();
	}

}
