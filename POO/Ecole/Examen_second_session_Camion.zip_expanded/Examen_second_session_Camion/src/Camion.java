import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class Camion {
	private int poidsMax;
	private int poidPris = 0;
	private double maxVolume;
	private double volumePris;
	
	//le prof nous demande d'utiliser une collection. le TreeSet est le plus approprié .
	private TreeSet<Materiel> SetMateriel =  new TreeSet<Materiel>();

	public Camion(int poidsMax, float maxVolume) {
		this.poidsMax = poidsMax;
		this.maxVolume = maxVolume;
		
	}

	public int getPoidsMax() {
		return this.poidsMax;
	}

	public double getMaxVolume() {
		return this.maxVolume;
	}

	public TreeSet<Materiel> getListeMateriel() {
		return this.SetMateriel;
	}
	
	
	
	public int getPoidPris() {
		return poidPris;
	}

	public void setPoidPris(int poidPris) {
		this.poidPris = poidPris;
	}

	public double getVolumePris() {
		return volumePris;
	}

	public void setVolumePris(double volumePris) {
		this.volumePris = volumePris;
	}


	public void setSetMateriel(TreeSet<Materiel> setMateriel) {
		SetMateriel = setMateriel;
	}

	public TreeSet<Materiel> getSetTrierParId(){
		return SetMateriel;
	}

	public TreeSet<Materiel>  getSetTrierParPoids(){
		TreeSet<Materiel>  listTrier = new TreeSet<Materiel> (new PoidsComparator());
		listTrier.addAll(SetMateriel);
		return listTrier;
	}

	public TreeSet<Materiel> getSetTrierParVolume(){
		TreeSet<Materiel>  listTrier = new TreeSet<Materiel> (new VolumeComparator());
		listTrier.addAll(SetMateriel);
		return listTrier;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(SetMateriel, maxVolume, poidPris, poidsMax, volumePris);
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
		return Objects.equals(SetMateriel, other.SetMateriel)
				&& Double.doubleToLongBits(maxVolume) == Double.doubleToLongBits(other.maxVolume)
				&& poidPris == other.poidPris && poidsMax == other.poidsMax
				&& Double.doubleToLongBits(volumePris) == Double.doubleToLongBits(other.volumePris);
	}


}
