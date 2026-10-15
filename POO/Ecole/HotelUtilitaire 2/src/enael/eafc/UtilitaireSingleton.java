package enael.eafc;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class UtilitaireSingleton {
	
	/**
	 * Cette Classe est l'utilitaire de l'utilisateur pour pouvoir imporimer a la console les different retour de methode
	 * Je profite de l'ennoncé opur en faire une singleton pattern où seul l'utilisateur utilisera l'objetHotel et ses methodes. 
	 * @hotelDante est une variable ou j'instancie un Hotel.	 * 
	 * @ajouterChambre est une methode permettant d'ajouter une chambre.
	 * @ajouterUnePersonneChambre est une methode qui attend une chambre en entré de parmatre formel et une ou plusieurs personne pour cette chambre
	 * @listerPersonneParChambre est une methode se reposant sur l'heritage des interface Comparable sur Chambre et Personne, qui elle meme pocede le toString, il devient facile de leur donner un trie par defaul.
	 * 
	 */
	private volatile static UtilitaireSingleton instance;
	private Hotel hotelDante =  new Hotel();	
	private UtilitaireSingleton(){
	}	
	public static UtilitaireSingleton getInstance() {
		if(instance==null) {
			synchronized (UtilitaireSingleton.class) {
				if(instance==null) {
					instance = new UtilitaireSingleton();
				}
			}
		}
		return instance;		
	}	

	public void ajouterDesChambre(Chambre...chambreFormel ) {
		
		hotelDante.ajouterChambre(chambreFormel);
		for(Chambre chambreBoucle : chambreFormel) {
			System.out.println("La chambre " + chambreBoucle.getIdentifiant() + " est ajouter");
		}
		System.out.println("\n*************\n");
	}
	
	public void ajouterUnePersonneChambre( Chambre c, Personne... personneFormel) {
		
		for(Personne personneBoucle : personneFormel) {
			try {
				hotelDante.ajoutePersonneToChambre(c, personneBoucle);
				System.out.println("La personne "
				                    + personneBoucle.getNom()+ " " + personneBoucle.getPrenom()
				                    +" a ete ajouter a la chambre id : "+c.getIdentifiant());
			} catch (ChambreFullException e) {
				System.out.println("La personne " + personneBoucle.getNom()+" "+personneBoucle.getPrenom()
				                   + " n'a pas pu etre ajouter a la chambre id : " + c.getIdentifiant());
			}		
		}
		System.out.println("\n*************\n");		
	}
	
	public void listerPersonneParChambre() {
		Set<Entry<Chambre, TreeSet<Personne>>> listeHotel= hotelDante.listerPersonneParChambre();
		for(Entry<Chambre, TreeSet<Personne>> ligne : listeHotel) {
			System.out.println("Chambre id: "+ligne.getKey().getIdentifiant()+"  | ");
			for(Personne p : ligne.getValue()) {
				System.out.println("    "+p.getNom()+" "+ p.getPrenom() + " | information complete ->" + p.toString());
			}
		}
		System.out.println("\n*************\n");
	}
	
	public void listerPersonneParNom() {
		Set<Entry<Personne, Chambre>> listeHotel= hotelDante.listerPersonneParNom().entrySet();
		for(Entry<Personne, Chambre> ligne : listeHotel) {
			System.out.println(ligne.getKey().getNom()+" "+ligne.getKey().getPrenom()+" | Chambre id : "+ligne.getValue().getIdentifiant()+" | information complete ->" + ligne.getKey().toString());
		}
		System.out.println("\n*************\n");
	}
	
	public void listerMoinDe18() {
		if(hotelDante.personneMoind18().size()==0) {
			System.out.println("Il n'y a personne en dessous de 18 ans.");
		}
		else {
			for(Personne p : hotelDante.personneMoind18()) {
				System.out.println(p.getNom()+" "+ p.getPrenom() + " | information complete ->" + p.toString());
			}			
		}
		System.out.println("\n*************\n");
	}
}
