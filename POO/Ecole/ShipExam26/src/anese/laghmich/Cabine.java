package anese.laghmich;

import java.util.Objects;

public class Cabine implements Comparable<Cabine> {
	private String identifiant, description;
	private int pont, nbrMax;
	private int nbrPersonnePresent;
	private Couleur couleur;
	
	public Cabine(String identifiant, Couleur couleur, int pont, int nbrMax, String description) {
		this.identifiant=identifiant;
		this.description=description;
		this.nbrMax=nbrMax;
		this.pont=pont;
		this.couleur=couleur;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getDescription() {
		return description;
	}

	public int getPont() {
		return pont;
	}

	public int getNbrMax() {
		return nbrMax;
	}

	public int getNbrPersonnePresent() {
		return nbrPersonnePresent;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, identifiant, nbrMax, nbrPersonnePresent, pont);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cabine other = (Cabine) obj;
		return Objects.equals(description, other.description) && Objects.equals(identifiant, other.identifiant)
				&& nbrMax == other.nbrMax && nbrPersonnePresent == other.nbrPersonnePresent && pont == other.pont;
	}

	@Override
	public int compareTo(Cabine o) {
		// TODO Auto-generated method stub
		return this.identifiant.compareTo(o.getIdentifiant());
	}

	public void setNbrPersonnePresent(int i) {
		this.nbrPersonnePresent=i;
		
	}
	
	

}
