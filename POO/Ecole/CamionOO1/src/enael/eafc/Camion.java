package enael.eafc;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Camion {
	private int poidMax, poidPris;
	private float volumeMax, volumePris;
	private String plaque;
	private TreeSet<ChargeableMaterial> collectionCamion = new TreeSet<ChargeableMaterial>();
	
	public Camion(int poidMax, float volumeMax, String plaque) {
		this.plaque=plaque;
		this.poidMax=poidMax;
		this.volumeMax=volumeMax;
	}

	public int getPoidMax() {
		return poidMax;
	}

	public int getPoidPris() {
		return poidPris;
	}

	public float getVolumeMax() {
		return volumeMax;
	}

	public float getVolumePris() {
		return volumePris;
	}

	public String getPlaque() {
		return plaque;
	}
	
	

	public void setPoidPris(int poidPris) {
		this.poidPris = poidPris;
	}

	public void setVolumePris(float volumePris) {
		this.volumePris = volumePris;
	}

	public Set<ChargeableMaterial> getCollectionCamion() {
		return collectionCamion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(plaque);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camion other = (Camion) obj;
		return Objects.equals(plaque, other.plaque);
	}
	
}
