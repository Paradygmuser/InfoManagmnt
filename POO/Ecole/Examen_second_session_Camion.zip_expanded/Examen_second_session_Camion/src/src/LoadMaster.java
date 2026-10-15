package src;
public class LoadMaster {
	
	/** 
	 * L'instance unique de la classe 
	 */
	private static LoadMaster instance;
	
	/**
	 * Constructeur prive - empeche le new LoadMaster() de l'exterieur  
	 */
	private LoadMaster() {}
	
	/**
	 * 
	 *  Retourne l'unique instance, la cree si elle n'existe pas encore 
	 */
	public static LoadMaster getInstance() {
		if(instance==null) {
			instance=new LoadMaster();
		}
		return instance;	
	}
	
	
	public void chargerUnMateriel(Camion camion, Materiel materiel) throws MaxVolumeReachedException, MaxWeightReachedException {
	    if((camion.getPoidPris()+materiel.getPoids())<=camion.getPoidsMax() && camion.getVolumePris()+materiel.getVolume()<=camion.getMaxVolume()) {
	    	camion.getListeMateriel().add(materiel);
	    	camion.setPoidPris(materiel.getPoids()+camion.getPoidPris());
	    	camion.setVolumePris(materiel.getVolume()+camion.getVolumePris());
	    }
	    else {
	    	if(camion.getPoidPris()>(camion.getPoidsMax()-materiel.getPoids())) {
	    		throw new MaxWeightReachedException("le poid est depasser");
	    	}
	    	else {
	    		throw new MaxVolumeReachedException("le volume est depasser");
	    	}
	    }
	}
	
	public void decharger(Camion camion, Materiel materiel) {
		camion.getListeMateriel().remove(materiel);
		camion.setPoidPris(camion.getPoidPris()-materiel.getPoids());
		camion.setVolumePris(camion.getVolumePris()-materiel.getVolume());
	}
	
	public void afficherParID(Camion camion) {
		for( Materiel m : camion.getListeMateriel()) {
			System.out.println(m.toString());
		}
	}

	
	public void afficherParPoid(Camion camion) {
		for( Materiel m : camion.getSetTrierParPoids()) {
			System.out.println(m.toString());
		}
	}

	public void afficherParVolume(Camion camion) {
		for( Materiel m : camion.getSetTrierParPoids()) {
			System.out.println(m.toString());
		}
	}

}
