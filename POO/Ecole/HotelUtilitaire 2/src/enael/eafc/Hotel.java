package enael.eafc;

import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Hotel {
	private TreeMap<Chambre, TreeSet<Personne>> collectionHotel = new TreeMap<Chambre, TreeSet<Personne>>();
//	ERREUR A NE PAS FAIRE -> private TreeSet<Personne> collectionPersonnes = new TreeSet<Personne>(); // ERREUR CAR C4EST LE MEME TREESET QUI EST RAJOUTER A TOUTE LES CHAMBRES
	
	public void ajouterChambre(Chambre... c) {		
		for(Chambre chbrUnique : c) {
			collectionHotel.put(chbrUnique, new TreeSet<Personne>());
		}		
	}
	
	public void ajoutePersonneToChambre(Chambre c, Personne p) throws ChambreFullException  {
				c.peuxAccueillir(collectionHotel.get(c).size()); //c'est dans la methode peux acceuillir que j'ai le lanceur d'exception.
				collectionHotel.get(c).add(p);	
	}
	
	public int fournirNbrePersonne() { // pour tout l'hotel
		int nbrPersonnePresent=0;
		for(Chambre c : collectionHotel.keySet()) {
			for(Personne p : collectionHotel.get(c)) {
				nbrPersonnePresent++;
			}
		}
		return nbrPersonnePresent;		
	}
	//surcharge de methode, si l'utilisateur veut une seul chambre ou plusieur chambre
    public int fournirNbrePersonne(Chambre... chambreFormel) {
    	int nbrPersonnePresent=0;
		for(Chambre c : chambreFormel) {
			for(Personne p : collectionHotel.get(c)) {
				nbrPersonnePresent++;
			}
		}
		return nbrPersonnePresent;
	}
    
    public TreeSet<Personne> personneMoind18(){	
    	TreeSet<Personne> collectionPersonnesMoin18 = new TreeSet<Personne>(); // liiste que je prepare pour y ranger les personne en dessous de 18 ans.
    	Set< Entry<Chambre, TreeSet<Personne>>>  entryHotel = collectionHotel.entrySet();  	
    	
    	for(Entry<Chambre, TreeSet<Personne>> ligne : entryHotel) {
    		/////////////
    		for(Personne p : ligne.getValue()) {
    			if(p.donnerSonAge()<18) {
    				collectionPersonnesMoin18.add(p);
    			}
    		}
    	}    	
		return collectionPersonnesMoin18;    	
    }
    public Set<Entry<Chambre, TreeSet<Personne>>>  listerPersonneParChambre() {
    	//la chambre est la clef de la map elle est donc deja trié par defaut dans le comparable de chambre.
    	Set< Entry<Chambre, TreeSet<Personne>>>  entryHotel = collectionHotel.entrySet();
    	return entryHotel; // on retourne la Map vers l'utilisateur qui fera les toString
    }
    
    public TreeMap<Personne, Chambre> listerPersonneParNom() {
        // comme chaque personne ce voit attribuer un identifiant unique je peux etre sur que chaque instance est unique.
    	Set< Entry<Chambre, TreeSet<Personne>>>  entryHotel = collectionHotel.entrySet();
    	TreeMap<Personne, Chambre> nouvelleMap = new TreeMap<Personne, Chambre>();

    	for(Entry<Chambre, TreeSet<Personne>> ligne : entryHotel) {
    		for(Personne p : ligne.getValue()) {
    			nouvelleMap.put(p, ligne.getKey());
    		}
	    }
	    return nouvelleMap; // on retourne la Map vers l'utilisateur qui fera les toString    	
    }

	@Override
	public String toString() {
		return "Hotel [collectionHotel=" + collectionHotel + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(collectionHotel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(collectionHotel, other.collectionHotel);
	}

	public TreeMap<Chambre, TreeSet<Personne>> getCollectionHotel() {
		return collectionHotel;
	}
    
    
}
