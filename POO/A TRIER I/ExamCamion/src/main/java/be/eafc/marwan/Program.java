package be.eafc.marwan;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		Loadmaster lm = Loadmaster.getInstance();
		Camion c = new Camion(1000, 10.0);
		
		Materiel m1 = new Materiel("MAT-C", 200, 2.0, TypeMat.PALETTE);
		Materiel m2 = new Materiel("MAT-A", 300, 3.5, TypeMat.VRAC);
		Materiel m3 = new Materiel("MAT-B", 150, 1.5, TypeMat.PALETTE);
		Materiel m4 = new Materiel("MAT-X", 900, 1.0, TypeMat.VRAC);
		
		try {
			lm.charger(c, m1);
			lm.charger(c, m2);
			lm.charger(c, m3);
			lm.charger(c, m4); // erreur
		} catch(MaxWeightReachedException e) {
			System.err.println(e.getMessage());
		}
		
		List<Chargeable> res = new ArrayList<>();
		System.out.println("=== Tri par ID ===");
		res = c.getChargementTrieParId();
		for(Chargeable r : res) {
			System.out.println(r);
		}
		
		System.out.println("=== Tri par poids ===");
		res = c.getChargementTrieParPoids();
		for(Chargeable r : res) {
			System.out.println(r);
		}
		
		System.out.println("=== Tri par volume ===");
		res = c.getChargementTrieParVolume();
		for(Chargeable r : res) {
			System.out.println(r);
		}
	}
}
