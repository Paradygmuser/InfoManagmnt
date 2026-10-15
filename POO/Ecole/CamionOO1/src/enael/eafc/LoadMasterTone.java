package enael.eafc;

import java.util.TreeSet;

public class LoadMasterTone {
	private static volatile LoadMasterTone instance;
	private LoadMasterTone() {}
	/**
	 * SingleTone.getInstance() comme vu dans les slide du cours
	 * @return l'instance du singletone en forcant le thread.
	 */
	public static LoadMasterTone getInstance() {
		if(instance==null) {
			synchronized(LoadMasterTone.class) {
				if(instance==null) {
					instance= new LoadMasterTone();
				}
			}
		}
		return instance;
	}
	
	public void ajouterMaterielCamion(Camion camion, ChargeableMaterial...chargables) throws MaxWeightReachedException, MaxVolumeReachedException {
		for(ChargeableMaterial chargable : chargables) {
			if(camion.getPoidPris()+chargable.getPoid()>camion.getPoidMax()) {
				throw new MaxWeightReachedException(chargable.getIdentifiant()+"le chargable ne peux etre charger dans le camion : "+ camion.getPlaque() +" car sont poid est trop lourd");
			}
			else if (camion.getVolumePris()+chargable.getVolume()>camion.getVolumeMax()){
				throw new MaxVolumeReachedException(chargable.getIdentifiant()+"le chargable ne peux etre charger dans le camion : "+ camion.getPlaque() +" car sont volume est trop lourd");
			}
			else {
				camion.getCollectionCamion().add(chargable);
				System.out.println(chargable.getIdentifiant()+" a été chargé");
				camion.setPoidPris(chargable.getPoid()+camion.getPoidPris());
				camion.setVolumePris(chargable.getVolume()+camion.getVolumePris());
			}
		}
	}
	public void donnerPoidCharger(Camion camion) {
		System.out.println("Le poid du camion est de : "+ camion.getPoidPris()+" kg");
	}
	public void donnerVolumeCharger(Camion camion) {
		String volumeString = String.format("%.2f",camion.getVolumePris());
		System.out.println("Le volume du camion est de : "+ volumeString+" m3");
	}
	public void afficherListeParId(Camion camion) {
		for(ChargeableMaterial chargable : camion.getCollectionCamion() ) {
			System.out.println("identifiant : "+chargable.identifiant+", volume : "+chargable.getVolume()+" m3, poid : "+chargable.getPoid()+" kg");
		}
	}
	public void afficherListeParPoid(Camion camion) {
		TreeSet<ChargeableMaterial> nvxSet = new TreeSet<ChargeableMaterial>(new ComparatorMaterielPoid());
		nvxSet.addAll(camion.getCollectionCamion());
		for(ChargeableMaterial chargable : nvxSet ) {
			System.out.println("identifiant : "+chargable.identifiant+", volume : "+chargable.getVolume()+" m3, poid : "+chargable.getPoid()+" kg");
		}
	}
	public void afficherListeParVolume(Camion camion) {
		TreeSet<ChargeableMaterial> nvxSet = new TreeSet<ChargeableMaterial>(new ComparatorMaterielVolume());
		for(ChargeableMaterial chargable : camion.getCollectionCamion() ) {
			System.out.println("identifiant : "+chargable.identifiant+", volume : "+chargable.getVolume()+" m3, poid : "+chargable.getPoid()+" kg");
		}
	}
	

}
