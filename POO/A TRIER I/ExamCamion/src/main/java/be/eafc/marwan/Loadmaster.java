package be.eafc.marwan;

public class Loadmaster {
	/*
	 * instance unique (Loadmaster)
	 */
	private static Loadmaster instance;
	
	/*
	 * constructeur privee
	 */
	private Loadmaster() {
		
	}
	
	/*
	 * Renvoie l'instance unique de Loadmaster
	 * Si aucune instance de Loadmaster est cree alors on l'initialise
	 */
	public static Loadmaster getInstance() {
		if(instance == null) {
			instance = new Loadmaster();
		}
		return instance;
	}
	
	
	public void charger(Camion camion, Chargeable materiel) throws MaxWeightReachedException {
		if(camion.getPoidsChargement() + materiel.getPoids() > camion.getPoidsMax()) {
			throw new MaxWeightReachedException("poids max atteint! Impossible de charger " + materiel.getId(), materiel);
		}
		
		camion.addChargeable(materiel);
	}
	
	public boolean decharger(Camion camion, Chargeable materiel) {
		return camion.removeChargeable(materiel);
	}
}
