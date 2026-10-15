import java.util.Objects;

public abstract class Materiel implements Chargeable, Comparable<Materiel> {

	private String id;
	private int poids;
	private double volume;

	public Materiel(String id, int poids, double volume) {
		this.id = id;
		this.poids = poids;
		this.volume = volume;
	}

	@Override
	public String getId() {

		return this.id;
	}

	@Override
	public int getPoids() {
		return this.poids;
	}

	@Override
	public double getVolume() {
		return this.volume;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, poids, volume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materiel other = (Materiel) obj;
		return Objects.equals(id, other.id) && poids == other.poids
				&& Double.doubleToLongBits(volume) == Double.doubleToLongBits(other.volume);
	}

	@Override
	public int compareTo(Materiel o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}	
}
