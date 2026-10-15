package enael.eafc;

import java.util.Objects;

public abstract class ChargeableMaterial implements Comparable<ChargeableMaterial>{
	protected int poid;
	protected float volume;
	protected String identifiant; //tout les classe qui herite de cette classe on acces aux attributs
	
	public String getIdentifiant() {
		return identifiant;
	}
	public int getPoid() {
		return poid;
	}
	public float getVolume() {
		return volume;
	}
	@Override
	public int hashCode() {
		return Objects.hash(identifiant, poid, volume);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChargeableMaterial other = (ChargeableMaterial) obj;
		return Objects.equals(identifiant, other.identifiant) && poid == other.poid
				&& Float.floatToIntBits(volume) == Float.floatToIntBits(other.volume);
	}
	@Override
	public int compareTo(ChargeableMaterial o) {
		// TODO Auto-generated method stub
		return this.identifiant.compareTo(o.getIdentifiant());
	}
}
