package be.eafc.marwan;

import java.util.ArrayList;
import java.util.List;

public class Camion {
	private int poidsMax;
	private double volumeMax;
	private List<Chargeable> chargement;
	
	public Camion(int poidsMax, double volumeMax) {
		this.poidsMax = poidsMax;
		this.volumeMax = volumeMax;
		this.chargement = new ArrayList<Chargeable>();
	}
	
	public int getPoidsMax() {
		return poidsMax;
	}
	
	public double getVolumeMax() {
		return volumeMax;
	}
	
	public double getPoidsChargement() {
		double res = 0;
		for(Chargeable c : chargement) {
			res += c.getPoids();
		}
		return res;
	}
	
	public double getVolumeChargement() {
		double res = 0;
		for(Chargeable c : chargement) {
			res += c.getVolume();
		}
		return res;
	}
	
	public List<Chargeable> getChargementTrieParId() {
	    List<Chargeable> res = new ArrayList<Chargeable>(chargement);
	    res.sort(new ComparatorParId());
	    return res;
	}
	
	public List<Chargeable> getChargementTrieParPoids(){
		List<Chargeable> res = new ArrayList<Chargeable>(chargement);
		res.sort(new ComparatorParPoids());
		return res;
	}
	
	public List<Chargeable> getChargementTrieParVolume(){
		List<Chargeable> res = new ArrayList<Chargeable>(chargement);
		res.sort(new ComparatorParVolume());
		return res;
	}
	
	void addChargeable(Chargeable materiel) {
		chargement.add(materiel);
	}
	
	boolean removeChargeable(Chargeable materiel) {
		return chargement.remove(materiel);
	}

	@Override
	public String toString() {
		return "Camion [poidsMax=" + poidsMax + ", volumeMax=" + volumeMax + ", chargement=" + chargement + "]";
	}
}
