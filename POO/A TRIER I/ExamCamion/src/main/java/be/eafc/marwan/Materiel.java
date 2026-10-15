package be.eafc.marwan;

public class Materiel implements Chargeable {
	private String id;
	private double poids;
	private double volume;
	private TypeMat typeMateriel;
	
	public Materiel(String id, double poids, double volume, TypeMat typeMateriel) {
		this.id = id;
		this.poids = poids;
		this.volume = volume;
		this.typeMateriel = typeMateriel;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public double getPoids() {
		// TODO Auto-generated method stub
		return poids;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return volume;
	}
	
	@Override
	public String toString() {
		return "Materiel [id: " + id + ", poids: " + poids + "kg, voume:" + volume + "m3, type materiel:" + typeMateriel + "]";
	}
}
