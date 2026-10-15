package anese.laghmich;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Bateau {
	private volatile static Bateau instance;
	
	private Bateau() {
		
	}
	
	public static Bateau getInstance() {
		if(instance==null) {
			synchronized(Bateau.class) {
				if(instance==null) {
					instance=new Bateau();
				}
			}
		}
		return instance;
	}
	
	private TreeMap<Cabine, TreeSet<Personne>> bateauCollection = new TreeMap<Cabine, TreeSet<Personne>>();
	
	public void ajouterCabine(Cabine...cabines) {
		for(Cabine cabine : cabines) {
			if(!bateauCollection.containsKey(cabine)) {
				bateauCollection.put(cabine, new TreeSet<Personne>());
			}
		}
	}
	
	public void ajouterPersonne(Cabine cabine, Personne...personnes) throws CabineFullException {
		for(Personne personne : personnes) {
			if(1+cabine.getNbrPersonnePresent()>cabine.getNbrMax()) {
				throw new CabineFullException("AJOUT IMPOSSIBLE");
			}
			else {
				bateauCollection.get(cabine).add(personne);
				cabine.setNbrPersonnePresent(cabine.getNbrPersonnePresent()+1);
			}
		}
	}
	public int nbrPersonneABord() {
		int result=0;
		for(Entry<Cabine, TreeSet<Personne>> ligne : bateauCollection.entrySet()) {
			for(Personne p : ligne.getValue()) {
				result++;				
			}
		}
		return result;
	}
	public Set<Entry<Cabine, TreeSet<Personne>>> fournirPersonneParIDChambre(){
		return bateauCollection.entrySet();
	}
	
	public TreeSet<Reservation> afficherPErsonneParNom(){
		TreeSet<Reservation> setReserv = new TreeSet<Reservation>();
		for(Entry<Cabine, TreeSet<Personne>> ligne : bateauCollection.entrySet()) {
			for(Personne personne : ligne.getValue()) {
				setReserv.add(new Reservation(personne, ligne.getKey()));
			}
		}
		return setReserv;
	}
	
	public TreeSet<Reservation> afficherPErsonneMoin18ParNom(){
		TreeSet<Reservation> setReserv = new TreeSet<Reservation>();
		for(Entry<Cabine, TreeSet<Personne>> ligne : bateauCollection.entrySet()) {
			for(Personne personne : ligne.getValue()) {
				if(personne.donnerSonAge()<18) {
					setReserv.add(new Reservation(personne, ligne.getKey()));
				}
			}
		}
		return setReserv;
	}

}
